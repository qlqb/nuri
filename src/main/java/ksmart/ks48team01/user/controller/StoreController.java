package ksmart.ks48team01.user.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("storeController")
@RequestMapping("/user/store")
public class StoreController {

    private final StoreService storeService;
    private final ContentsService contentsService;

    public StoreController(StoreService storeService, ContentsService contentsService) {
        this.storeService = storeService;
        this.contentsService = contentsService;
    }


    /**
     * 가맹점의 목록과 가맹점이 게재한 컨텐츠를 확인할 수 있는 페이지
     * @param storeId 선택된 컨텐츠의 페이지
     * @param model view에 출력
     * @return Parameter가 없을 경우 가장 최근에 컨텐츠를 게재한 가맹점의 페이지
     */
    @GetMapping("/nuriStore")
    public String nuriStoreList(@RequestParam (name = "storeId", required = false)
                                    String storeId, Model model) {
            Store specifiedStore;
            Store contentsListByStore;

        if(storeId != null) {
            specifiedStore = storeService.specificStoreInfo(storeId);
            contentsListByStore = storeService.contentsListByStore(storeId);
        } else {
            specifiedStore = storeService.storeInfo();
            contentsListByStore = storeService.contentsListByStore();

        }

        List<Store> categoryList = storeService.storeCategoryList();
        List<Store> storeOfContentList = storeService.storeOfContentInfo();

        model.addAttribute("storeOfContentList", storeOfContentList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("specificStoreList", specifiedStore);
        model.addAttribute("contentsListByStore", contentsListByStore);

        return "user/store/nuriStore";
    }

    @ResponseBody
    @PostMapping("/storeSearch")
    public String storeSearch(@RequestBody Map<String, Object> storeSearchMap) {
        Gson gson = new Gson();

        List<Store> storeOfContentList = storeService.storeOfContentInfo(storeSearchMap);

        return gson.toJson(storeOfContentList);
    }

    /**
     * 가맹점의 회원가입 페이지
     * @param store
     * @return
     */
    @ResponseBody
    @PostMapping("/storeRegister")
    public int storeRegister(@RequestBody Store store) {
        int registerResult = storeService.storeRegister(store);

        return registerResult;
    }

}
