package ksmart.ks48team01.admin.controller;


import ksmart.ks48team01.dto.DayAdjustment;
import ksmart.ks48team01.dto.MonthAdjustment;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.AdjustmentService;
import ksmart.ks48team01.service.AreaService;
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
	 * 일별 정산 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/adjDayInfo")
	public String adjDayInfo(Model model,
							   @RequestParam(name="searchKey", required = false) String searchKey
							, @RequestParam(name="regionCode", required = false) Integer regionCode
							, @RequestParam(name="districtCode", required = false) Integer districtCode
							, @RequestParam(name="storeCategoryCode", required = false) String storeCategoryCode
							, @RequestParam(name="storeName", required = false) String storeName
							, @RequestParam(name="startDate", required = false) String startDate
							, @RequestParam(name="endDate", required = false) String endDate){

		HashMap<String, Object> map = new HashMap<>();
		map.put("searchKey", searchKey);
		map.put("regionCode", regionCode);
		map.put("districtCode", districtCode);
		map.put("storeCategoryCode", storeCategoryCode);
		map.put("storeName", storeName);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		log.info("map : {}", map);

		List<Region> regionList = areaService.getRegionList();
		List<District> districtList = areaService.getDistrictList();
		List<Store> storeList = storeService.getStoreListForAdmin();

		List<DayAdjustment> dayAdjustmentList = null;

		//검색 조건
		if(searchKey != null) {
			//검색(공통으로 입력하는 값 : searchKey, startDate, endDate)
			if(regionCode!=null && districtCode!=null) {
				//조건 1. 지역 단위(입력 값 : regionCode, districtCode)
				dayAdjustmentList = adjustmentService.getDayAdjListByRegion(map);
			}else if(storeCategoryCode!=null && regionCode==null){
				//조건 2. 업종 단위(입력 값 : categoryCode)
				dayAdjustmentList = adjustmentService.getDayAdjListByCate(map);
			}else if(regionCode!=null && districtCode!=null && storeCategoryCode!=null){
				//조건 3. 지역+업종 단위(입력 값 : regionCode, districtCode, categoryCode)
				dayAdjustmentList = adjustmentService.getDayAdjListByRegionCate(map);
			}else if(storeName != null){
				//조건 4. 가맹점 단위(입력 값 : storeId)
				dayAdjustmentList = adjustmentService.getDayAdjListByStoreName(map);
			}
		}else {
			//검색 조건을 입력하지 않은 경우 && 정산 조회 화면을 처음 여는 경우
			dayAdjustmentList = adjustmentService.getDayAdjustmentList();
		}

		model.addAttribute("dayAdjustmentList", dayAdjustmentList);
		model.addAttribute("title", "정산 조회");
		model.addAttribute("regionList", regionList);
		model.addAttribute("districtList", districtList);
		model.addAttribute("storeList", storeList);
		return "admin/purchase/adjDayInfo";
	}

	/**
	 * 월별 정산 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/adjMonthInfo")
	public String adjMonthInfo(Model model
							    , @RequestParam(name="searchKey", required = false) String searchKey
								, @RequestParam(name="regionCode", required = false) Integer regionCode
								, @RequestParam(name="districtCode", required = false) Integer districtCode
								, @RequestParam(name="storeCategoryCode", required = false) String storeCategoryCode
								, @RequestParam(name="storeName", required = false) String storeName
								, @RequestParam(name="startDate", required = false) String startDate
								, @RequestParam(name="endDate", required = false) String endDate){

		HashMap<String, Object> monthAdj = new HashMap<>();
		monthAdj.put("searchKey", searchKey);
		monthAdj.put("regionCode", regionCode);
		monthAdj.put("districtCode", districtCode);
		monthAdj.put("storeCategoryCode", storeCategoryCode);
		monthAdj.put("storeName", storeName);
		monthAdj.put("startDate", startDate);
		monthAdj.put("endDate", endDate);
		log.info("map : {}", monthAdj);

		List<Region> regionList = areaService.getRegionList();
		List<District> districtList = areaService.getDistrictList();
		List<Store> storeList = storeService.getStoreListForAdmin();
		List<MonthAdjustment> monthAdjustmentList = adjustmentService.getMonthAdjustmentList();

		//검색 조건
		if(searchKey != null) {
			//검색(공통으로 입력하는 값 : searchKey, startDate, endDate)
			if(regionCode!=null && districtCode!=null) {
				//조건 1. 지역 단위(입력 값 : regionCode, districtCode)
				monthAdjustmentList = adjustmentService.getMonthAdjListByRegion(monthAdj);
			}else if(storeCategoryCode!=null && regionCode==null){
				//조건 2. 업종 단위(입력 값 : categoryCode)
				monthAdjustmentList = adjustmentService.getMonthAdjListByCate(monthAdj);
			}else if(regionCode!=null && districtCode!=null && storeCategoryCode!=null){
				//조건 3. 지역+업종 단위(입력 값 : regionCode, districtCode, categoryCode)
				monthAdjustmentList = adjustmentService.getMonthAdjListByRegionCate(monthAdj);
			}else if(storeName != null){
				//조건 4. 가맹점 단위(입력 값 : storeId)
				monthAdjustmentList = adjustmentService.getMonthAdjListByStoreName(monthAdj);
			}
		}else {
			//검색 조건을 입력하지 않은 경우 && 정산 조회 화면을 처음 여는 경우
			monthAdjustmentList = adjustmentService.getMonthAdjustmentList();
		}

		model.addAttribute("monthAdjustmentList", monthAdjustmentList);
		model.addAttribute("title", "정산 조회");
		model.addAttribute("regionList", regionList);
		model.addAttribute("districtList", districtList);
		model.addAttribute("storeList", storeList);

		return "/admin/purchase/adjMonthInfo";
	}

}
