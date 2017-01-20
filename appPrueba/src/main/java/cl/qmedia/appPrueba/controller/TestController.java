package cl.qmedia.appPrueba.controller;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.qmedia.appPrueba.model.Cancion;
import cl.qmedia.appPrueba.model.Usuario;

@Controller
public class TestController {
    
    
    public TestController()
    {

    }
    
    @RequestMapping("/test")
    public ModelAndView test()
    {
        ModelAndView mav = new ModelAndView();
        Usuario u = new Usuario(); 
        List datos = u.listarUsuarios();
       
        mav.addObject("datos", datos);
        mav.setViewName("/test");
        return mav;
                
    }
    
    @RequestMapping("/canciones")
    public ModelAndView canciones()
    {
        ModelAndView mav = new ModelAndView();
        Cancion c = new Cancion(); 
        List datos = c.listarCanciones();
       
        mav.addObject("datos", datos);
        mav.setViewName("/canciones");
        return mav;
                
    }
    
}
