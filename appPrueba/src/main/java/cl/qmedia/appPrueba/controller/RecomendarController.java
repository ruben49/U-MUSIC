package cl.qmedia.appPrueba.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cl.qmedia.appPrueba.model.Albums;
import cl.qmedia.appPrueba.model.Artistas;
import cl.qmedia.appPrueba.model.Cancion;
import cl.qmedia.appPrueba.model.ItemRecomendado;
import cl.qmedia.appPrueba.model.Logger;
import cl.qmedia.appPrueba.model.MahoutImpl;
import cl.qmedia.appPrueba.model.Usuario;

@Controller
public class RecomendarController {
	
	
	
	
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public ModelAndView recommendView(@RequestParam String uLogin) throws TasteException, IOException, NoSuchFieldException, SecurityException
    {
    	
    	
        ModelAndView mav = new ModelAndView();
        
        Cancion canciones = new Cancion();
        Usuario u = new Usuario();
        Albums albums = new Albums();
        Artistas artistas = new Artistas();
        //datos = recomendación basada en usuario
       
        
        //obtener ID del usuario activo
        int idUsuario = u.buscarCodUsuario(uLogin);
        
        //Obtener Cantidad de usuarios
        
        //int cantidadUsuarios = 220;//reemplazar valor en duro por una query
        int cantidadUsuarios = u.obtenerTotalUsuarios();
        
        
        //Procesar datos, encontrar semejanzas y realizar predicciones y devolver canciones y artistas recomendados
        List<ItemRecomendado> cancionesRecomendadas =  canciones.cancionesRecomendadasBasadoUsuario(idUsuario, cantidadUsuarios);
        								
        
        List<ItemRecomendado> artistasRecomendados = artistas.artistasRecomendadosBasadosUsuarios(idUsuario, cantidadUsuarios);
                
        /*------------------------------------------------------------------------------*/
        
        //Top 6 canciones más valoradas
        List cancionesTop6 = canciones.top6Canciones();
               
        
        /*------------------------------------------------------------------------------*/
        
        //Top 6 albums más valorados
        
        List albumsTop6 = albums.top6Albums();
        
        
        /*------------------------------------------------------------------------------*/
        
        //Top 6 Artistas más valorados
        
        List artistaTop6 = artistas.top6Artistas();
        
        /*--------------------------------------------------------------------------------*/
        
        mav.addObject("listaCanciones", cancionesRecomendadas);
        mav.addObject("listaArtistas", artistasRecomendados);
        mav.addObject("cancionesTop6", cancionesTop6);
        mav.addObject("albumsTop6", albumsTop6);
        mav.addObject("artistaTop6", artistaTop6);
        
        mav.setViewName("/plataform/home");
    
        
        //mav.setViewName("/recommend/recomendar");
        return mav;                
        
    }
    

    
    
    
    
    
}
