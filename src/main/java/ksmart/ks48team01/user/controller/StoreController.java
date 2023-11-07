package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/store")
public class StoreController {


    @GetMapping("/storeInfo")
    public String storeInfoPage() {

        return "user/store/storeInfo";
    }

    @GetMapping("/storeList")
    public String storeListPage() {

        return "user/store/storeList";
    }



}
