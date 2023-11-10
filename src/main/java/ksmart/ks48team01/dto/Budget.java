package ksmart.ks48team01.dto;

import org.springframework.format.annotation.DateTimeFormat;


public class Budget {

    private String budgetNum;
    private String officerId;
    private String applyYear;
    private int budgetByPerson;
    private long budgetTotalAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String registDT;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateDT;

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

    @Override
    public String toString() {
        return "Budget{" +
                "budgetNum='" + budgetNum + '\'' +
                ", officerId='" + officerId + '\'' +
                ", applyYear=" + applyYear +
                ", budgetByPerson=" + budgetByPerson +
                ", budgetTotalAmount=" + budgetTotalAmount +
                ", registDT=" + registDT +
                ", updateDT=" + updateDT +
                '}';
    }
}

