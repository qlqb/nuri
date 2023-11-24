package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Department;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.DistrictDep;
import ksmart.ks48team01.dto.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    /**
     * 회원 가입 시 지역 입력을 위한 Region(도, 특별시) 목록조회
     * @return 전체 Region 반환
     */
    List<Region> getRegionList();

    /**
     * Admin 페이지에서 조회 시 전체 행정지역 출력
     * @return 전체 행정지역 반환
     */
    List<District> getDistrictList();

    /**
     * 회원가입 및 특정 지역 조회시 사용되는 DISTRICT(시, 군, 구) 목록
     * @param regionCode 특정 Region 입력받은 경우 Ajax로 검색할 Region(도, 특별시)
     * @return 특정된 Region의 District 반환
     */
    List<District> getDistrictListByRegion(String regionCode);


    /**
     * 
     * @return region, district, district의 department 정보 반환
     */
    List<DistrictDep> getDistrictDepartmentList();

    List<DistrictDep> departmentListByRegion(String regionCode);

}
