package Anshul;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HomeController {
	
	// We don’t want to mention ".jsp" in the return statement of controller methods
	// Example: instead of return "index.jsp"; we want to simply return "index"
	// This also helps if later we use a different view technology (like Thymeleaf instead of JSP)

	// Another reason: sometimes we want to move JSP files into a secure folder like /WEB-INF
	// Files inside /WEB-INF cannot be accessed directly from the browser
	// They can only be called through a controller, which makes the app more secure

	// To achieve all this, we configure a prefix and suffix in application.properties
	// Example:
	// spring.mvc.view.prefix=/WEB-INF/views/
	// spring.mvc.view.suffix=.jsp

	// Now when we return "index" from controller, Spring will internally map it to:
	// /WEB-INF/views/index.jsp
	
	@RequestMapping("/")
	public String Home() {
		
		System.out.println("Home page requested");
		
		return "index"; // only mention the name not extension
	}
	
	@RequestMapping("add2")
	public String add2(@RequestParam int num1, @RequestParam int num2, Model model) {
		
		int result = num1 + num2;
		
		model.addAttribute("result", result);
		
		return "result"; // only mention the name not extension
	}


}
