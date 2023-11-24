package ksmart.ks48team01.dto;

public class Payment {
    private String paymentCode;
    private int deliveryCosts;
    private int contentsPrice;
    private int paymentQuantity;
    private int paymentAmount;
    private String paymentStatus;
    private String paymentDT;
    private String isRefund;
    private String isClosing;
    private String closingCode;

    private String reservationCode;

    //user Dto 에서 가져오는 정보
    private User userInfo;
    private String userId;

    //contents Dto 에서 가져오는 정보
    private Contents contents;
    private String contentsId;
    private String contentsName;
    private String contentsCategoryName;
    private String contentAddress;

    //munhwaCard Dto에서 가져오는 정보
    private MunhwaCard munhwacardInfo;
    private String munhwaCardNum;
    private String cvc;
    private String cardPw;
    private String cardExpiryDate;

    public String getContentAddress() {
        return contentAddress;
    }

    public void setContentAddress(String contentAddress) {
        this.contentAddress = contentAddress;
    }

    public String getContentsCategoryName() {
        return contentsCategoryName;
    }

    public void setContentsCategoryName(String contentsCategoryName) {
        this.contentsCategoryName = contentsCategoryName;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public int getDeliveryCosts() {
        return deliveryCosts;
    }

    public void setDeliveryCosts(int deliveryCosts) {
        this.deliveryCosts = deliveryCosts;
    }

    public int getContentsPrice() {
        return contentsPrice;
    }

    public void setContentsPrice(int contentsPrice) {
        this.contentsPrice = contentsPrice;
    }

    public int getPaymentQuantity() {
        return paymentQuantity;
    }

    public void setPaymentQuantity(int paymentQuantity) {
        this.paymentQuantity = paymentQuantity;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDT() {
        return paymentDT;
    }

    public void setPaymentDT(String paymentDT) {
        this.paymentDT = paymentDT;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public String getIsClosing() {
        return isClosing;
    }

    public void setIsClosing(String isClosing) {
        this.isClosing = isClosing;
    }

    public String getClosingCode() {
        return closingCode;
    }

    public void setClosingCode(String closingCode) {
        this.closingCode = closingCode;
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

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public String getContentsId() {
        return contentsId;
    }

    public void setContentsId(String contentsId) {
        this.contentsId = contentsId;
    }

    public MunhwaCard getMunhwacardInfo() {
        return munhwacardInfo;
    }

    public void setMunhwacardInfo(MunhwaCard munhwacardInfo) {
        this.munhwacardInfo = munhwacardInfo;
    }



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

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Payment{");
        sb.append("paymentCode='").append(paymentCode).append('\'');
        sb.append(", deliveryCosts=").append(deliveryCosts);
        sb.append(", contentsPrice=").append(contentsPrice);
        sb.append(", paymentQuantity=").append(paymentQuantity);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", paymentStatus='").append(paymentStatus).append('\'');
        sb.append(", paymentDT='").append(paymentDT).append('\'');
        sb.append(", isRefund='").append(isRefund).append('\'');
        sb.append(", isClosing='").append(isClosing).append('\'');
        sb.append(", closingCode='").append(closingCode).append('\'');
        sb.append(", reservationCode='").append(reservationCode).append('\'');
        sb.append(", userInfo=").append(userInfo);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", contents=").append(contents);
        sb.append(", contentsId='").append(contentsId).append('\'');
        sb.append(", contentsName='").append(contentsName).append('\'');
        sb.append(", contentsCategoryName='").append(contentsCategoryName).append('\'');
        sb.append(", contentAddress='").append(contentAddress).append('\'');
        sb.append(", munhwacardInfo=").append(munhwacardInfo);
        sb.append(", munhwacardNum='").append(munhwaCardNum).append('\'');
        sb.append(", cvc='").append(cvc).append('\'');
        sb.append(", cardPw='").append(cardPw).append('\'');
        sb.append(", cardExpiryDate='").append(cardExpiryDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
