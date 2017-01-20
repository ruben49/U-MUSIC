package cl.qmedia.appPrueba.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.qmedia.appPrueba.model.Artistas;

@Controller
public class ArtistaController {

	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	public ModelAndView homeView(){
		
		ModelAndView mav = new ModelAndView();
		Artistas a = new Artistas();
		//segun genero
		List artistas = a.listarArtistas();
		
		
		mav.setViewName("/artistas");
		
		return mav;
	}
	
	@RequestMapping(value = "/plataform/artistaP", method = RequestMethod.GET)
	public ModelAndView hoView(@RequestParam int idGenero){
		
		ModelAndView mav = new ModelAndView();
		Artistas a = new Artistas();
		//segun genero
		List artistas = a.listarArtistasGenero(idGenero);
		
		mav.addObject("artistas", artistas);
		
		mav.setViewName("/plataform/artistaP");
		
		return mav;
	}
	
	
}
