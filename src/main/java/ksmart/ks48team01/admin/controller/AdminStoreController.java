package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 게시판 상세조회 및 게시판 정보 수정을 위한
 */

@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {


    private final StoreService storeService;

    public AdminStoreController (StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * 조회(Read), 수정(Update) 기능을 가지고 있음
     * @return 가맹점 전체 목록 조회 페이지(storeInfoList)
     */
    @GetMapping("/storeInfoList")
    public String storeInfoList(Model model) {
        List<Store> storeListForAdmin = storeService.getStoreListForAdmin();

        model.addAttribute("storeListForAdmin", storeListForAdmin);

        return "admin/store/storeInfoList";
    }


    /**
     * 
     * @param model Thymeleaf를 통해 데이터를 View에 출력
     * @param storeId 수정할 회원의 가맹점 아이디
     * @return 특정 가맹점의 정보를 반환
     */
    @GetMapping("/storeInfoUpdate")
    public String getSpecificStoreInfo(Model model, @RequestParam(value = "storeId") String storeId) {
        Store specificStoreInfo = storeService.getSpecificStoreInfo(storeId);

        model.addAttribute("specificStoreInfo", specificStoreInfo);

        return "admin/store/storeInfoUpdate";
    }

    /**
     * 관리자가 사용하는 User 페이지와 기능이 중복
     * 추후 POST 방식 전송만 남겨두고 페이지 삭제 가능성 있음
     * @return 가맹점 정보 등록 페이지(storeInfoRegister)
     */
    @GetMapping("/storeManualRegister")
    public String storeInfoRegister() {

        return "admin/store/storeManualRegister";
    }

}
