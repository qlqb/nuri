package ksmart.ks48team01.dto;

import org.springframework.format.annotation.DateTimeFormat;


public class BudgetRegion {

    private String budgetRegionNum;
    private String applyYearRegion;
    //private Region region;
    private int regionCode;
    private String regionName;
    private String officerId;
    private String budgetRegionAmount;
    private String munhwaRegionNOP;
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

    public String getApplyYearRegion() {
        return applyYearRegion;
    }

    public void setApplyYearRegion(String applyYearRegion) {
        this.applyYearRegion = applyYearRegion;
    }

//    public Region getRegion() {
//        return region;
//    }
//
//    public void setRegion(Region region) {
//        this.region = region;
//    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getBudgetRegionAmount() {
        return budgetRegionAmount;
    }

    public void setBudgetRegionAmount(String budgetRegionAmount) {
        this.budgetRegionAmount = budgetRegionAmount;
    }

    public String getMunhwaRegionNOP() {
        return munhwaRegionNOP;
    }

    public void setMunhwaRegionNOP(String munhwaRegionNOP) {
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
                ", applyYearRegion='" + applyYearRegion + '\'' +
                //", region=" + region +
                ", regionCode=" + regionCode +
                ", regionName='" + regionName + '\'' +
                ", officerId='" + officerId + '\'' +
                ", budgetRegionAmount='" + budgetRegionAmount + '\'' +
                ", munhwaRegionNOP='" + munhwaRegionNOP + '\'' +
                ", registDT='" + registDT + '\'' +
                ", updateDT='" + updateDT + '\'' +
                '}';
    }
}

