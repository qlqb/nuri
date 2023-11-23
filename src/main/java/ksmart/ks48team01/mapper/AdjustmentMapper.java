package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.MonthAdjustment;
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
    public List<DayAdjustment> getDayAdjListByStoreName(HashMap<String, Object> map);

    //가맹점 월 전체 목록 조회
    public List<MonthAdjustment> getMonthAdjustmentList();

    //가맹점 월 정산 목록 조회 - 1)지역 검색
    public List<MonthAdjustment> getMonthAdjListByRegion(HashMap<String, Object> map);

    //가맹점 월 정산 목록 조회 - 2)업종 검색
    public List<MonthAdjustment> getMonthAdjListByCate(HashMap<String, Object> map);

    //가맹점 월 정산 목록 조회 - 3)지역+업종 검색
    public List<MonthAdjustment> getMonthAdjListByRegionCate(HashMap<String, Object> map);

    //가맹점 월 정산 목록 조회 - 4)가맹점 검색
    public List<MonthAdjustment> getMonthAdjListByStoreName(HashMap<String, Object> map);
}
