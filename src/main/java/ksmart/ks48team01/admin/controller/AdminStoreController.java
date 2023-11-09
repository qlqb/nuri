package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.service.StoreService;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {


    private final StoreService storeService;
    private final UserService userService;

    public AdminStoreController (StoreService storeService, UserService userService) {
        this.storeService = storeService;
        this.userService = userService;
    }

    /**
     * 게시판 전체 목록 조회
     * @return
     */
    @GetMapping("/storeInfoList")
    public String storeInfoList() {

        return "admin/store/storeInfoList";
    }


    @GetMapping("/storeInfoRegister")
    public String storeInfoRegister() {

        return "admin/store/storeInfoRegister";
    }

    @GetMapping("/storeInfoUpdate")
    public String storeInfoUpdate() {

        return "admin/store/storeInfoUpdate";
    }



}
