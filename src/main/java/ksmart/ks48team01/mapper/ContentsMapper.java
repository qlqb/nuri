package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentsMapper {
    public List<Map<String, Object>> getContentsInfoList(int startContentsNum, int contentsPerPage);

    /**
     * 각 탭별 컨텐츠 개수 tabValue가 "all"이면 모든 로우 수를 반환
     * @param tabValue
     * @return
     */
    public int getContentsByTabCnt(String tabValue);

    public int getContentsByTabAndSearchCnt(String tabValue, String performanceGenre);

    public List<StoreCategory> getStoreCategory();

    public List<ContentsCategory> getContentsCategory();

    /**
     * tabValue가 "all"이면 모든 컨텐츠의 정보가 반환
     * @param startContentsNum
     * @param contentsPerPage
     * @param tabValue
     * @return
     */
    public List<Map<String, Object>> getContentsInfoListByTabValue(int startContentsNum, int contentsPerPage, String tabValue);

    public List<Map<String, Object>> getContentsInfoListByTabValueAndSearch(int startContentsNum, int contentsPerPage, String tabValue, String performanceGenre, String area, String startDate, String endDate, String searchValue);

    /**
     * 컨텐츠 추가
     * @param contents
     */
    public void addContents(Contents contents);

    /**
     * 파일 추가
     * @param contentsFile
     */
    public void addFile(ContentsFile contentsFile);

    public Map<String, Object> getContentsDetailInfo(String contentsId);

    public Store getSessionStoreInfo(String userId);

    public Contents getContentsInfoByContentsId(String contentsId);

    /**
     * 마이페이지에서 가맹점별 자사 컨텐츠 조회
     * @param userId
     * @return
     */
    public List<Contents> getContentsInfoByUserId(String userId);

    /**
     * 컨텐츠 등록할 때 컨텐츠 대분류 선택 시 컨텐츠 소분류 호출하기 위해 선언 된 메서드
     * @param storeCategoryCode
     * @return
     */
    public List<ContentsCategory> getAjaxContentsCategory(String storeCategoryCode);

    /**
     * 어드민 페이지에서 보여지는 컨텐츠 리스트
     * @return
     */
    public List<Contents> getAdminContentsList();

    /**
     * 컨텐츠 등록할 때 그 컨텐츠에 해당하는 소분류를 가져옴
     * @param storeCategoryCode
     * @return
     */
    public List<ContentsCategory> getContentsCategoryOnReg(String storeCategoryCode);

    /**
     * 컨텐츠 수정 데이터 전송
     * @param contents
     */
    public void modifyContents(Contents contents);

    /**
     * 컨텐츠와 파일 등록 할 때 파일 테이블에 외부키인 컨텐츠코드를 넣기 위해 해당 파일의 contentsId를 가져오기 위한 메서드
     * @param storeId
     * @return
     */
    public String getContentsIdForFileAdd(String storeId);

}
