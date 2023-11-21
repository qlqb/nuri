package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.DayAdjustment;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdjustmentMapper {

    //가맹점 일 전체 목록 조회
    public List<DayAdjustment> getDayAdjustmentList();

    //가맹점 일 정산 목록 조회 - 1)지역 검색
    public List<DayAdjustment> getDayAdjListByRegion(HashMap<String, Object> map);

    //가맹점 일 정산 목록 조회 - 2)업종 검색
    public List<DayAdjustment> getDayAdjListByCate(HashMap<String, Object> map);

    //가맹점 일 정산 목록 조회 - 3)지역+업종 검색
    public List<DayAdjustment> getDayAdjListByRegionCate(HashMap<String, Object> map);

    //가맹점 일 정산 목록 조회 - 4)가맹점 검색
    public List<DayAdjustment> getDayAdjListByStoreId(HashMap<String, Object> map);
}
