package ksmart.ks48team01.dto;

public class Statistic {

    //StoreStt DTO
    private String storeStt;

    //CategoryStt DTO
    private String categoryStt;

    //RegionStt DTO
    private String regionStt;

    //Region_Cate_Stt DTO
    private String regionCateStt;

    //YearRegionBudgetStt DTO
    private String budgetStt;

    //Store에서 가져오는 DTO
    private Store store;
    private String storeId;
    private String storeName;
    //storeCategory Stt에 사용
    private String storeCategoryCode;
    private String storeCategoryName;

    //Region에서 가져오는 DTO
    private Region region;
    private String regionCode;
    private String regionName;

    //Budget에서 가져오는 DTO
    private Budget budget;
    private String budgetNum;
    private String applyYear;
    private String budgetTotalAmount;


    //모든 통계 일치 데이터
    private String adjustmentYear;
    private long month1, month2, month3, month4, month5, month6,
                month7, month8, month9, month10, month11, month12;
    private long totalAmount;

    public String getStoreStt() {
        return storeStt;
    }

    public void setStoreStt(String storeStt) {
        this.storeStt = storeStt;
    }

    public String getCategoryStt() {
        return categoryStt;
    }

    public void setCategoryStt(String categoryStt) {
        this.categoryStt = categoryStt;
    }

    public String getRegionStt() {
        return regionStt;
    }

    public void setRegionStt(String regionStt) {
        this.regionStt = regionStt;
    }

    public String getRegionCateStt() {
        return regionCateStt;
    }

    public void setRegionCateStt(String regionCateStt) {
        this.regionCateStt = regionCateStt;
    }

    public String getBudgetStt() {
        return budgetStt;
    }

    public void setBudgetStt(String budgetStt) {
        this.budgetStt = budgetStt;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getBudgetNum() {
        return budgetNum;
    }

    public void setBudgetNum(String budgetNum) {
        this.budgetNum = budgetNum;
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    public String getBudgetTotalAmount() {
        return budgetTotalAmount;
    }

    public void setBudgetTotalAmount(String budgetTotalAmount) {
        this.budgetTotalAmount = budgetTotalAmount;
    }

    public String getAdjustmentYear() {
        return adjustmentYear;
    }

    public void setAdjustmentYear(String adjustmentYear) {
        this.adjustmentYear = adjustmentYear;
    }

    public long getMonth1() {
        return month1;
    }

    public void setMonth1(long month1) {
        this.month1 = month1;
    }

    public long getMonth2() {
        return month2;
    }

    public void setMonth2(long month2) {
        this.month2 = month2;
    }

    public long getMonth3() {
        return month3;
    }

    public void setMonth3(long month3) {
        this.month3 = month3;
    }

    public long getMonth4() {
        return month4;
    }

    public void setMonth4(long month4) {
        this.month4 = month4;
    }

    public long getMonth5() {
        return month5;
    }

    public void setMonth5(long month5) {
        this.month5 = month5;
    }

    public long getMonth6() {
        return month6;
    }

    public void setMonth6(long month6) {
        this.month6 = month6;
    }

    public long getMonth7() {
        return month7;
    }

    public void setMonth7(long month7) {
        this.month7 = month7;
    }

    public long getMonth8() {
        return month8;
    }

    public void setMonth8(long month8) {
        this.month8 = month8;
    }

    public long getMonth9() {
        return month9;
    }

    public void setMonth9(long month9) {
        this.month9 = month9;
    }

    public long getMonth10() {
        return month10;
    }

    public void setMonth10(long month10) {
        this.month10 = month10;
    }

    public long getMonth11() {
        return month11;
    }

    public void setMonth11(long month11) {
        this.month11 = month11;
    }

    public long getMonth12() {
        return month12;
    }

    public void setMonth12(long month12) {
        this.month12 = month12;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Statistic{");
        sb.append("storeStt='").append(storeStt).append('\'');
        sb.append(", categoryStt='").append(categoryStt).append('\'');
        sb.append(", regionStt='").append(regionStt).append('\'');
        sb.append(", regionCateStt='").append(regionCateStt).append('\'');
        sb.append(", budgetStt='").append(budgetStt).append('\'');
        sb.append(", store=").append(store);
        sb.append(", storeId='").append(storeId).append('\'');
        sb.append(", storeName='").append(storeName).append('\'');
        sb.append(", storeCategoryCode='").append(storeCategoryCode).append('\'');
        sb.append(", storeCategoryName='").append(storeCategoryName).append('\'');
        sb.append(", region=").append(region);
        sb.append(", regionCode='").append(regionCode).append('\'');
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append(", budget=").append(budget);
        sb.append(", budgetNum='").append(budgetNum).append('\'');
        sb.append(", applyYear='").append(applyYear).append('\'');
        sb.append(", budgetTotalAmount='").append(budgetTotalAmount).append('\'');
        sb.append(", adjustmentYear=").append(adjustmentYear);
        sb.append(", month1=").append(month1);
        sb.append(", month2=").append(month2);
        sb.append(", month3=").append(month3);
        sb.append(", month4=").append(month4);
        sb.append(", month5=").append(month5);
        sb.append(", month6=").append(month6);
        sb.append(", month7=").append(month7);
        sb.append(", month8=").append(month8);
        sb.append(", month9=").append(month9);
        sb.append(", month10=").append(month10);
        sb.append(", month11=").append(month11);
        sb.append(", month12=").append(month12);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append('}');
        return sb.toString();
    }
}
