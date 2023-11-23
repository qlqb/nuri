package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.*;
import ksmart.ks48team01.mapper.ContentsMapper;
import ksmart.ks48team01.user.controller.ContentsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 사용자가 선택한 카테고리 코드 파싱해서 Name값 DB에 삽입
     * @param contents
     */
    public void addBookContents(Contents contents) {
        String contentsCategoryCode = contents.getContentsCategoryCode();
        String contentsAddress = contents.getContentsAddress();

        switch (contentsCategoryCode) {
            case "A0101":
                contents.setContentsCategoryName("연주회");
                break;
            case "A0102":
                    contents.setContentsCategoryName("리사이틀");
                    break;
            case "A0103":
                    contents.setContentsCategoryName("희곡");
                    break;
            case "A0104":
                    contents.setContentsCategoryName("오페라");
                    break;
            case "A0105":
                    contents.setContentsCategoryName("발레");
                    break;
            case "A0106":
                    contents.setContentsCategoryName("댄스");
                    break;
            case "A0107":
                    contents.setContentsCategoryName("뮤지컬");
                    break;
            case "A0108":
                    contents.setContentsCategoryName("서커스");
                    break;
            case "A0109":
                    contents.setContentsCategoryName("마술");
                    break;
            case "A0110":
                    contents.setContentsCategoryName("인형극");
                    break;
            case "A0111":
                    contents.setContentsCategoryName("행위예술");
                    break;
            case "A0201":
                    contents.setContentsCategoryName("사진");
                    break;
            case "A0202":
                    contents.setContentsCategoryName("공예");
                    break;
            case "A0301":
                    contents.setContentsCategoryName("액션");
                    break;
            case "A0302":
                    contents.setContentsCategoryName("드라마");
                    break;
            case "A0303":
                    contents.setContentsCategoryName("스릴러");
                    break;
            case "A0304":
                    contents.setContentsCategoryName("로맨스");
                    break;
            case "A0305":
                    contents.setContentsCategoryName("코미디");
                    break;
            case "A0306":
                    contents.setContentsCategoryName("SF");
                    break;
            case "A0307":
                    contents.setContentsCategoryName("판타지");
                    break;
            case "A0308":
                    contents.setContentsCategoryName("느와르");
                    break;
            case "A0309":
                    contents.setContentsCategoryName("미스터리");
                    break;
            case "A0310":
                    contents.setContentsCategoryName("공포");
                    break;
            case "A0311":
                    contents.setContentsCategoryName("다큐멘터리");
                    break;
            case "A0312":
                    contents.setContentsCategoryName("뮤지컬");
                    break;
            case "A0401":
                    contents.setContentsCategoryName("총류");
                    break;
            case "A0402":
                    contents.setContentsCategoryName("철학");
                    break;
            case "A0403":
                    contents.setContentsCategoryName("종교");
                    break;
            case "A0404":
                    contents.setContentsCategoryName("사회과학");
                    break;
            case "A0405":
                    contents.setContentsCategoryName("자연과학");
                    break;
            case "A0406":
                    contents.setContentsCategoryName("기술과학");
                    break;
            case "A0407":
                    contents.setContentsCategoryName("예술");
                    break;
            case "A0408":
                    contents.setContentsCategoryName("언어");
                    break;
            case "A0409":
                    contents.setContentsCategoryName("문학");
                    break;
            case "A0410":
                    contents.setContentsCategoryName("역사");
                    break;
            case "B0101":
                    contents.setContentsCategoryName("숙박");
                    break;
             case "B0102":
                    contents.setContentsCategoryName("여행");
                    break;
             case "B0103":
                    contents.setContentsCategoryName("명소");
                    break;
             case "B0104":
                    contents.setContentsCategoryName("휴양");
                    break;
             case "B0105":
                    contents.setContentsCategoryName("캠핑");
                    break;
             case "B0106":
                    contents.setContentsCategoryName("동물원");
                    break;
            case "C0101":
                    contents.setContentsCategoryName("체육용품");
                    break;
            case "C0102":
                    contents.setContentsCategoryName("체육시설");
                    break;
            case "C0201":
                    contents.setContentsCategoryName("배드민턴");
                    break;
            case "C0202":
                    contents.setContentsCategoryName("배구");
                    break;
            case "C0203":
                    contents.setContentsCategoryName("농구");
                    break;
            case "C0204":
                    contents.setContentsCategoryName("게이트볼");
                    break;
            case "C0205":
                    contents.setContentsCategoryName("탁구");
                    break;
            case "C0206":
                    contents.setContentsCategoryName("테니스");
                    break;
            case "C0207":
                    contents.setContentsCategoryName("족구");
                    break;
            case "C0208":
                    contents.setContentsCategoryName("육상");
                    break;
            case "C0209":
                    contents.setContentsCategoryName("야구");
                    break;
            case "C0210":
                    contents.setContentsCategoryName("수영");
                    break;
            case "C0211":
                    contents.setContentsCategoryName("핸드볼");
                    break;
            case "C0212":
                    contents.setContentsCategoryName("기타");
                    break;
            case "D0101":
                    contents.setContentsCategoryName("전자책");
                    break;
            case "D0102":
                    contents.setContentsCategoryName("인터넷 강의");
                    break;
            case "D0103":
                    contents.setContentsCategoryName("엔터테인먼트");
                    break;
            case "D0104":
                    contents.setContentsCategoryName("OTT");
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

        contentsMapper.addBookContents(contents);
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
        contentsMapper.getContentsInfoByContentsId(contentsId);
        return contentsMapper.getContentsInfoByContentsId(contentsId);
    }

    public List<Contents> getContentsInfoByUserId(String userId) {
        List<Contents> contentsInfoList = contentsMapper.getContentsInfoByUserId(userId);
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
}
