package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    public List<Region> getRegionList();
    public List<District> getDistrictList(String regionCode);

}
