package ksmart.ks48team01.dto;

import org.springframework.format.annotation.DateTimeFormat;


public class DayAdjustment {

    private String dateAdjustmentNum;
    private String storeId;
    private String storeName;
    private String storeCategoryCode;
    private String storeCategoryName;
    private int regionCode;
    private String regionName;
    private int districtCode;
    private String districtName;
    private long dateTotalSales;
    private String amountDate;
    private String dayClosingCode;
    private String monthClosingCode;
    private String approvalDate;

    public String getDateAdjustmentNum() {
        return dateAdjustmentNum;
    }

    public void setDateAdjustmentNum(String dateAdjustmentNum) {
        this.dateAdjustmentNum = dateAdjustmentNum;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCategoryCode() {
        return storeCategoryCode;
    }

    public void setStoreCategoryCode(String storeCategoryCode) {
        this.storeCategoryCode = storeCategoryCode;
    }

    public String getStoreCategoryName() {
        return storeCategoryName;
    }

    public void setStoreCategoryName(String storeCategoryName) {
        this.storeCategoryName = storeCategoryName;
    }

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

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public long getDateTotalSales() {
        return dateTotalSales;
    }

    public void setDateTotalSales(long dateTotalSales) {
        this.dateTotalSales = dateTotalSales;
    }

    public String getAmountDate() {
        return amountDate;
    }

    public void setAmountDate(String amountDate) {
        this.amountDate = amountDate;
    }

    public String getDayClosingCode() {
        return dayClosingCode;
    }

    public void setDayClosingCode(String dayClosingCode) {
        this.dayClosingCode = dayClosingCode;
    }

    public String getMonthClosingCode() {
        return monthClosingCode;
    }

    public void setMonthClosingCode(String monthClosingCode) {
        this.monthClosingCode = monthClosingCode;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    @Override
    public String toString() {
        return "DayAdjustment{" +
                "dateAdjustmentNum='" + dateAdjustmentNum + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeCategoryCode='" + storeCategoryCode + '\'' +
                ", storeCategoryName='" + storeCategoryName + '\'' +
                ", regionCode=" + regionCode +
                ", regionName='" + regionName + '\'' +
                ", districtCode=" + districtCode +
                ", districtName='" + districtName + '\'' +
                ", dateTotalSales=" + dateTotalSales +
                ", amountDate='" + amountDate + '\'' +
                ", dayClosingCode='" + dayClosingCode + '\'' +
                ", monthClosingCode='" + monthClosingCode + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                '}';
    }
}

