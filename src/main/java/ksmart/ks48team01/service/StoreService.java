package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Store getSpecificStoreInfo(String storeId) {
        Store specificStoreInfo = storeMapper.getSpecificStoreInfo(storeId);

        return specificStoreInfo;
    }

    /**
     * GET 방식으로 유저 가맹점 설명 페이지에서 호출 및 입력 값이 없을 경우
     * 출력되는 전체 결과
     * @return 반환될 간략한 유저 쿼리 결과
     */
    public List<Store> getStoreKeyword() {
        List<Store> keywordList = storeMapper.getStoreKeywordAll();

        return keywordList;
    }

    /**
     * 특정 키워드를 클릭 시에 Query로 특정 카테고리의 결과를 출력
     * @param storeKeyword 입력받을 특정 키워드
     * @return 특정 키워드 조회 후 쿼리 결과
     */
    public List<Store> getStoreKeyword(String storeKeyword) {
        List<Store> keywordList = storeMapper.getStoreKeyword(storeKeyword);

        return keywordList;
    }



}
