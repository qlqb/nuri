package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Statistic;
import ksmart.ks48team01.mapper.StatisticMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StatisticService {
    private static final Logger log = LoggerFactory.getLogger(StatisticService.class);

    private final StatisticMapper statisticMapper;

    public StatisticService(StatisticMapper statisticMapper) {
        this.statisticMapper = statisticMapper;
    }


    //검색어에 따른 결제 목록 조회
    public List<Statistic> getStoreSttList(List<Map<String, Object>> searchList){
        for(Map<String, Object> search : searchList){
            String searchKey = (String) search.get("searchKey");
            String searchValue = (String) search.get("searchValue");

            switch (searchKey){
                case "adjustmentYear" :
                    searchKey = "ADJUSTMENT_YEAR";
                    break;
                case "storeId" :
                    searchKey = "STORE_ID";
                    break;
                case "storeName" :
                    searchKey = "STORE_NAME";
                    break;
            }
            search.replace("searchKey", searchKey);
        }
            List<Statistic> statisticList = statisticMapper.getStoreSearchList(searchList);
            log.info("statisticList: {}", statisticList);

        return statisticList;
    }

    //가맹점 통계 조회
    public List<Statistic> getStoreSttList(){
        List<Statistic> StoreSttList = statisticMapper.getStoreSttList();
        return StoreSttList;
    }
}
