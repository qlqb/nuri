package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.DistrictDep;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.mapper.AreaMapper;
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

    public List<District> getDistrictList() {
        List<District> districtList = areaMapper.getDistrictList();

        return districtList;
    }

    public List<District> getDistrictListByRegion(String regionCode) {
        List<District> districtListByRegion = areaMapper.getDistrictListByRegion(regionCode);

        return districtListByRegion;
    }

    public List<DistrictDep> getDistrictDepList() {
        List<DistrictDep> districtDepList = areaMapper.getDistrictDepartmentList();

        return districtDepList;
    }

    public List<DistrictDep> departmentListByRegion(String regionCode) {
        List<DistrictDep> departmentByRegion = areaMapper.departmentListByRegion(regionCode);

        return departmentByRegion;
    }

}
