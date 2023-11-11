package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Officer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficerMapper {

    public List<Officer> getOfficerInfoList();
}
