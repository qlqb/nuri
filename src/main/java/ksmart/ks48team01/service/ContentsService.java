package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.mapper.ContentsMapper;
import ksmart.ks48team01.user.controller.ContentsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentsService {
    private static final Logger log = LoggerFactory.getLogger(ContentsController.class);
    private final ContentsMapper contentsMapper;

    public ContentsService(ContentsMapper contentsMapper) {
        this.contentsMapper = contentsMapper;
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

    public List<StoreCategory> getStoreCategory() {
        return contentsMapper.getStoreCategory();
    }

    public List<ContentsCategory> getContentsCategory() {
        return contentsMapper.getContentsCategory();
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
            int idx = 0;
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

            /**
             * 판매일자나 종료일자가 미정인 경우 컨텐츠의 경우에 0을 전달해
             * 컨텐츠 리스트 화면에서 이 값이 0인지 조건 검사 후 렌더링 처리
             */
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
            idx += 1;
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

    public void addBookContents(Contents contents) {
        contentsMapper.addBookContents(contents);
    }

    public Map<String, Object> getContentsDetailInfo(String contentsId) {
        Map<String, Object> contentsDetailInfo = contentsMapper.getContentsDetailInfo(contentsId);

        return contentsMapper.getContentsDetailInfo(contentsId);
    }
}
