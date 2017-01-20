package cl.qmedia.appPrueba.controller;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.qmedia.appPrueba.model.Albums;
import cl.qmedia.appPrueba.model.Artistas;
import cl.qmedia.appPrueba.model.Cancion;
import cl.qmedia.appPrueba.model.Usuario;

@Controller
public class AnnonRecommenderController {

	
    @RequestMapping(value = "/annon", method = RequestMethod.GET)
    public ModelAndView annonRecommendView() throws TasteException, IOException
    {
    	ModelAndView mav = new ModelAndView();
    	
        Cancion c = new Cancion();
        Usuario u = new Usuario();
        Albums album = new Albums();
        Artistas artista = new Artistas();
    	
        /*------------------------------------------------------------------------------*/
        
        //Top 6 canciones más valoradas
        List cancionesTop6 = c.top6Canciones();
               
        
        /*------------------------------------------------------------------------------*/
        
        //Top 6 albums más valorados
        
        List albumsTop6 = album.top6Albums();
        
        
        /*------------------------------------------------------------------------------*/
        
        //Top 6 Artistas más valorados
        
        List artistaTop6 = artista.top6Artistas();
        
        /*--------------------------------------------------------------------------------*/
        
        mav.addObject("cancionesTop6", cancionesTop6);
        mav.addObject("albumsTop6", albumsTop6);
        mav.addObject("artistaTop6", artistaTop6);
        mav.setViewName("/home");
    	return mav;
    	
    }
}
