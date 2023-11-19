package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.StoreCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentsMapper {
    public List<Map<String, Object>> getContentsInfoList(int startContentsNum, int contentsPerPage);

    public int getContentsByTabCnt(String tabValue);

    public int getContentsByTabAndSearchCnt(String tabValue, String performanceGenre);

    public List<StoreCategory> getStoreCategory();

    public List<ContentsCategory> getContentsCategory();

    public List<Map<String, Object>> getContentsInfoListByTabValue(int startContentsNum, int contentsPerPage, String tabValue);

    public List<Map<String, Object>> getContentsInfoListByTabValueAndSearch(int startContentsNum, int contentsPerPage, String tabValue, String performanceGenre, String area, String startDate, String endDate, String searchValue);

    public void addBookContents(Contents contents);


    public Map<String, Object> getContentsDetailInfo(String contentsId);
}
