package ksmart.ks48team01.dto;


public class MonthAdjustment {

    private String monthAdjustmentNum;
    private String storeId;
    private String storeCategoryCode;
    private int regionCode;
    private int districtCode;
    private long monthTotalSales;
    private String monthClosingCode;
    private String adjustmentMonth;
    private String adjustmentYear;
    private String resistDT;

    public String getMonthAdjustmentNum() {
        return monthAdjustmentNum;
    }

    public void setMonthAdjustmentNum(String monthAdjustmentNum) {
        this.monthAdjustmentNum = monthAdjustmentNum;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreCategoryCode() {
        return storeCategoryCode;
    }

    public void setStoreCategoryCode(String storeCategoryCode) {
        this.storeCategoryCode = storeCategoryCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public long getMonthTotalSales() {
        return monthTotalSales;
    }

    public void setMonthTotalSales(long monthTotalSales) {
        this.monthTotalSales = monthTotalSales;
    }

    public String getMonthClosingCode() {
        return monthClosingCode;
    }

    public void setMonthClosingCode(String monthClosingCode) {
        this.monthClosingCode = monthClosingCode;
    }

    public String getAdjustmentMonth() {
        return adjustmentMonth;
    }

    public void setAdjustmentMonth(String adjustmentMonth) {
        this.adjustmentMonth = adjustmentMonth;
    }

    public String getAdjustmentYear() {
        return adjustmentYear;
    }

    public void setAdjustmentYear(String adjustmentYear) {
        this.adjustmentYear = adjustmentYear;
    }

    public String getResistDT() {
        return resistDT;
    }

    public void setResistDT(String resistDT) {
        this.resistDT = resistDT;
    }

    @Override
    public String toString() {
        return "MonthAdjustment{" +
                "monthAdjustmentNum='" + monthAdjustmentNum + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storeCategoryCode='" + storeCategoryCode + '\'' +
                ", regionCode=" + regionCode +
                ", districtCode=" + districtCode +
                ", monthTotalSales=" + monthTotalSales +
                ", monthClosingCode='" + monthClosingCode + '\'' +
                ", adjustmentMonth='" + adjustmentMonth + '\'' +
                ", adjustmentYear='" + adjustmentYear + '\'' +
                ", resistDT='" + resistDT + '\'' +
                '}';
    }
}

