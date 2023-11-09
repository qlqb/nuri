package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {


    /**
     * 가맹점 전체조회
     * @return
     */
    public List<Store> getStoreList();


    /**
     * 가맹점 소개 페이지에서 사용될 페이지 전체 조회
     * @return
     */
    public List<Store> getStoreAllKeyword();

    /**
     *
     * @param storeKeyword
     * @return
     */
    public List<Store> getStoreKeyword(String storeKeyword);
}
