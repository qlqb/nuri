package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Budget;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BudgetMapper {

    public List<Budget> getBudgetTotalList();

    public List<Budget> getBudgetRegionList();

}
