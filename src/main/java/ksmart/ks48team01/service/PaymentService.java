package ksmart.ks48team01.service;

import ksmart.ks48team01.admin.controller.AdminBoardController;
import ksmart.ks48team01.dto.Payment;
import ksmart.ks48team01.mapper.PaymentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentMapper paymentmapper){
        this.paymentMapper = paymentmapper;
    }

    //결제 등록
    public int paymentRegist(Payment payment){
        return paymentMapper.paymentRegist(payment);
    }

    //검색어에 따른 결제 목록 조회
    public List<Payment> getPaymentList(List<Map<String, Object>> searchList) {

        for(Map<String, Object> search : searchList){
            String searchKey = (String) search.get("searchKey");
            String searchValue = (String) search.get("searchValue");
            switch (searchKey){
                case "paymentStatus" :
                    searchKey = "PAYMENT_STATUS";
                    break;
                case "userId" :
                    searchKey = "USER_ID";
                    break;
                case "munhwacardNum" :
                    searchKey = "MUNHWACARD_NUM";
                    break;
                case "isRefund" :
                    searchKey = "IS_REFUND";
                    break;
                case "isClosing" :
                    searchKey = "IS_CLOSING";
                    break;
            }
            search.replace("searchKey", searchKey);
        }
        List<Payment> paymentList = paymentMapper.getSearchPaymentList(searchList);
        log.info("paymentList: {}", paymentList);
        return paymentList;
    }

    //결제 금액 조회
    public String getPaymentAmount(String userId){
        String paymentAmount = paymentMapper.getPaymentAmount(userId);

        return paymentAmount;
    }

    //결제 횟수 조회
    public String getPaymentCount(String userId){
        String paymentCnt = paymentMapper.getPaymentCount(userId);

        return paymentCnt;
    }
    //아이디별 결제 내역 조회
    public List<Payment> paymentListById(String userId){
        List<Payment> paymentListById = paymentMapper.getPaymentListById(userId);

        return paymentListById;
    }

    //결제 내역 조회
    public List<Payment> getPaymentList(){
        List<Payment> paymentList = paymentMapper.getPaymentList();

        return paymentList;
    }



}
