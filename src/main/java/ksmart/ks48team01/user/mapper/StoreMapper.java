package ksmart.ks48team01.user.mapper;

import ksmart.ks48team01.user.dto.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    public List<Store> getStoreList();

    public List<Store> getStoreKeyword(String storeKeyword);
}
