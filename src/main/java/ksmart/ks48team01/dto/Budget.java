package ksmart.ks48team01.dto;

public class Budget {

    private String budgetNum;
    private String officerId;
    private String applyYear;
    private int budgetByPerson;
    private long budgetTotalAmount;
    private String registDT;
    private String updateDT;

    private String budgetRegionNum;
    private String regionCode;
    private long budgetRegionAmount;
    private int munhwaRegionNOP;

    public String getBudgetNum() {
        return budgetNum;
    }

    public void setBudgetNum(String budgetNum) {
        this.budgetNum = budgetNum;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    public int getBudgetByPerson() {
        return budgetByPerson;
    }

    public void setBudgetByPerson(int budgetByPerson) {
        this.budgetByPerson = budgetByPerson;
    }

    public long getBudgetTotalAmount() {
        return budgetTotalAmount;
    }

    public void setBudgetTotalAmount(long budgetTotalAmount) {
        this.budgetTotalAmount = budgetTotalAmount;
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

    public String getBudgetRegionNum() {
        return budgetRegionNum;
    }

    public void setBudgetRegionNum(String budgetRegionNum) {
        this.budgetRegionNum = budgetRegionNum;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
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

    @Override
    public String toString() {
        return "Budget{" +
                "budgetNum='" + budgetNum + '\'' +
                ", officerId='" + officerId + '\'' +
                ", applyYear='" + applyYear + '\'' +
                ", budgetByPerson=" + budgetByPerson +
                ", budgetTotalAmount=" + budgetTotalAmount +
                ", registDT='" + registDT + '\'' +
                ", updateDT='" + updateDT + '\'' +
                ", budgetRegionNum='" + budgetRegionNum + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", budgetRegionAmount=" + budgetRegionAmount +
                ", munhwaRegionNOP=" + munhwaRegionNOP +
                '}';
    }
}
