package ksmart.ks48team01.dto;

public class Contents {

    private String contentsId;
    private String contentsCategoryCode;
    private byte regionCode = 0;
    private String storeId;
    private String contentsCategoryName;
    private String contentsName;
    private String contentsAddress = "alreadyInputOnJoin";
    private String contentsDuration = "0";
    private String contentsPg = "0";
    private int contentsPrice;
    private String contentsReleaseDT = "1000-01-01T00:00:00";
    private String contentsRegDate;
    private String contentsSellStartDate = "1000-01-01";
    private String contentsSellEndDate = "9999-12-31";
    private int amountContentRegistered = -10000;
    private int amountContentRemaining = -10000;
    private String contentsDetail;
    private Store storeInfo;

    public String getContentsId() {
        return contentsId;
    }

    public void setContentsId(String contentsId) {
        this.contentsId = contentsId;
    }

    public String getContentsCategoryCode() {
        return contentsCategoryCode;
    }

    public void setContentsCategoryCode(String contentsCategoryCode) {
        this.contentsCategoryCode = contentsCategoryCode;
    }

    public byte getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(byte regionCode) {
        this.regionCode = regionCode;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getContentsCategoryName() {
        return contentsCategoryName;
    }

    public void setContentsCategoryName(String contentsCategoryName) {
        this.contentsCategoryName = contentsCategoryName;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    public String getContentsAddress() {
        return contentsAddress;
    }

    public void setContentsAddress(String contentsAddress) {
        this.contentsAddress = contentsAddress;
    }

    public String getContentsDuration() {
        return contentsDuration;
    }

    public void setContentsDuration(String contentsDuration) {
        this.contentsDuration = contentsDuration;
    }

    public String getContentsPg() {
        return contentsPg;
    }

    public void setContentsPg(String contentsPg) {
        this.contentsPg = contentsPg;
    }

    public int getContentsPrice() {
        return contentsPrice;
    }

    public void setContentsPrice(int contentsPrice) {
        this.contentsPrice = contentsPrice;
    }

    public String getContentsReleaseDT() {
        return contentsReleaseDT;
    }

    public void setContentsReleaseDT(String contentsReleaseDT) {
        this.contentsReleaseDT = contentsReleaseDT;
    }

    public String getContentsRegDate() {
        return contentsRegDate;
    }

    public void setContentsRegDate(String contentsRegDate) {
        this.contentsRegDate = contentsRegDate;
    }

    public String getContentsSellStartDate() {
        return contentsSellStartDate;
    }

    public void setContentsSellStartDate(String contentsSellStartDate) {
        this.contentsSellStartDate = contentsSellStartDate;
    }

    public String getContentsSellEndDate() {
        return contentsSellEndDate;
    }

    public void setContentsSellEndDate(String contentsSellEndDate) {
        this.contentsSellEndDate = contentsSellEndDate;
    }

    public int getAmountContentRegistered() {
        return amountContentRegistered;
    }

    public void setAmountContentRegistered(int amountContentRegistered) {
        this.amountContentRegistered = amountContentRegistered;
    }

    public int getAmountContentRemaining() {
        return amountContentRemaining;
    }

    public void setAmountContentRemaining(int amountContentRemaining) {
        this.amountContentRemaining = amountContentRemaining;
    }

    public String getContentsDetail() {
        return contentsDetail;
    }

    public void setContentsDetail(String contentsDetail) {
        this.contentsDetail = contentsDetail;
    }

    public Store getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(Store storeInfo) {
        this.storeInfo = storeInfo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contents{");
        sb.append("contentsId='").append(contentsId).append('\'');
        sb.append(", contentsCategoryCode='").append(contentsCategoryCode).append('\'');
        sb.append(", regionCode=").append(regionCode);
        sb.append(", storeId='").append(storeId).append('\'');
        sb.append(", contentsCategoryName='").append(contentsCategoryName).append('\'');
        sb.append(", contentsName='").append(contentsName).append('\'');
        sb.append(", contentsAddress='").append(contentsAddress).append('\'');
        sb.append(", contentsDuration='").append(contentsDuration).append('\'');
        sb.append(", contentsPg='").append(contentsPg).append('\'');
        sb.append(", contentsPrice=").append(contentsPrice);
        sb.append(", contentsReleaseDT='").append(contentsReleaseDT).append('\'');
        sb.append(", contentsRegDate='").append(contentsRegDate).append('\'');
        sb.append(", contentsSellStartDate='").append(contentsSellStartDate).append('\'');
        sb.append(", contentsSellEndDate='").append(contentsSellEndDate).append('\'');
        sb.append(", amountContentRegistered=").append(amountContentRegistered);
        sb.append(", amountContentRemaining=").append(amountContentRemaining);
        sb.append(", contentsDetail='").append(contentsDetail).append('\'');
        sb.append(", storeInfo=").append(storeInfo);
        sb.append('}');
        return sb.toString();
    }
}