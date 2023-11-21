package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.DayAdjustment;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdjustmentMapper {

    //전국 단위 예산 목록 조회
    public List<DayAdjustment> getDayAdjustmentList();


}
