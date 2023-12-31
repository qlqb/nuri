package ksmart.ks48team01.dto;

import java.util.List;

/**
 * 가맹점 목록
 */

public class Store {

	private String storeId;
	private String userId;
	private String storeCategoryCode;
	private String districtCode;
	private String storeCategoryName;
	private String businessNumber;
	private String corporationNumber;
	private String storeName;
	private String storeContact;
	private String storeAddress;
	private String openingTime;
	private String storeRegDate;

	/**
	 * User Join JavaBeans
	 */
	private String userName;
	private String userLevelName;
	private String userEmail;
	private String userStat;
	private Region region;
	private District district;
	private User user;
	private Contents contents;
	private StoreCategory storeCategory;
	private List<Contents> contentsList;

	// 가맹점 수 합계
	private int storeCount;

	public List<Contents> getContentsList() {
		return contentsList;
	}

	public void setContentsList(List<Contents> contentsList) {
		this.contentsList = contentsList;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoreCategoryCode() {
		return storeCategoryCode;
	}

	public void setStoreCategoryCode(String storeCategoryCode) {
		this.storeCategoryCode = storeCategoryCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getStoreRegDate() {
		return storeRegDate;
	}

	public void setStoreRegDate(String storeRegDate) {
		this.storeRegDate = storeRegDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserStat() {
		return userStat;
	}

	public void setUserStat(String userStat) {
		this.userStat = userStat;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contents getContents() {
		return contents;
	}

	public void setContents(Contents contents) {
		this.contents = contents;
	}

	public StoreCategory getStoreCategory() {
		return storeCategory;
	}

	public void setStoreCategory(StoreCategory storeCategory) {
		this.storeCategory = storeCategory;
	}

	public int getStoreCount() {
		return storeCount;
	}

	public void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Store{");
		sb.append("storeId='").append(storeId).append('\'');
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", storeCategoryCode='").append(storeCategoryCode).append('\'');
		sb.append(", districtCode='").append(districtCode).append('\'');
		sb.append(", storeCategoryName='").append(storeCategoryName).append('\'');
		sb.append(", businessNumber='").append(businessNumber).append('\'');
		sb.append(", corporationNumber='").append(corporationNumber).append('\'');
		sb.append(", storeName='").append(storeName).append('\'');
		sb.append(", storeContact='").append(storeContact).append('\'');
		sb.append(", storeAddress='").append(storeAddress).append('\'');
		sb.append(", openingTime='").append(openingTime).append('\'');
		sb.append(", storeRegDate='").append(storeRegDate).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", userLevelName='").append(userLevelName).append('\'');
		sb.append(", userEmail='").append(userEmail).append('\'');
		sb.append(", userStat='").append(userStat).append('\'');
		sb.append(", region=").append(region);
		sb.append(", district=").append(district);
		sb.append(", user=").append(user);
		sb.append(", contents=").append(contents);
		sb.append(", storeCategory=").append(storeCategory);
		sb.append(", contentsList=").append(contentsList);
		sb.append(", storeCount=").append(storeCount);
		sb.append('}');
		return sb.toString();
	}
}
