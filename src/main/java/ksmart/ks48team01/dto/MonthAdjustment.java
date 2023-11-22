package ksmart.ks48team01.dto;


public class MonthAdjustment {

    private String monthAdjustmentNum;
    private String storeId;
    private String storeName;
    private String storeCategoryCode;
    private String storeCategoryName;
    private int regionCode;
    private String regionName;
    private int districtCode;
    private String districtName;
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
                ", storeName='" + storeName + '\'' +
                ", storeCategoryCode='" + storeCategoryCode + '\'' +
                ", storeCategoryName='" + storeCategoryName + '\'' +
                ", regionCode=" + regionCode +
                ", regionName='" + regionName + '\'' +
                ", districtCode=" + districtCode +
                ", districtName='" + districtName + '\'' +
                ", monthTotalSales=" + monthTotalSales +
                ", monthClosingCode='" + monthClosingCode + '\'' +
                ", adjustmentMonth='" + adjustmentMonth + '\'' +
                ", adjustmentYear='" + adjustmentYear + '\'' +
                ", resistDT='" + resistDT + '\'' +
                '}';
    }
}

