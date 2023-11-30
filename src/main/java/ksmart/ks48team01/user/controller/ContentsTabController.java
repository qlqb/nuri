package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.dto.ContentsCategory;

import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.ContentsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("contentsTabController")
@RequestMapping(value = {"/user/contents/contentsInfoList", "/user"})
public class ContentsTabController {

    private static final Logger log = LoggerFactory.getLogger(ContentsController.class);

    private final ContentsService contentsService;

    public ContentsTabController(ContentsService contentsService) {
        this.contentsService = contentsService;
    }

    @GetMapping("/tab0")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue0(
                                                     @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                                                     @RequestParam(name="tabValue", defaultValue = "all") String tabValue){

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);
        return contentsMap;
    }

    @GetMapping("/tab1")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue1(
                              @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                              @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab2")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue2(
                                                 @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                                                 @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab3")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue3(
            @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
            @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab4")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue4(
            @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
            @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab5")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue5(
            @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
            @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab6")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue6(
            @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
            @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }

    @GetMapping("/tab7")
    @ResponseBody
    public Map<String, Object> getContentsInfoListByTabValue7(
            @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
            @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        currentPage = 1;

        List<StoreCategory> storeCategory = contentsService.getStoreCategory();

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

        Map<String, Object> contentsMap = new HashMap<String, Object>();

        contentsMap.put("storeCategory", storeCategory);
        contentsMap.put("contentsCategory", contentsCategory);
        contentsMap.put("currentPage", currentPage);
        contentsMap.put("lastPage", lastPage);
        contentsMap.put("startPageNum", startPageNum);
        contentsMap.put("endPageNum", endPageNum);
        contentsMap.put("contentsInfoList", contentsInfoList);
        contentsMap.put("contentsCnt", contentsCnt);
        contentsMap.put("tabValue", tabValue);

        return contentsMap;
    }
}
