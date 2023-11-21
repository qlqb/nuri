package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.MonthAdjustment;
import ksmart.ks48team01.mapper.AdjustmentMapper;
import ksmart.ks48team01.mapper.AreaMapper;
import ksmart.ks48team01.mapper.BudgetMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AdjustmentService {

    private final AdjustmentMapper adjustmentMapper;
    private final AreaMapper areaMapper;

    public AdjustmentService(AdjustmentMapper adjustmentMapper, AreaMapper areaMapper) {
        this.adjustmentMapper = adjustmentMapper;
        this.areaMapper = areaMapper;
    }

    // 전국 단위 예산 전체 조회
    public List<DayAdjustment> getDayAdjustmentList() {
        return adjustmentMapper.getDayAdjustmentList();
    }

}
