package ksmart.ks48team01.user.service;

import ksmart.ks48team01.user.dto.District;
import ksmart.ks48team01.user.dto.Region;
import ksmart.ks48team01.user.mapper.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaService {

    private final AreaMapper areaMapper;

    public AreaService(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    public List<Region> getRegionList() {
        List<Region> regionList = areaMapper.getRegionList();
        return regionList;
    }

    public List<District> getDistrictList(String regionCode) {
        List<District> districtList = areaMapper.getDistrictList(regionCode);
        return districtList;
    }
}
