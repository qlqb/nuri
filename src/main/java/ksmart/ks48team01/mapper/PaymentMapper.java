package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {

    //결제 등록
    public int paymentRegist(Payment payment);

    // 결제 내역 조회 검색
    public List<Payment> getSearchPaymentList(List<Map<String, Object>> searchList);

    //결제 금액 조회
    public String getPaymentAmount(String userId);

    //결제 횟수 조회
    public String getPaymentCount(String userId);

    //아이디별 결제 내역 조회
    public List<Payment> getPaymentListById(String userId);

    //결제 내역 조회
    public List<Payment> getPaymentList();
}
