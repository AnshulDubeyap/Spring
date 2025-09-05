package Anshul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

// annotation tells Spring that this file is a controller
@Controller
public class HomeController {

	// annotation calls the Home() method whenever someone visits path "/"
	@RequestMapping("/")
	public String Home() {
		System.out.println("Home page requested");

		// we call the view (JSP) by just returning it
		// in Servlet + JSP, we used RequestDispatcher to configure servlet and JSP
		// but in Spring, the DispatcherServlet automatically figures out which JSP to
		// call
		// we just return the name of the view here

		return "index.jsp";

		// but when I run it, the JSP file gets downloaded instead of running
		// JSP needs to be converted into a Servlet, and this job is done by the Tomcat
		// server
		// in Spring Boot we use an embedded Tomcat, which by default does not support
		// JSP compilation
		// so we need to add the JSP dependency (tomcat-embed-jasper) from Maven
		// repository
	}
	
	// a method that adds two numbers and returns the result 
	// in order to get the input values we need a request object 
	@RequestMapping("add")
	public String add(HttpServletRequest req) {
		
		// get the first number from form input
		int i = Integer.parseInt(req.getParameter("num1"));
		
		// get the second number from form input
		int j = Integer.parseInt(req.getParameter("num2"));
		
		// calculate the sum
		int result = i + j;
		
		// store the result inside request (better than using session for this case)
		req.setAttribute("result", result);
		
		// call result.jsp to show the answer
		return "result.jsp";
	}
	
	
	// But the above add method looks ugly, lets remove the request object and use param annotation provided by spring,
	// Lets also reduce the code lines, and create a new method with Spring tools, that provides Model and View in place of Session 
	@RequestMapping("addition")
	public String add2(@RequestParam int num1, @RequestParam int num2, Model model) {
		
		// directly calculate sum using parameters
		int result = num1 + num2;
		
		// add result into the model
		model.addAttribute("result", result);
		
		// return result.jsp view
		return "result.jsp";
	}

}
