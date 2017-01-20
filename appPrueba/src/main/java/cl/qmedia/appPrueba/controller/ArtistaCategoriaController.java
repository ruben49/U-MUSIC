package cl.qmedia.appPrueba.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.qmedia.appPrueba.model.Conectar;

@Controller
public class ArtistaCategoriaController {

	private JdbcTemplate jdbcTemplate;

	
	public ArtistaCategoriaController()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	@RequestMapping("/artistaCategoria")
	public ModelAndView homeView(){
		
		ModelAndView mav = new ModelAndView();
		
        String sql="SELECT * FROM Genero";
        List datos = this.jdbcTemplate.queryForList(sql);
        
        mav.addObject("datos",datos);
        mav.setViewName("ArtistasCategoria");
		return mav;
	}
	

	@RequestMapping("/artistaCategoriaP")
	public ModelAndView hView(){
		
		ModelAndView mav = new ModelAndView();
		
        String sql="SELECT * FROM Genero";
        List datos = this.jdbcTemplate.queryForList(sql);
        
        mav.addObject("datos",datos);
        mav.setViewName("plataform/ArtistasCategoriaP");
		return mav;
	}
	
	
	
	
}
