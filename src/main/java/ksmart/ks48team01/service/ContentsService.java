package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.*;
import ksmart.ks48team01.mapper.ContentsMapper;
import ksmart.ks48team01.user.controller.ContentsController;
import ksmart.ks48team01.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContentsService {
    private static final Logger log = LoggerFactory.getLogger(ContentsController.class);
    private final ContentsMapper contentsMapper;
    private final FileUtil fileUtil;

    public ContentsService(ContentsMapper contentsMapper, FileUtil fileUtil) {
        this.contentsMapper = contentsMapper;
        this.fileUtil = fileUtil;
    }

    public Map<String, Object> getContentsInfoList(int currentPage, String tabValue) {

        //보여줄 컨텐츠의 개수
        int contentsPerPage = 12;

        // 보여줄 행의 시작점
        int startContentsNum = (currentPage - 1) * contentsPerPage;

        switch(tabValue) {
            case "공연" :
                tabValue = "A01";
                break;
            case "전시" :
                tabValue = "A02";
                break;
            case "영화" :
                tabValue = "A03";
                break;
            case "도서" :
                tabValue = "A04";
                break;
            case "관광" :
                tabValue = "B01";
                break;
            case "체육" :
                tabValue = "C01";
                break;
            case "디지털 컨텐츠" :
                tabValue = "D01";
                break;
            default:
                tabValue = "all";
                break;
        }

        // 각 탭의 컨텐츠 개수
        double contentsCnt = contentsMapper.getContentsByTabCnt(tabValue);

        // 마지막페이지 (각 탭의 컨텐츠 개수/보여줄 컨텐츠의 갯수) 올림
        int lastPage = (int)Math.ceil(contentsCnt/contentsPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if(currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if(endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoList(startContentsNum, contentsPerPage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("contentsInfoList", contentsInfoList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("contentsCnt", contentsCnt);

        return resultMap;
    }

    public Map<String, Object> getContentsInfoList(int currentPage) {

        //보여줄 컨텐츠의 개수
        int contentsPerPage = 12;

        // 보여줄 행의 시작점
        int startContentsNum = (currentPage - 1) * contentsPerPage;

        // 각 탭의 컨텐츠 개수
        double contentsCnt = contentsMapper.getContentsByTabCnt("all");

        // 마지막페이지 (각 탭의 컨텐츠 개수/보여줄 컨텐츠의 갯수) 올림
        int lastPage = (int)Math.ceil(contentsCnt/contentsPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if(currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if(endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoList(startContentsNum, contentsPerPage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("contentsInfoList", contentsInfoList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("contentsCnt", contentsCnt);

        return resultMap;
    }

    public List<StoreCategory> getStoreCategory() {
        return contentsMapper.getStoreCategory();
    }

    public List<ContentsCategory> getContentsCategory() {
        List<ContentsCategory> contentsCategoryList = contentsMapper.getContentsCategory();

        return contentsCategoryList;
    }

    public Map<String, Object> getContentsInfoListByTabValue(int currentPage, String tabValue) {
        log.info("tabValue {}", tabValue);
        //보여줄 컨텐츠의 개수
        int contentsPerPage = 12;

        // 보여줄 행의 시작점
        int startContentsNum = (currentPage - 1) * contentsPerPage;

        switch(tabValue) {
            case "공연" :
                tabValue = "A01";
                break;
            case "전시" :
                tabValue = "A02";
                break;
            case "영화" :
                tabValue = "A03";
                break;
            case "도서" :
                tabValue = "A04";
                break;
            case "관광" :
                tabValue = "B01";
                break;
            case "체육" :
                tabValue = "C01";
                break;
            case "디지털 컨텐츠" :
                tabValue = "D01";
                break;
            default:
                tabValue = "all";
                break;
        }

        // 각 탭의 컨텐츠 개수
        double contentsCnt = contentsMapper.getContentsByTabCnt(tabValue);

        // 마지막페이지 (각 탭의 컨텐츠 개수/보여줄 컨텐츠의 개수) 올림
        int lastPage = (int)Math.ceil(contentsCnt/contentsPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if(currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if(endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoListByTabValue(startContentsNum, contentsPerPage, tabValue);

        for(Map<String, Object> contentsInfo : contentsInfoList) {
            log.info("contentsInfo {}", contentsInfo);
            /**
             * mysql date타입 컬럼에 1000-01-01이랑 9999-12-31 데이터
             * 넣으니까 String으로 안돼서 Date로 받은 후 toString
             */
            String contentsSellStartDate = contentsInfo.get("contentsSellStartDate").toString();
            String contentsSellEndDate = contentsInfo.get("contentsSellEndDate").toString();
            String contentsSellDuration = contentsSellStartDate + "~" + contentsSellEndDate;
            String contentsPg = (String) contentsInfo.get("contentsPg");
            String contentsPrice = (String) contentsInfo.get("contentsPrice");
            String contentsCategoryName = (String) contentsInfo.get("contentsCategoryName");
            log.info("contentsCategoryName : {}", contentsCategoryName);
            contentsInfo.put("contentsSellDuration", contentsSellDuration);

            /**
             * 컨텐츠 카테고리가 도서면 book을 전달해서 컨텐츠 리스트 화면에
             * 연령제한 표시가 안나오게함
             */
            if(!contentsCategoryName.equals("도서")) {
                contentsInfo.put("isBook", 0);
            } else {
                contentsInfo.put("isBook", 1);
            }

            if(contentsSellEndDate.equals("9999-12-31")) {
                contentsInfo.replace("contentsSellDuration", contentsSellStartDate + "~");
            }

            /**
             * 컨텐츠 연령 제한 값 파싱 작업
             */
            if(!contentsPg.equals("0")) {
                contentsInfo.replace("contentsPg", contentsPg + "세 이상");
            } else {
                contentsInfo.replace("contentsPg", "연령제한 없음");
            }

            /**
             * 컨텐츠 가격값 파싱 작업
             */
            if(contentsPrice.equals("0원")) {
                contentsInfo.replace("contentsPrice", "무료");
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("contentsInfoList", contentsInfoList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("contentsCnt", contentsCnt);

        return resultMap;
    }

    public Map<String, Object> getContentsInfoListByTabValueAndSearch(int currentPage, String tabValue, String performanceGenre, String area, String startDate, String endDate, String searchValue) {
        //보여줄 컨텐츠의 개수
        int contentsPerPage = 12;

        // 보여줄 행의 시작점
        int startContentsNum = (currentPage - 1) * contentsPerPage;

        switch(tabValue) {
            case "공연" :
                tabValue = "A01";
                break;
            case "전시" :
                tabValue = "A02";
                break;
            case "영화" :
                tabValue = "A03";
                break;
            case "도서" :
                tabValue = "A04";
                break;
            case "관광" :
                tabValue = "B01";
                break;
            case "체육" :
                tabValue = "C01";
                break;
            case "디지털 컨텐츠" :
                tabValue = "D01";
                break;
            default:
                tabValue = "all";
                break;
        }

        // 각 탭의 컨텐츠 개수
        // 바꿔야됨
        double contentsCnt = contentsMapper.getContentsByTabAndSearchCnt(tabValue, performanceGenre);

        // 마지막페이지 (각 탭의 컨텐츠 개수/보여줄 컨텐츠의 개수) 올림
        int lastPage = (int)Math.ceil(contentsCnt/contentsPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if(currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if(endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoListByTabValueAndSearch(startContentsNum, contentsPerPage, tabValue, performanceGenre, area, startDate, endDate, searchValue);

        for(Map<String, Object> contentsInfo : contentsInfoList) {
            log.info("contentsInfo {}", contentsInfo);
            /**
             * mysql date타입 컬럼에 1000-01-01이랑 9999-12-31 데이터
             * 넣으니까 String으로 안돼서 Date로 받은 후 toString
             */
            String contentsSellStartDate = contentsInfo.get("contentsSellStartDate").toString();
            String contentsSellEndDate = contentsInfo.get("contentsSellEndDate").toString();
            String contentsSellDuration = contentsSellStartDate + "~" + contentsSellEndDate;
            String contentsPg = (String) contentsInfo.get("contentsPg");
            String contentsPrice = (String) contentsInfo.get("contentsPrice");
            String contentsCategoryName = (String) contentsInfo.get("contentsCategoryName");
            log.info("contentsCategoryName : {}", contentsCategoryName);
            contentsInfo.put("contentsSellDuration", contentsSellDuration);

            /**
             * 컨텐츠 카테고리가 도서면 book을 전달해서 컨텐츠 리스트 화면에
             * 연령제한 표시가 안나오게함
             */
            if(!contentsCategoryName.equals("도서")) {
                contentsInfo.put("isBook", 0);
            } else {
                contentsInfo.put("isBook", 1);
            }

            if(contentsSellEndDate.equals("9999-12-31")) {
                contentsInfo.replace("contentsSellDuration", contentsSellStartDate + "~");
            }

            /**
             * 컨텐츠 연령 제한 값 파싱 작업
             */
            if(!contentsPg.equals("0")) {
                contentsInfo.replace("contentsPg", contentsPg + "세 이상");
            } else {
                contentsInfo.replace("contentsPg", "연령제한 없음");
            }

            /**
             * 컨텐츠 가격값 파싱 작업
             */
            if(contentsPrice.equals("0원")) {
                contentsInfo.replace("contentsPrice", "무료");
            }
        }

        log.info("contentsInfoList: {}", contentsInfoList);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("contentsInfoList", contentsInfoList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("contentsCnt", contentsCnt);

        return resultMap;
    }

    public int getContentsByTabCnt(String tabValue) {
        switch(tabValue) {
            case "공연" :
                tabValue = "A01";
                break;
            case "전시" :
                tabValue = "A02";
                break;
            case "영화" :
                tabValue = "A03";
                break;
            case "도서" :
                tabValue = "A04";
                break;
            case "관광" :
                tabValue = "B01";
                break;
            case "체육" :
                tabValue = "C01";
                break;
            case "디지털 컨텐츠" :
                tabValue = "D01";
                break;
            default:
                tabValue = "all";
                break;
        }
        return contentsMapper.getContentsByTabCnt(tabValue);
    }

    /**
     * 사용자가 선택한 카테고리 코드 파싱해서 Name값 DB에 삽입
     * 지역값 파싱 후 DB에 삽입
     * @param contents
     */
    public void addContents(Contents contents, String sido) {

        switch (sido) {
            case "서울" :
                contents.setRegionCode((byte) 11);
                break;
            case "경기" :
                contents.setRegionCode((byte) 31);
                break;
            case "부산" :
                contents.setRegionCode((byte) 21);
                break;
            case "대구" :
                contents.setRegionCode((byte) 22);
                break;
            case "인천" :
                contents.setRegionCode((byte) 23);
                break;
            case "광주" :
                contents.setRegionCode((byte) 24);
                break;
            case "대전" :
                contents.setRegionCode((byte) 25);
                break;
            case "울산" :
                contents.setRegionCode((byte) 26);
                break;
            case "세종특별자치시" :
                contents.setRegionCode((byte) 29);
                break;
            case "강원특별자치도" :
                contents.setRegionCode((byte) 32);
                break;
            case "충북" :
                contents.setRegionCode((byte) 33);
                break;
            case "충남" :
                contents.setRegionCode((byte) 34);
                break;
            case "전북" :
                contents.setRegionCode((byte) 35);
                break;
            case "전남" :
                contents.setRegionCode((byte) 36);
                break;
            case "경북" :
                contents.setRegionCode((byte) 37);
                break;
            case "경남" :
                contents.setRegionCode((byte) 38);
                break;
            case "제주특별자치도" :
                contents.setRegionCode((byte) 39);
                break;
        }

        contents.setAmountContentRemaining(contents.getAmountContentRegistered());
        if(contents.getContentsSellEndDate().isEmpty()) {
            contents.setContentsSellEndDate("9999-12-31");
        }
        if(contents.getContentsDuration().isEmpty()) {
            contents.setContentsDuration("0");
        }
        if(contents.getContentsPg().isEmpty()) {
            contents.setContentsPg("0");
        }
        if(contents.getContentsReleaseDT().isEmpty()) {
            contents.setContentsReleaseDT("1000-01-01 00:00:00");
        }
        contentsMapper.addContents(contents);
    }

    public void fileUpload(MultipartFile contentsFile, String contentsId, String userId) {
        ContentsFile file = fileUtil.parseFileInfo(contentsFile);

        log.info("file: {}", file);

        file.setContentsId(contentsId);
        file.setUserId(userId);

        // 파일리스트 db저장
        if(file != null) contentsMapper.addFile(file);
    }

    public Map<String, Object> getContentsDetailInfo(String contentsId) {
        Map<String, Object> contentsDetailInfo = contentsMapper.getContentsDetailInfo(contentsId);
        String contentsPg = (String) contentsDetailInfo.get("contentsPg");
        String contentsReleaseDT = contentsDetailInfo.get("contentsReleaseDT").toString();

        contentsReleaseDT = contentsReleaseDT.replace("T", " ");

        contentsDetailInfo.replace("contentsReleaseDT", contentsReleaseDT);


        int contentsPrice = Integer.parseInt(contentsDetailInfo.get("contentsPrice").toString());
        String strContentsPrice = contentsPrice + "원";
        contentsDetailInfo.put("strContentsPrice", strContentsPrice);
        if(strContentsPrice.equals("0원")) {
            contentsDetailInfo.replace("strContentsPrice", "무료");
        }
        contentsDetailInfo.replace("contentsPg", "만 " + contentsPg + "세 이상 관람가");

        return contentsDetailInfo;
    }

    public Store getSessionStoreInfo(String userId) {
        return contentsMapper.getSessionStoreInfo(userId);
    }

    public Contents getContentsInfoByContentsId(String contentsId) {
        return contentsMapper.getContentsInfoByContentsId(contentsId);
    }

    public List<Contents> getContentsInfoByUserId(String userId) {
        List<Contents> contentsInfoList = contentsMapper.getContentsInfoByUserId(userId);
        log.info("path: {}", contentsInfoList.get(0).getContentsFile().getFilePath());
        log.info("contentInfoList: {}", contentsInfoList);
        return contentsInfoList;
    }

    public List<ContentsCategory> getAjaxContentsCategory(String storeCategoryCode) {
        List<ContentsCategory> contentsCategoryList = contentsMapper.getAjaxContentsCategory(storeCategoryCode);

        contentsCategoryList = contentsCategoryList.stream().filter(cc -> !cc.getContentsCategoryCode().endsWith("00")).collect(Collectors.toList());

        return contentsCategoryList;
    }

    public List<Contents> getAdminContentsList() {
        List<Contents> contentsList = contentsMapper.getAdminContentsList();
        return contentsList;
    }

    public List<ContentsCategory> getContentsCategoryOnReg(String storeCategoryCode) {
        return contentsMapper.getContentsCategoryOnReg(storeCategoryCode);
    }

    public void modifyContents(Contents contents) {
        String contentsPg = contents.getContentsPg();
        String contentsReleaseDt = contents.getContentsReleaseDT();
        if(contentsPg.isEmpty()) {
            contents.setContentsPg("0");
        }
        // html datetime local의 문자열 T를 제거함
        LocalDateTime dateTime = LocalDateTime.parse(contentsReleaseDt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatterDateTime = dateTime.format(formatter);
        contents.setContentsReleaseDT(formatterDateTime);

        log.info("remain: {}", contents.getAmountContentRemaining());
        contentsMapper.modifyContents(contents);
    }

    public String getContentsIdForFileAdd(String storeId) {
        return contentsMapper.getContentsIdForFileAdd(storeId);
    }

}
