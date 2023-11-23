package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.dto.MunhwaCard;
import ksmart.ks48team01.mapper.MunhwaCardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class MunhwaCardService {

    private final MunhwaCardMapper munhwaCardMapper;

    public MunhwaCardService(MunhwaCardMapper munhwaCardMapper) {
        this.munhwaCardMapper = munhwaCardMapper;
    }

    //문화 카드 비밀번호 유효성 검사(payment)
    public boolean cardPwCheck(String userId, String cardPw){return munhwaCardMapper.cardPwCheck(userId, cardPw);}

    //문화 카드 개별 조회(payment)
    public MunhwaCard getMunhwaCardInfoById(String userId){return munhwaCardMapper.getMunhwaCardInfoById(userId);}

    //전체 문화누리카드 목록 조회
    public List<MunhwaCard> getMunhwaCardList() {
        return munhwaCardMapper.getMunhwaCardList();
    }

    //카드번호 중복 여부 검색
    public boolean cardCheck(String munhwaCardNum){
        return munhwaCardMapper.cardCheck(munhwaCardNum);
    }

    // 문화누리카드 등록
    public int munhwaCardRegist(MunhwaCard munhwaCard) {
        return munhwaCardMapper.munhwaCardRegist(munhwaCard);
    }
}
