package ksmart.ks48team01.common;

import ksmart.ks48team01.dto.ContentsFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

    public List<ContentsFile> parseFileInfo(String contentsId, MultipartHttpServletRequest
            multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;
        }

        List<ContentsFile> fileList = new ArrayList<ContentsFile>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "images/" + current.format(format);
        File file = new File(path);
        if(file.exists() == false) {
            file.mkdirs();
        }

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName, originalFileExtension, contentType;

        while(iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for(MultipartFile multipartFile : list) {
                if(multipartFile.isEmpty() == false) {
                    contentType = multipartFile.getContentType();
                    if(ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        if(contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if(contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if(contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }

                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    ContentsFile contentsFile = new ContentsFile();
                    contentsFile.setContentsId(contentsId);
                    contentsFile.setFileSize(multipartFile.getSize());
                    contentsFile.setFileName(multipartFile.getOriginalFilename());
                    contentsFile.setFilePath(path + "/" + newFileName);
                    fileList.add(contentsFile);

                    file = new File(path + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return fileList;
    }
}
