package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Budget;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BudgetMapper {

    //전국 단위 예산 목록 조회
    public List<Budget> getBudgetTotalList();

    //지역 단위 예산 목록 조회
    public List<Budget> getBudgetRegionList();

    //전국 단위 예산 등록
    public int addBudgetTotal(Budget budget);

    //지역 단위 예산 등록
    public int addBudgetRegion(Budget budget);

}
