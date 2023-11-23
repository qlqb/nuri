package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.dto.MunhwaCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MunhwaCardMapper {

    //문화카드 비밀번호 유효성 검사(payment)
    public boolean cardPwCheck(String userId, String cardPw);

    //문화카드 개별 조회(payment)
    public MunhwaCard getMunhwaCardInfoById(String userId);

    //전체 문화누리카드 목록 조회
    public List<MunhwaCard> getMunhwaCardList();

    //문화누리카드 카드번호 중복 여부 검색
    public boolean cardCheck(String munhwaCardNum);

    //전국 단위 예산 등록
    public int munhwaCardRegist(MunhwaCard munhwaCard);

}
