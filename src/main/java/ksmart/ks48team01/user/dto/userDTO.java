package ksmart.ks48team01.user.dto;
public class userDTO {
    private String userId;
    private String levelId;
    private String userLevelName;
    private String districtCode;
    private String regionCode;
    private String userPw;
    private String userName;
    private String userGender;
    private String userBirth;
    private String residentNumber;
    private String userAddress;
    private String userContact;
    private String userEmail;
    private String userRecentLogin;
    private String userRegDate;
    private String userStat;
    private String ssoType;



    public String getUserId() {
        return userId;
    }



    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getLevelId() {
        return levelId;
    }



    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }



    public String getUserLevelName() {
        return userLevelName;
    }



    public void setUserLevelName(String userLevelName) {
        this.userLevelName = userLevelName;
    }



    public String getDistrictCode() {
        return districtCode;
    }



    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }



    public String getRegionCode() {
        return regionCode;
    }



    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }



    public String getUserPw() {
        return userPw;
    }



    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }



    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getUserGender() {
        return userGender;
    }



    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }



    public String getUserBirth() {
        return userBirth;
    }



    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }



    public String getResidentNumber() {
        return residentNumber;
    }



    public void setResidentNumber(String residentNumber) {
        this.residentNumber = residentNumber;
    }



    public String getUserAddress() {
        return userAddress;
    }



    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }



    public String getUserContact() {
        return userContact;
    }



    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }



    public String getUserEmail() {
        return userEmail;
    }



    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }



    public String getUserRecentLogin() {
        return userRecentLogin;
    }



    public void setUserRecentLogin(String userRecentLogin) {
        this.userRecentLogin = userRecentLogin;
    }



    public String getUserRegDate() {
        return userRegDate;
    }



    public void setUserRegDate(String userRegDate) {
        this.userRegDate = userRegDate;
    }



    public String getUserStat() {
        return userStat;
    }



    public void setUserStat(String userStat) {
        this.userStat = userStat;
    }



    public String getSsoType() {
        return ssoType;
    }



    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", levelId=");
        builder.append(levelId);
        builder.append(", userLevelName=");
        builder.append(userLevelName);
        builder.append(", districtCode=");
        builder.append(districtCode);
        builder.append(", regionCode=");
        builder.append(regionCode);
        builder.append(", userPw=");
        builder.append(userPw);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", userGender=");
        builder.append(userGender);
        builder.append(", userBirth=");
        builder.append(userBirth);
        builder.append(", residentNumber=");
        builder.append(residentNumber);
        builder.append(", userAddress=");
        builder.append(userAddress);
        builder.append(", userContact=");
        builder.append(userContact);
        builder.append(", userEmail=");
        builder.append(userEmail);
        builder.append(", userRecentLogin=");
        builder.append(userRecentLogin);
        builder.append(", userRegDate=");
        builder.append(userRegDate);
        builder.append(", userStat=");
        builder.append(userStat);
        builder.append(", ssoType=");
        builder.append(ssoType);
        builder.append("]");
        return builder.toString();
    }

}
