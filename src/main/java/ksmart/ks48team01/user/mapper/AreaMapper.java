package ksmart.ks48team01.user.mapper;

import ksmart.ks48team01.user.dto.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AreaMapper {

    public List<Area> getAreaList();
}
