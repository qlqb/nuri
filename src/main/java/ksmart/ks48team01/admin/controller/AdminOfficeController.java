package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Department와 DistrictDep(department, 지역 별 행정기관)도 AreaController와 마찬가지로
 * 사용이 빈번하지 않기 때문에 Office로 통합하였다.
 */
@Controller
@RequestMapping("admin/office")
public class AdminOfficeController {

}
