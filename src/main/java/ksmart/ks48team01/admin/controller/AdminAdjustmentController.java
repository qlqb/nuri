package ksmart.ks48team01.admin.controller;


import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.AdjustmentService;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
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
	public String adjInfoStore(Model model,
							   @RequestParam(name="searchKey", required = false, defaultValue = "") String searchKey
							, @RequestParam(name="regionCode", required = false) Integer regionCode
							, @RequestParam(name="districtCode", required = false) Integer districtCode
							, @RequestParam(name="categoryCode", required = false) String categoryCode
							, @RequestParam(name="storeId", required = false) String storeId
							, @RequestParam(name="startDate", required = false) String startDate
							, @RequestParam(name="endDate", required = false) String endDate){

		HashMap<String, Object> map = new HashMap<>();
		map.put("searchKey", searchKey);
		map.put("regionCode", regionCode);
		map.put("districtCode", districtCode);
		map.put("categoryCode", categoryCode);
		map.put("storeId", storeId);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		log.info("map : {}", map);

		List<Region> regionList = areaService.getRegionList();
		List<District> districtList = areaService.getDistrictList();
		List<Store> storeList = storeService.getStoreListForAdmin();

		List<DayAdjustment> dayAdjustmentList = null;

		//검색 조건
		if(searchKey != null) {
			//검색
			//조건 1. 지역 단위(입력 받는 값 : searchKey, regionCode, districtCode, startDate, endDate)
			dayAdjustmentList = adjustmentService.getDayAdjListByRegion(map);

			//조건 2. 업종 단위(입력 받는 값 : searchKey, categoryCode, startDate, endDate)
			dayAdjustmentList = adjustmentService.getDayAdjListByCate(map);

			//조건 3. 지역+업종 단위(입력 받는 값 : searchKey, categoryCode, startDate, endDate)
			dayAdjustmentList = adjustmentService.getDayAdjListByRegionCate(map);

			//조건 4. 가맹점 단위(입력 받는 값 : searchKey, storeId, startDate, endDate)
			dayAdjustmentList = adjustmentService.getDayAdjListByStoreId(map);

		}else {
			//검색 조건을 입력하지 않은 경우 && 정산 조회 화면을 처음 여는 경우
			dayAdjustmentList = adjustmentService.getDayAdjustmentList();
		}

		model.addAttribute("dayAdjustmentList", dayAdjustmentList);
		model.addAttribute("title", "정산 조회");
		model.addAttribute("regionList", regionList);
		model.addAttribute("districtList", districtList);
		model.addAttribute("storeList", storeList);
		return "admin/purchase/adjInfoStore";
	}


}
