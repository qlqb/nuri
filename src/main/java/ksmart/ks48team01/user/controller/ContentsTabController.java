package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.table.TableCellEditor;
import java.util.List;
import java.util.Map;

@Controller("contentsTabController")
@RequestMapping("/user/contents/contentsInfoList")
public class ContentsTabController {

    private static final Logger log = LoggerFactory.getLogger(ContentsController.class);

    private final ContentsService contentsService;
    private final AreaService areaService;

    public ContentsTabController(ContentsService contentsService, AreaService areaService) {
        this.contentsService = contentsService;
        this.areaService = areaService;
    }

    @GetMapping("/tab0")
    public String getContentsInfoListByTabValue0(Model model,
                              @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                              @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        log.info("tabValue : {}", tabValue);
        log.info("currentPage : {}", currentPage);

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        log.info("contentsInfoList : {}", contentsInfoList);

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "컨텐츠 조회");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("contentsInfoList", contentsInfoList);



        return "user/contents/contentsInfoList";
    }

    @GetMapping("/tab1")
    public String getContentsInfoListByTabValue1(Model model,
                              @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                              @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){
        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        log.info("currentPage {}", currentPage);
        model.addAttribute("title", "컨텐츠 조회");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("contentsInfoList", contentsInfoList);


        return "user/contents/contentsInfoList/tab1";
    }

    @GetMapping("/tab2")
    public String getContentsInfoListByTabValue2(Model model,
                                                 @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
                                                 @RequestParam(name="tabValue", defaultValue = "전체") String tabValue){

        Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);

        List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        log.info("currentPage {}", currentPage);
        model.addAttribute("title", "컨텐츠 조회");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("contentsInfoList", contentsInfoList);


        return "user/contents/contentsInfoList";
    }

    @GetMapping("/formFragments")
    public String getFormFragments(Model model,
                                   @RequestParam(name = "tabValue") String tabValue) {

        List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();
        List<Region> regionList = areaService.getRegionList();
        int contentsCnt = contentsService.getContentsByTabCnt(tabValue);
        model.addAttribute("contentsCategory", contentsCategory);
        model.addAttribute("regionList", regionList);
        model.addAttribute("contentsCnt", contentsCnt);
        return "user/contents/performFragments";
    }

}
