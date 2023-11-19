package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.MunhwaCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MunhwaCardMapper {

    //전체 문화누리카드 목록 조회
    public List<MunhwaCard> getMunhwaCardList();

}
