package ksmart.ks48team01.user.dto;

public class Store {

	private String storeId;
	private String storeName;
	private String storeAddress;
	private String storeCategoryCode;
	private String storeCategoryName;
	private String businessNumber;
	private String corporationNumber;
	private String storeContact;
	private String storeOpenTime;
	private String storeRegDate;
	
	//쿼리로 member에서 join으로 가져올 것
	private String userId;
	private String userName;
	private String districtName;
	
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
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
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
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getCorporationNumber() {
		return corporationNumber;
	}
	public void setCorporationNumber(String corporationNumber) {
		this.corporationNumber = corporationNumber;
	}
	public String getStoreContact() {
		return storeContact;
	}
	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}
	public String getStoreOpenTime() {
		return storeOpenTime;
	}
	public void setStoreOpenTime(String storeOpenTime) {
		this.storeOpenTime = storeOpenTime;
	}
	public String getStoreRegDate() {
		return storeRegDate;
	}
	public void setStoreRegDate(String storeRegDate) {
		this.storeRegDate = storeRegDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Store [storeId=");
		builder.append(storeId);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", storeAddress=");
		builder.append(storeAddress);
		builder.append(", storeCategoryCode=");
		builder.append(storeCategoryCode);
		builder.append(", storeCategoryName=");
		builder.append(storeCategoryName);
		builder.append(", businessNumber=");
		builder.append(businessNumber);
		builder.append(", corporationNumber=");
		builder.append(corporationNumber);
		builder.append(", storeContact=");
		builder.append(storeContact);
		builder.append(", storeOpenTime=");
		builder.append(storeOpenTime);
		builder.append(", storeRegDate=");
		builder.append(storeRegDate);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", districtName=");
		builder.append(districtName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
