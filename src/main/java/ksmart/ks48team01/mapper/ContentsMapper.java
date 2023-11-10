package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.StoreCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentsMapper {
    public List<Map<String, Object>> getContentsInfoList(int startContentsNum, int contentsPerPage);

    public int getContentsCnt();

    public List<StoreCategory> getStoreCategory();

    public List<ContentsCategory> getContentsCategory();

//    public List<ContentsCategory> getContentsCategoryBySearch(String performanceGenre);
}
