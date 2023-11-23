package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.BudgetRegion;
import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.mapper.AreaMapper;
import ksmart.ks48team01.mapper.BudgetMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class BudgetService {

    private final BudgetMapper budgetMapper;
    private final AreaMapper areaMapper;

    public BudgetService(BudgetMapper budgetMapper, AreaMapper areaMapper) {
        this.budgetMapper = budgetMapper;
        this.areaMapper = areaMapper;
    }

    // 전국 단위 예산 전체 조회
    public List<Budget> getBudgetTotalList() {
        return budgetMapper.getBudgetTotalList();
    }

    // 지역 단위 예산 전체 조회
    public List<BudgetRegion> getBudgetRegionList() {
        return budgetMapper.getBudgetRegionList();
    }

    // 전국 단위 예산 입력
    public void addBudgetTotal(Budget budget) {
        budgetMapper.addBudgetTotal(budget);
    }

    // 지역 단위 예산 입력
    public void addBudgetRegion(BudgetRegion budgetRegion) {
        budgetMapper.addBudgetRegion(budgetRegion);
    }

    //특정 연도의 전국 예산 조회
    public Budget getBudgetTotalByYear(String applyYear){
        return budgetMapper.getBudgetTotalByYear(applyYear);
    }
    // 검색 범위 내 전국 예산 조회
    public List<Budget> getBudgetTotalSearch(String applyYear){
        return budgetMapper.getBudgetTotalSearch(applyYear);
    }

    // 검색 범위 내 지역 예산 목록 조회
    public List<BudgetRegion> getBudgetRegionListBySearch(String searchKey, String searchValue){
        return budgetMapper.getBudgetRegionListBySearch(searchKey, searchValue);
    }

    //특정 연도+지역 예산 조회
    public BudgetRegion getBudgetRegionBySearch(String budgetRegionNum){
        return budgetMapper.getBudgetRegionBySearch(budgetRegionNum);
    };

    public boolean yearCheck(String applyYear){
            return budgetMapper.yearCheck(applyYear);
    }

    public boolean yearRegionCheck(HashMap<String, Object> map){
        return budgetMapper.yearRegionCheck(map);
    }

    // 전국 단위 예산 수정
    public int updateBudgetTotal(Budget budget){
       return budgetMapper.updateBudgetTotal(budget);
    }

    //지역 단위 예산 수정
    public int updateBudgetRegion(BudgetRegion budgetRegion){
        return budgetMapper.updateBudgetRegion(budgetRegion);
    }

    // 전국 단위 예산 삭제
    public void removeBudgetTotal(String applyYear){
        budgetMapper.removeBudgetTotal(applyYear);
    }

    // 지역 단위 예산 삭제
    public void removeBudgetRegion(String budgetRegionNum){
        budgetMapper.removeBudgetRegion(budgetRegionNum);
    }
}
