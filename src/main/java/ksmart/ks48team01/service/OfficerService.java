package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.Officer;
import ksmart.ks48team01.mapper.OfficerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OfficerService {

    private OfficerMapper officerMapper;

    public OfficerService(OfficerMapper officerMapper) {
        this.officerMapper = officerMapper;
    }

    public List<Officer> getOfficerInfoList() {
        List<Officer> officerInfoList = officerMapper.getOfficerInfoList();

        return officerInfoList;
    }

    public List<Officer> officerSearchList(String searchKey, String searchValue) {
        List<Officer> officerSearchList = officerMapper.officerSearchList(searchKey, searchValue);

        return officerSearchList;
    }

    public Officer getSpecificOfficerList(String officerId) {
        Officer specificOfficerList = officerMapper.getSpecificOfficerList(officerId);

        return specificOfficerList;
    }

    public int officerRegister(Officer officer) {
        return officerMapper.officerRegister(officer);
    }

    public void getOfficerUpdate (Officer officer) {
        officerMapper.getOfficerUpdate(officer);
    }

}
