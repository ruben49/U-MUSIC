package cl.qmedia.appPrueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homeView(){

		
		return "security/annonValidate";
	}
		
	@RequestMapping("/home")
	public String home2View(){

		return "security/annonValidate";
	}
	
}