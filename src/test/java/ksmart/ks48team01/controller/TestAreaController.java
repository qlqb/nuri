package ksmart.ks48team01.controller;

import ksmart.ks48team01.user.dto.Area;
import ksmart.ks48team01.user.service.AreaService;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TestAreaController {

    private final AreaService areaService;

    public TestAreaController (AreaService areaService) {
        this.areaService = areaService;
    }

    @Test
    public List<Area> testRegionList() {
        List<Area> regionList = areaService.getAreaList();
        regionList.forEach(obj -> {
            System.out.println(obj);
        });
        return regionList;
    }
}
