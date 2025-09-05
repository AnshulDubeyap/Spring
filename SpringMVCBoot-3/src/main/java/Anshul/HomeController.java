package Anshul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Anshul.model.Alien;

@Controller
public class HomeController {
	
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
	
	// Model Attribute annotation - 1
	
	// Doing the same thing with model Attribute 
	// ModelAttribute annotation helps us by automatically binds form fields (with matching names) to the properties of the Alien object
	
	@RequestMapping("addAlien2")
	public String addAlien(@ModelAttribute("a1") Alien a ) {
		
		return "result";
	}
	
	
	// Model Attribute annotation - 2
	
	// We can also call ModelAttribute annotation on a method
	// By assigning the annotation, this method will me called before any mapping requests, thus adding the name to the model before anything
	
	@ModelAttribute
	public void callName(Model m) {
		m.addAttribute("alien", "Anshul");
	}
}
