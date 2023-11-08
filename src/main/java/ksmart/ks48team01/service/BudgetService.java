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

    public BudgetService(BudgetMapper budgetMapper) {
        this.budgetMapper = budgetMapper;
    }

    public List<Budget> getBudgetTotalList() {
        return budgetMapper.getBudgetTotalList();
    }

    public List<Budget> getBudgetRegionList() {
        return budgetMapper.getBudgetRegionList();
    }

}
