package ksmart.ks48team01.admin.controller;


import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.AdjustmentService;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.AdjustmentService;
import ksmart.ks48team01.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller("AdminAdjustmentController")
@RequestMapping(value = "/admin/purchase")
public class AdminAdjustmentController {

	private static final Logger log = LoggerFactory.getLogger(AdminAdjustmentController.class);

	private final AdjustmentService adjustmentService;
	private final AreaService areaService;
	private final StoreService storeService;

	public AdminAdjustmentController(AdjustmentService adjustmentService, AreaService areaService
									,StoreService storeService) {
		this.adjustmentService = adjustmentService;
		this.areaService = areaService;
		this.storeService = storeService;
	}

	/**
	 * 일별정산 전체 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/adjInfoStore")
	public String adjInfoStore(Model model){
		List<DayAdjustment> dayAdjustmentList = adjustmentService.getDayAdjustmentList();
		List<Region> regionList = areaService.getRegionList();
		List<District> districtList = areaService.getDistrictList();
		List<Store> storeList = storeService.getStoreListForAdmin();
		model.addAttribute("dayAdjustmentList", dayAdjustmentList);
		model.addAttribute("title", "정산 조회");
		model.addAttribute("regionList", regionList);
		model.addAttribute("districtList", districtList);
		model.addAttribute("storeList", storeList);
		return "admin/purchase/adjInfoStore";
	}


}
