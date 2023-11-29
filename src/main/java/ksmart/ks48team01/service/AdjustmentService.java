package ksmart.ks48team01.service;

import com.mysql.cj.exceptions.StreamingNotifiable;
import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.MonthAdjustment;
import ksmart.ks48team01.mapper.AdjustmentMapper;
import ksmart.ks48team01.mapper.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AdjustmentService {

    private final AdjustmentMapper adjustmentMapper;

    public AdjustmentService(AdjustmentMapper adjustmentMapper) {
        this.adjustmentMapper = adjustmentMapper;
    }

    // 일별 정산 전체 목록 조회
    public List<DayAdjustment> getDayAdjustmentList() {
        return adjustmentMapper.getDayAdjustmentList();
    }

    // 일별 정산 검색 - 1)지역별
    public List<DayAdjustment> getDayAdjListByRegion(HashMap<String, Object> map) {
        return adjustmentMapper.getDayAdjListByRegion(map);
    }

    // 일별 정산 검색 - 2)업종별
    public List<DayAdjustment> getDayAdjListByCate(HashMap<String, Object> map) {
        return adjustmentMapper.getDayAdjListByCate(map);
    }

    // 일별 정산 검색 - 3)지역+업종별
    public List<DayAdjustment> getDayAdjListByRegionCate(HashMap<String, Object> map) {
        return adjustmentMapper.getDayAdjListByRegionCate(map);
    }

    // 일별 정산 검색 - 4)가맹점별
    public List<DayAdjustment> getDayAdjListByStoreName(HashMap<String, Object> map) {
        return adjustmentMapper.getDayAdjListByStoreName(map);
    }

    //월별 정산 전체 목록 조회
    public List<MonthAdjustment> getMonthAdjustmentList(){
        return adjustmentMapper.getMonthAdjustmentList();
    }

    // 월별 정산 검색 - 1)지역별
    public List<MonthAdjustment> getMonthAdjListByRegion(HashMap<String, Object> map) {
        return adjustmentMapper.getMonthAdjListByRegion(map);
    }

    // 월별 정산 검색 - 2)업종별
    public List<MonthAdjustment> getMonthAdjListByCate(HashMap<String, Object> map) {
        return adjustmentMapper.getMonthAdjListByCate(map);
    }

    // 월별 정산 검색 - 3)지역+업종별
    public List<MonthAdjustment> getMonthAdjListByRegionCate(HashMap<String, Object> map) {
        return adjustmentMapper.getMonthAdjListByRegionCate(map);
    }

    // 월별 정산 검색 - 4)가맹점별
    public List<MonthAdjustment> getMonthAdjListByStoreName(HashMap<String, Object> map) {
        return adjustmentMapper.getMonthAdjListByStoreName(map);
    }

    // 일 정산 중복 체크
    public boolean dayAdjCheck(String adjDate) { return adjustmentMapper.dayAdjCheck(adjDate);}

    // 일 정산 등록
    public void dajAdjRegist(String adjDate){
        adjustmentMapper.dajAdjRegist(adjDate);
    }

    // 월 정산 중복 체크
    public boolean monthAdjCheck(String adjDate) {return adjustmentMapper.monthAdjCheck(adjDate);}

    //월 정산 등록
    public void monthAdjRegist(String adjDate) { adjustmentMapper.monthAdjRegist(adjDate);}
}
