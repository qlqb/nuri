package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("AdminStoreController")
@RequestMapping("/admin/store")
public class AdminStoreController {
	
	@GetMapping(value= {"/contentsList"})
	public String contentsListPage(Model model) {
		return "admin/store/contentsList";
	}
	
	@GetMapping(value={"/aStoreList"})
	public String storeListPage(Model model) {
		
		return "admin/store/aStoreList";
	}
}
