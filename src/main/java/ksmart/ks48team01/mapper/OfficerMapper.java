package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Officer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficerMapper {

    List<Officer> getOfficerInfoList();

    List<Officer> officerSearchList(String searchKey, String searchValue);

    int officerRegister(Officer officer);

    Officer getSpecificOfficerList (String officerId);

    int getOfficerUpdate(Officer officer);

}
