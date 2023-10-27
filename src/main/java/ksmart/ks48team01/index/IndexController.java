package ksmart.ks48team01.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("indexController")
public class IndexController {

	@GetMapping(value = {"", "/"})
	public String indexMainPage(Model model) {
		
		return "index";
	}
	
}
