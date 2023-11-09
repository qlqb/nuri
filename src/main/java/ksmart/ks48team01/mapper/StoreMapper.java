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
     * 관리자 가맹점 관리 페이지 및 가맹점 소개 페이지에서 사용하기 위한 페이지 전체 조회
     * 사용되는 페이지
     * 관리자 : [가맹점 조회, 관리, 삭제]
     * 사용자 : [가맹점 관리 페이지]
     * @return
     */
    public List<Store> getStoreAllKeyword();

    /**
     * 해당 키워드(가맹점 카테고리)를 검색시에 해당되는 가맹점을 출력
     * 사용되는 페이지 
     * @param storeKeyword 해당 카테고리 키워드
     * @return
     */
    public List<Store> getStoreKeyword(String storeKeyword);

    /**
     * 관리자 페이지에서 수정을 위한
     */
    public Store getSpecificStore(String storeId);


}
