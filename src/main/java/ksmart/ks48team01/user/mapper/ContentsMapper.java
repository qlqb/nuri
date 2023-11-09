package ksmart.ks48team01.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentsMapper {
    public List<Map<String, Object>> getContentsInfoList();
}
