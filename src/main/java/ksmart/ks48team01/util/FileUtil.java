package ksmart.ks48team01.util;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.ContentsFile;
import ksmart.ks48team01.user.controller.ContentsController;
import ognl.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    @Value("/home/springboot/")
    private String fileRealPath;

    public ContentsFile parseFileInfo(MultipartFile uploadFile) {
        log.info("uploadFile: {}", uploadFile);

        // 날짜 패턴
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 현재 날짜(디렉토리 명)
        ZonedDateTime current = ZonedDateTime.now();

        // 파일idx, 파일 타입, 헤더안의 콘텐츠의 실제 콘텐츠 유형, 파일 경로, 디렉토리 분류
        String fileCode, originalFileExtension, contentType, path, directory;

        ContentsFile contentsFile = new ContentsFile();
        if(uploadFile.isEmpty() == false) {
            contentType = uploadFile.getContentType();
            //contentType(String)을 null인지 길이가 0인지 공백인지 등을 검사함
            if(!ObjectUtils.isEmpty(contentType)) {
                // 콘텐츠 이미지 파일 타입별 분류 ( 이미지, file폴더 구분
                if(contentType.indexOf("image/") > -1) {
                    if(contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    } else if(contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    } else if(contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    } else if(contentType.contains("webp")) {
                        originalFileExtension = ".webp";
                    }
                    //File.separator는 운영체제에 맞는 디렉터리 구분자를 알아서 할당해줌
                    directory = "images" + File.separator;
                } else {
                    directory = "files" + File.separator;
                }

                String os = System.getProperty("os.name").toLowerCase();

                if(os.contains("mac")) fileRealPath = "/Users/Shared" + fileRealPath;

                System.out.println("fileRealPath: " + fileRealPath);

                // Paths 클래스를 통한 파일의 경로 ( 주소의 / 경로와 실제 os의 경로 \ 와 차이)
                path = Paths.get(fileRealPath + "resources/" + directory + current.format(format)).toString();

                // 파일 경로 셋팅
                File file = new File(path);

                // 파일 디렉토리 없을 경우 디렉토리생성
                if(file.exists() == false) {
                    file.mkdirs();
                }

                // 파일 명이 겹치지 않게 파일명 설정
                String resultFileName = "";
                String[] fileNameSplit = uploadFile.getOriginalFilename().split("\\.");

                log.info("fileNameSplit: {}", fileNameSplit);

                for(int i=0; i<fileNameSplit.length; i++) {
                    if(i == (fileNameSplit.length-1)) {
                        fileNameSplit[i] = "." + fileNameSplit[i];
                    } else {
                        // 파일명 안겹치기 위해 System.nanoTime 이용
                        fileNameSplit[i] = fileNameSplit[i].replaceAll("\\s", "") + Long.toString(System.nanoTime());
                    }
                    resultFileName += fileNameSplit[i];
                }

                // 파일의 업로드 경로 설정
                byte[] bytes;
                Path uploadPath = Paths.get(path + "/" + resultFileName);

                try {
                    bytes = uploadFile.getBytes();
                    //실제 서버에 파일 정보를 바이트 형태로 출력함
                    Files.write(uploadPath, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                // db 테이블에 삽입할 데이터 추려서 객체로 세팅
                fileCode = "file_" + current.format(format) + Long.toString(System.nanoTime());
                log.info("fileCode: {}", fileCode);
                contentsFile.setFileCode(fileCode);
                contentsFile.setFileSize(uploadFile.getSize());
                contentsFile.setFileName(uploadFile.getOriginalFilename());
                contentsFile.setFilePath("resources" + File.separator + directory + current.format(format) + File.separator + resultFileName);
                String filePath = contentsFile.getFilePath();
                int filePathLength = filePath.length();

                String fileExt = filePath.substring(filePathLength - 4, filePathLength);

                if(!fileExt.contains("webp")) {
                    fileExt = fileExt.substring(1, 4);
                }
                contentsFile.setFileExt(fileExt);
            }
        }

        return contentsFile;
    }
}
