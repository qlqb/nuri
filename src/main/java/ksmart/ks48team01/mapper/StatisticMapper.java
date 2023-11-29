package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Statistic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticMapper {


    //가맹점 통계 조회 검색
    public List<Statistic> getStoreSearchList(List<Map<String, Object>> searchList);

    //가맹점 통계 조회
    public List<Statistic> getStoreSttList();

}
