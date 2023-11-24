package ksmart.ks48team01.admin.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @ResponseBody
    @PostMapping("/storeSearchList")
    public String storeSearchList(@RequestBody Map<String, Object> storeKeywordMap) {

        Gson gson = new Gson();
        List<Store> storeSearchList;

        System.out.println(storeKeywordMap);
        String searchKey = (String) storeKeywordMap.get("searchKey");
        searchKey = switch (searchKey) {
            case "storeId" -> "SI.STORE_ID";
            case "storeName" -> "SI.STORE_NAME";
            case "userName" -> "UI.USER_NAME";
            case "storeCategoryName" -> "SI.STORE_CATEGORY_NAME";
            case "storeAddress" -> "SI.STORE_ADDRESS";
            default -> null;
        };

        String searchValue = (String) storeKeywordMap.get("searchValue");
        System.out.println(searchKey + " / " + searchValue);

        if(searchValue != null && searchKey != null) {
            storeSearchList = storeService.storeSearchList(searchKey, searchValue);
        } else {
            storeSearchList = storeService.getStoreListForAdmin();
        }

        return gson.toJson(storeSearchList);
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

    @PostMapping("/storeInfoUpdate")
    public String storeInfoUpdate(Store store) {
        storeService.storeInfoUpdate(store);

        return "redirect:/admin/store/storeInfoList";
    }
}
