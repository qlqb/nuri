package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userAboutController")
@RequestMapping("/user/about")
public class AboutController {

    private final StoreService storeService;

    public AboutController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/nuriService")
    public String aboutNuriService(Model model) {

        return "user/about/nuriService";
    }

    @GetMapping("/nuriCard")
    public String aboutNuriCard(Model model) {

        return "user/about/nuriCard";
    }
}
