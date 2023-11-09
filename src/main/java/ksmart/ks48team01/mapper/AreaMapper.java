package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Department;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    /**
     * 회원 가입 시 지역 입력을 위한 Region(도, 특별시) 목록조회
     * @return
     */
    public List<Region> getRegionList();

    /**
     * 회원가입 및 특정 지역 조회시 사용되는 DISTRICT(시, 군, 구) 목록
     * @param regionCode 특정 Region 입력받은 경우 Ajax로 검색할 Region(도, 특별시)
     * @return
     */
    public List<District> getDistrictList(String regionCode);


}
