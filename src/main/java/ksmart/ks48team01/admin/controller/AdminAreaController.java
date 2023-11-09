package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 지역이 통합 및 변경되었을 경우, 조작이 필요하다.
 * Region, District는 사용이 빈번하지 않기 때문에 Area로 통합함
 * CRUD에서 C와 U는 Form이 필요하지만, R은 Area에서 담당하고 D는 수정 페이지에서 Post 방식으로 처리
 * 원자폭탄이 떨어져도 지역이 완전히 없어지는 경우(통폐합)는 없기 때문에
 * 삭제기능이 아닌 변경 후 통폐합으로 구현 또는 구현 하지 않을 예정
 */
@Controller
@RequestMapping("/admin/area")
public class AdminAreaController {


    @GetMapping("/areaList")
    public String areaList() {

        return "admin/area/areaList";
    }
    
}
