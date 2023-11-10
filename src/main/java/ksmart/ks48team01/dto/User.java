package ksmart.ks48team01.dto;

/**
 * 유저 정보 목록
 */

public class User {
    private String userId;
    private String levelId;
    private String userLevelName;
    private String districtCode;
    private String regionCode;
    private String userPw;
    private String userName;
    private String userBirth;
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

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
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
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", levelId='").append(levelId).append('\'');
        sb.append(", userLevelName='").append(userLevelName).append('\'');
        sb.append(", districtCode='").append(districtCode).append('\'');
        sb.append(", regionCode='").append(regionCode).append('\'');
        sb.append(", userPw='").append(userPw).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userBirth='").append(userBirth).append('\'');
        sb.append(", userAddress='").append(userAddress).append('\'');
        sb.append(", userContact='").append(userContact).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", userRecentLogin='").append(userRecentLogin).append('\'');
        sb.append(", userRegDate='").append(userRegDate).append('\'');
        sb.append(", userStat='").append(userStat).append('\'');
        sb.append(", ssoType='").append(ssoType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
