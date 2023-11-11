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
}
