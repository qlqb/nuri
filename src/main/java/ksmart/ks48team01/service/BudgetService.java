package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.mapper.AreaMapper;
import ksmart.ks48team01.mapper.BudgetMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public List<Budget> getBudgetTotalList() {
        return budgetMapper.getBudgetTotalList();
    }

    public List<Budget> getBudgetRegionList() {
        return budgetMapper.getBudgetRegionList();
    }

    public void addBudgetTotal(Budget budget) {
        budgetMapper.addBudgetTotal(budget);
    }
    public void addBudgetRegion(Budget budget) {
        budgetMapper.addBudgetRegion(budget);
    }

    public List<Budget> getBudgetTotalSearch(String searchYear){
        return budgetMapper.getBudgetTotalSearch(searchYear);
    }

    public boolean yearCheck(String applyYear){
        return budgetMapper.yearCheck(applyYear);
    }
}
