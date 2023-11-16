package ksmart.ks48team01.dto;

import org.springframework.format.annotation.DateTimeFormat;


public class BudgetRegion {

    private String budgetRegionNum;
    private String applyYear;
    private String regionCode;
    private String officerId;
    private long budgetRegionAmount;
    private int munhwaRegionNOP;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String registDT;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateDT;

    public String getBudgetRegionNum() {
        return budgetRegionNum;
    }

    public void setBudgetRegionNum(String budgetRegionNum) {
        this.budgetRegionNum = budgetRegionNum;
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public long getBudgetRegionAmount() {
        return budgetRegionAmount;
    }

    public void setBudgetRegionAmount(long budgetRegionAmount) {
        this.budgetRegionAmount = budgetRegionAmount;
    }

    public int getMunhwaRegionNOP() {
        return munhwaRegionNOP;
    }

    public void setMunhwaRegionNOP(int munhwaRegionNOP) {
        this.munhwaRegionNOP = munhwaRegionNOP;
    }

    public String getRegistDT() {
        return registDT;
    }

    public void setRegistDT(String registDT) {
        this.registDT = registDT;
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT;
    }

    @Override
    public String toString() {
        return "BudgetRegion{" +
                "budgetRegionNum='" + budgetRegionNum + '\'' +
                ", applyYear='" + applyYear + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", officerId='" + officerId + '\'' +
                ", budgetRegionAmount=" + budgetRegionAmount +
                ", munhwaRegionNOP=" + munhwaRegionNOP +
                ", registDT='" + registDT + '\'' +
                ", updateDT='" + updateDT + '\'' +
                '}';
    }
}

