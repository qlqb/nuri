package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreMapper {

    /**
     * 관리자 가맹점 관리 페이지 및 가맹점 소개 페이지에서 사용하기 위한 페이지 전체 조회
     * 사용되는 페이지
     * 관리자 : [가맹점 조회, 관리, 삭제]
     * 사용자 : [가맹점 관리 페이지]
     * @return 모든 가맹점 정보
     */
    List<Store> getStoreListForAdmin();

    // 가맹점의 정보 목록을 검색
    List<Store> storeSearchList(String searchKey, String searchValue);

    // 관리자 페이지에서 특정 가맹점 정보를 조회, 수정시에 사용
    Store getSpecificStoreInfo(String storeId);

    // 가맹점 회원가입
    int storeRegister(Store store);

    // 가맹점 정보 업데이트
    void storeInfoUpdate(Store store);

    // 검색을 가맹점의 카테고리에 해당되는 목록 출력
    List<Store> storeCategoryList();

    // 가맹점의 등록일 순으로 출력되는 가맹점의 상세정보 메소드
    Store storeInfo();

    // 사용자가 선택한 특정 가맹점의 상세정보를 출력하는 메소드
    Store specificStoreInfo(String storeId);

    // 가맹점 등록일 순으로 출력되는 가맹점 리스트
    List<Store> storeOfContentInfo();

    // 가맹점 특정 기준으로 정렬 및 검색어, 카테고리 순으로 정렬되는 리스트
    List<Store> storeOfContentInfo(Map<String, Object> storeSearchMap);

    // 가맹점의 등록일 순으로 특정 가맹점의 컨텐츠 목록을 출력하는 상세정보 메소드
    Store contentsListByStore();

    // 사용자가 선택한 특정 가맹점의 컨텐츠 목록을 출력하는 메소드
    Store contentsListBySpecificStore(String storeId);
}
