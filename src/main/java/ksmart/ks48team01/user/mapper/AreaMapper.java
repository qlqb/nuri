package ksmart.ks48team01.user.mapper;

import ksmart.ks48team01.user.dto.District;
import ksmart.ks48team01.user.dto.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AreaMapper {

    public List<Region> getRegionList();
    public List<District> getDistrictList(String regionCode);

}
