package ksmart.ks48team01.user.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.user.dto.Store;
import ksmart.ks48team01.user.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @GetMapping("/storeInfo")
    public String storeInfoPage() {



        return "user/store/storeInfo";
    }

    @ResponseBody
    @GetMapping("/storeKeywordList")
    public String storeKeywordList(Model model, @RequestParam (name = "storeKeyword") String storeKeyword) {
        Gson gson = new Gson();
        List<Store> keywordList = storeService.getStoreKeyword(storeKeyword);

        return gson.toJson(keywordList);
    }

    @GetMapping("/storeList")
    public String storeListPage() {

        return "user/store/storeList";
    }



}
