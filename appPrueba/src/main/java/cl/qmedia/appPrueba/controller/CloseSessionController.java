package cl.qmedia.appPrueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CloseSessionController {
	
	@RequestMapping("/security")
	public String CloseSessionView(){

		return "security/closeSession";
	}
}