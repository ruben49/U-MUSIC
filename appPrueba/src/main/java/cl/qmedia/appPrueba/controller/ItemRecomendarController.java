package cl.qmedia.appPrueba.controller;

import static org.mockito.Matchers.anyList;

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
import cl.qmedia.appPrueba.model.ItemRecomendado;
import cl.qmedia.appPrueba.model.MahoutImpl;

@Controller
public class ItemRecomendarController {

    @RequestMapping(value = "/plataform/itemRecommend", method = RequestMethod.GET)
    public ModelAndView recommendView(@RequestParam String codCancion) throws TasteException, IOException, NoSuchFieldException, SecurityException
    {
        ModelAndView mav = new ModelAndView();
        MahoutImpl mahout = new MahoutImpl();        
        Cancion c = new Cancion();
        
        int codC = Integer.parseInt(codCancion);
        
        //buscar cancion
        List cancion = c.buscarCancionPorCodigo(codC);
        
        //obtener lista de canciones recomendadas para el usuario activo  
        List cancionesRecomendadas = c.cancionesRecomendadasBasadoItem(codC);
        		
        		
        
        mav.addObject("cancion", cancion);
        mav.addObject("listaCanciones", cancionesRecomendadas);
        mav.setViewName("/plataform/datosCancion");
        
        return mav;
    }
    

    @RequestMapping(value = "/plataform/artistaRecommend", method = RequestMethod.GET)
    public ModelAndView recommendArtistaView(@RequestParam String idArtista) throws TasteException, IOException, NoSuchFieldException, SecurityException
    {
        ModelAndView mav = new ModelAndView();
        MahoutImpl mahout = new MahoutImpl();        
        Artistas a = new Artistas();
        Albums album = new Albums();
        
        
        
        //buscar Artista
        List  nombreArtista = a.retornaNombreArtistaPorId(idArtista);
        System.out.println("Este es el nombre: "+nombreArtista.toString());
        
        //obtener lista de canciones recomendadas para el usuario activo  
        List artistasRecomendados = a.artistasRecomendadosBasadosItem(idArtista);
        		
        //ver los albums que tiene
        List albumsArtistas = album.albumsArtistas(idArtista);
        
        mav.addObject("artista", nombreArtista);
        mav.addObject("albums", albumsArtistas);
        mav.addObject("listaArtistas", artistasRecomendados);
        mav.setViewName("/plataform/datosArtista");
        
        return mav;
        
        
        
    }
    
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/itemRecommend", method = RequestMethod.GET)
    public ModelAndView annonItemRecommendView(@RequestParam String codCancion) throws TasteException, IOException, NoSuchFieldException, SecurityException
    {
        ModelAndView mav = new ModelAndView();
        MahoutImpl mahout = new MahoutImpl();        
        Cancion c = new Cancion();
        
        int codC = Integer.parseInt(codCancion);
        
        //buscar cancion
        List cancion = c.buscarCancionPorCodigo(codC);
        
        //obtener lista de canciones recomendadas para el usuario activo  
        List cancionesRecomendadas = c.cancionesRecomendadasBasadoItem(codC);
        		
        		
        
        mav.addObject("cancion", cancion);
        mav.addObject("listaCanciones", cancionesRecomendadas);
        mav.setViewName("datosCancion");
        
        return mav;
    }
    

    @RequestMapping(value = "/artistaRecommend", method = RequestMethod.GET)
    public ModelAndView annonArtistaView(@RequestParam String idArtista) throws TasteException, IOException, NoSuchFieldException, SecurityException
    {
        ModelAndView mav = new ModelAndView();
        MahoutImpl mahout = new MahoutImpl();        
        Artistas a = new Artistas();
        Albums album = new Albums();
        
        
        
        //buscar Artista
        List  nombreArtista = a.retornaNombreArtistaPorId(idArtista);
        System.out.println("Este es el nombre: "+nombreArtista.toString());
        
        //obtener lista de canciones recomendadas para el usuario activo  
        List artistasRecomendados = a.artistasRecomendadosBasadosItem(idArtista);
        		
        //ver los albums que tiene
        List albumsArtistas = album.albumsArtistas(idArtista);
        
        mav.addObject("artista", nombreArtista);
        mav.addObject("albums", albumsArtistas);
        mav.addObject("listaArtistas", artistasRecomendados);
        mav.setViewName("datosArtista");
        
        return mav;
        
        
        
    }    
    
    
    
    
    
    
    
    
    
    
    
}
