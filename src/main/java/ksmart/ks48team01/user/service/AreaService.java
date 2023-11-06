package ksmart.ks48team01.user.service;

import ksmart.ks48team01.user.dto.Area;
import ksmart.ks48team01.user.mapper.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AreaService {

    private final AreaMapper areaMapper;

    public AreaService(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    public List<Area> getAreaList() {
        List<Area> areaList = areaMapper.getAreaList();
        return areaList;
    }
}
