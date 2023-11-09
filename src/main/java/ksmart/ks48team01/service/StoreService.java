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

    public StoreService (StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    public List<Store> getStoreList() {
        List<Store> storeList = storeMapper.getStoreList();

        return storeList;
    }

    public List<Store> getStoreKeyword() {
        List<Store> keywordList = storeMapper.getStoreAllKeyword();

        return keywordList;
    }

    public List<Store> getStoreKeyword(String storeKeyword) {
        List<Store> keywordList = storeMapper.getStoreKeyword(storeKeyword);

        return keywordList;
    }

}
