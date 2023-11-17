package ksmart.ks48team01.dto;

public class MunhwaCard {
    private String munhwacardNum;
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

    public String getMunhwacardNum() {
        return munhwacardNum;
    }

    public void setMunhwacardNum(String munhwacardNum) {
        this.munhwacardNum = munhwacardNum;
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
        final StringBuffer sb = new StringBuffer("MunhwaCard{");
        sb.append("munhwacardNum='").append(munhwacardNum).append('\'');
        sb.append(", cvc='").append(cvc).append('\'');
        sb.append(", cardPw='").append(cardPw).append('\'');
        sb.append(", cardExpiryDate='").append(cardExpiryDate).append('\'');
        sb.append(", cardComp='").append(cardComp).append('\'');
        sb.append(", cardUsableCheck='").append(cardUsableCheck).append('\'');
        sb.append(", firstUsageAmount=").append(firstUsageAmount);
        sb.append(", lastUsageAmount=").append(lastUsageAmount);
        sb.append(", cardIssueDate='").append(cardIssueDate).append('\'');
        sb.append(", userInfo=").append(userInfo);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
