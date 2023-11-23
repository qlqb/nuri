package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    /**
     * 관리자 가맹점 관리 페이지 및 가맹점 소개 페이지에서 사용하기 위한 페이지 전체 조회
     * 사용되는 페이지
     * 관리자 : [가맹점 조회, 관리, 삭제]
     * 사용자 : [가맹점 관리 페이지]
     * @return 모든 가맹점 정보
     */
    public List<Store> getStoreListForAdmin();


    public List<Store> storeSearchList(String searchKey, String searchValue);


    /**
     * 관리자 특정 가맹점 정보 수정 및 가맹점 사용자의 가맹점 정보 수정 시에 사용
     */
    public Store getSpecificStoreInfo(String storeId);


    /**
     * 가맹점 회원가입 입력 Form
     * @param store 가맹점 회원가입 입력 Form
     */
    public int storeRegister(Store store);


    /**
     * 검색어의 입력이 없거나, GET 방식으로 메소드 호출시에 조회된 전체 목록을 출력
     * @return List 타입으로 반환하여 가맹점의 간략한 정보를 출력
     */
    public List<Store> getStoreKeywordAll();

    /**
     * 해당 키워드(가맹점 카테고리)를 검색시에 해당되는 가맹점을 출력
     * 사용되는 페이지 
     * @param storeKeyword 해당 카테고리 키워드
     * @return List 카테고리에 해당하는 정보를 출력
     */
    public List<Store> getStoreKeyword(String storeKeyword);

    



}
