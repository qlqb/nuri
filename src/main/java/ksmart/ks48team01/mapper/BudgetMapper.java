package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.BudgetRegion;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Budget;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
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
    //검색 범위 내 지역 예산 목록 조회
    public List<BudgetRegion> getBudgetRegionListBySearch(String searchKey, String searchValue);

    //특정 연도+지역의 예산 조회
    public BudgetRegion getBudgetRegionBySearch(String budgetRegionNum);

    //전국 단위 연도 중복 체크
    public boolean yearCheck(String applyYear);

    //지역 단위 연도 중복 체크
    public boolean yearRegionCheck(HashMap<String, Object> map);

    //전국 단위 예산 수정
    public int updateBudgetTotal(Budget budget);

    //지역 단위 예산 수정
    public int updateBudgetRegion(BudgetRegion budgetRegion);

    //전국 단위 예산 삭제
    public int removeBudgetTotal(String applyYear);

    //지역 단위 예산 삭제
    public int removeBudgetRegion(String applyYear);



}
