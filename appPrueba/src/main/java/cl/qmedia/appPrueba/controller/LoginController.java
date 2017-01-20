package cl.qmedia.appPrueba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cl.qmedia.appPrueba.model.Logger;
import cl.qmedia.appPrueba.model.Usuario;


@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginView(){

		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView verifyLogin(
			@RequestParam String uLogin, @RequestParam String uPassword, Model model){
		
		
		ModelAndView mav = new ModelAndView();
		Usuario u = new Usuario();
		boolean login = false;
		
		login = u.loginUsuario(uLogin, uPassword);
		if(login == false)
		{
			model.addAttribute("resultado", "Usuario o contraseña incorrecta, por favor intentelo nuevamente");
			mav.setViewName("/login");
			
		}else
		{
			
			model.addAttribute("resultado", "Ha iniciado sesion satisfactoriamente");
			Logger logger = new Logger();
			
			logger.SetuLogin(uLogin);
			logger.SetuPassword(uPassword);
			
			List user = new ArrayList<>(); 
			user.add(logger);
			
			String jsonLogin = new Gson().toJson(user);
			mav.addObject("login", jsonLogin);
			
			mav.setViewName("/security/logger");
			
		}
		
		
		
		
		return mav;
	}
	
}