package Anshul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Anshul.model.Alien;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void callName(Model m) {
		m.addAttribute("alien", "Anshul");
	}
	
	
	@RequestMapping("/")
	public String Home() {
		
		System.out.println("Home page requested");
		
		return "index";
	}
	
	
	@RequestMapping("addAlien")
	public String addAlien(@RequestParam int aid, @RequestParam String aname, Model model) {
		
		Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		
		model.addAttribute("alien", a);
	
		return "result";
	}
	
	
	@RequestMapping("addAlien2")
	public String addAlien(@ModelAttribute("a1") Alien a ) {
		
		return "result";
	}
	
}
