package Anshul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Anshul.model.Alien;
import dao.AlienDao;

@Controller
public class HomeController {

	@Autowired
	AlienDao dao;

	@ModelAttribute
	public void callName(Model m) {
		m.addAttribute("alien", "Anshul");
	}

	@RequestMapping("/")
	public String Home() {

		System.out.println("Home page requested");

		return "index";
	}

	@RequestMapping("addAlien2")
	public String addAlien(@ModelAttribute("a1") Alien a) {

		return "result";
	}

	// Get All Aliens

	@GetMapping("getAliens")
	public String getALiens(Model m) {

		m.addAttribute("result", dao.getAliens());

		return "result";

	}

}
