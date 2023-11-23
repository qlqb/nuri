package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Officer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficerMapper {

    public List<Officer> getOfficerInfoList();

    public List<Officer> officerSearchList(String searchKey, String searchValue);

    public int officerRegister(Officer officer);

    public Officer getOfficerUpdate(String officerId);

}
