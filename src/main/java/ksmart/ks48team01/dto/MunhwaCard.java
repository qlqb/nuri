package ksmart.ks48team01.dto;

public class MunhwaCard {
    private String munhwaCardNum;
    private String cvc;
    private String cardPw;
    private String cardExpiryDate;
    private String cardComp;
    private String cardUsableCheck;
    private int firstUsageAmount;
    private int lastUsageAmount;
    private String cardIssueDate;

    //user Dto 에서 가져오는 정보
    private User userInfo;
    private String userId;
    private String userName;

    public String getMunhwaCardNum() {
        return munhwaCardNum;
    }

    public void setMunhwaCardNum(String munhwaCardNum) {
        this.munhwaCardNum = munhwaCardNum;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardPw() {
        return cardPw;
    }

    public void setCardPw(String cardPw) {
        this.cardPw = cardPw;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardComp() {
        return cardComp;
    }

    public void setCardComp(String cardComp) {
        this.cardComp = cardComp;
    }

    public String getCardUsableCheck() {
        return cardUsableCheck;
    }

    public void setCardUsableCheck(String cardUsableCheck) {
        this.cardUsableCheck = cardUsableCheck;
    }

    public int getFirstUsageAmount() {
        return firstUsageAmount;
    }

    public void setFirstUsageAmount(int firstUsageAmount) {
        this.firstUsageAmount = firstUsageAmount;
    }

    public int getLastUsageAmount() {
        return lastUsageAmount;
    }

    public void setLastUsageAmount(int lastUsageAmount) {
        this.lastUsageAmount = lastUsageAmount;
    }

    public String getCardIssueDate() {
        return cardIssueDate;
    }

    public void setCardIssueDate(String cardIssueDate) {
        this.cardIssueDate = cardIssueDate;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
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

    @Override
    public String toString() {
        return "MunhwaCard{" +
                "munhwaCardNum='" + munhwaCardNum + '\'' +
                ", cvc='" + cvc + '\'' +
                ", cardPw='" + cardPw + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", cardComp='" + cardComp + '\'' +
                ", cardUsableCheck='" + cardUsableCheck + '\'' +
                ", firstUsageAmount=" + firstUsageAmount +
                ", lastUsageAmount=" + lastUsageAmount +
                ", cardIssueDate='" + cardIssueDate + '\'' +
                ", userInfo=" + userInfo +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
