package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.BudgetRegion;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Budget;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BudgetMapper {

    //전국 단위 예산 목록 조회
    public List<Budget> getBudgetTotalList();

    //지역 단위 예산 목록 조회
    public List<BudgetRegion> getBudgetRegionList();

    //전국 단위 예산 등록
    public int addBudgetTotal(Budget budget);

    //지역 단위 예산 등록
    public int addBudgetRegion(BudgetRegion budgetRegion);

    //검색 범위 내 전국 단위 예산 조회
    public List<Budget> getBudgetTotalSearch(String applyYear);

    //특정 연도의 전국 단위 예산 조회
    public Budget getBudgetTotalByYear(String applyYear);

    //연도 중복 체크
    public boolean yearCheck(String applyYear);

    //전국 단위 예산 수정
    public int updateBudgetTotal(Budget budget);

    //전국 단위 예산 삭제
    public int removeBudgetTotal(String applyYear);

}
