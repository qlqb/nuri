package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    // 게시판 전체정보 조회
    public List<Store> getStoreList();

    // 게시판 소개 페이지에 출력될 전체목록
    public List<Store> getStoreAllKeyword();

    // 게시판 특정 키워드 조회
    public List<Store> getStoreKeyword(String storeKeyword);
}
