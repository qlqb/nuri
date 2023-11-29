package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.mapper.ContentsMapper;
import ksmart.ks48team01.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StoreService {

    private final StoreMapper storeMapper;

    /**
     * StoreService Dependency 주입
     * @param storeMapper
     */
    public StoreService (StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    /**
     * 관리자 페이지에서 관리자가 조회하는 전체 가맹점 목록
     * @return 가맹점 및 가맹점과 관련된 유저 정보 List
     */
    public List<Store> getStoreListForAdmin() {
        List<Store> storeListForAdmin = storeMapper.getStoreListForAdmin();

        return storeListForAdmin;
    }


    public List<Store> storeSearchList(String searchKey, String searchValue) {
        List<Store> storeSearchList = storeMapper.storeSearchList(searchKey, searchValue);

        return storeSearchList;
    }


    /**
     * 특정 가맹점 조회 및 수정 기능
     * @param storeId 조회할 가맹점
     * @return
     */
    public Store getSpecificStoreInfo(String storeId) {
        Store specificStoreInfo = storeMapper.getSpecificStoreInfo(storeId);

        return specificStoreInfo;
    }

    public int storeRegister(Store store) {
        int registerResult = storeMapper.storeRegister(store);

        return registerResult;
    }

    public void storeInfoUpdate(Store store) {
        storeMapper.storeInfoUpdate(store);
    }

    public List<Store> storeOfContentInfo() {
        return storeMapper.storeOfContentInfo();
    }

    public List<Store> storeOfContentInfo(Map<String, Object> storeSearchMap) {
        return storeMapper.storeOfContentInfo(storeSearchMap);
    }

    public Store storeInfo() {
        return storeMapper.storeInfo();
    }

    public Store specificStoreInfo(String storeId) {
        return storeMapper.specificStoreInfo(storeId);
    }

    public List<Store> storeCategoryList() {
        List<Store> categoryList = storeMapper.storeCategoryList();

        return categoryList;
    }

    public Store contentsListByStore() {
        Store contentsListStore = storeMapper.contentsListByStore();
        return  contentsListStore;
    }

    public Store contentsListByStore(String storeId) {
        Store contentsListStore = storeMapper.contentsListBySpecificStore(storeId);
        return  contentsListStore;
    }
}
