package cl.qmedia.appPrueba.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cl.qmedia.appPrueba.model.Conectar;
import cl.qmedia.appPrueba.model.Usuario;


@Controller
public class RegistroController {
	
	
    private JdbcTemplate jdbcTemplate;
    
    public RegistroController()
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
	
	
	
    @RequestMapping("/registro")
    public ModelAndView registroView()
    {
        ModelAndView mav = new ModelAndView();
        String sql="SELECT idPais, nombrePais FROM Paises;";
        List datos = this.jdbcTemplate.queryForList(sql);
        
        String sql2="SELECT idSexo,descripcion FROM SexoUsuario;";
        List datos2 = this.jdbcTemplate.queryForList(sql2);     
        
        mav.addObject("datos", datos);
        mav.addObject("datos2", datos2);
        mav.setViewName("/registro");
        return mav;        
    }
    
    
    
    
    
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public ModelAndView RegistrarUsuario(@RequestParam String nombreUsuario, @RequestParam String email, 
    		@RequestParam String uLogin, @RequestParam String uPassword, 
    		@RequestParam int edad, @RequestParam int idSexo,
    		@RequestParam int idPais, Model model)
    {
    	ModelAndView mav = new ModelAndView();
    	Usuario u = new Usuario();
    	
    	u.setNombreUsuario(nombreUsuario);
    	u.setEmail(email);
    	u.SetuLogin(uLogin);
    	u.SetuPassword(uPassword);
    	u.setEdad(edad);
    	u.setIdSexo(idSexo);
    	u.setIdPais(idPais);
    	u.setAnoIngreso(2016);
    	u.setNuevoAntiguo(0);
    	
    	String msje = null;
    	
    	//guardar usuario en la bd
    	boolean d = u.registroUsuario(u);
    	if(d)
    	{
    		msje = "Se insertó el usuario correctamente";
    		
    	}else
    	{
    		msje = "Error al insertar el usuario";
    	}
    	
    	
    	System.out.println(msje);
    	
    	
    	model.addAttribute("msje", msje);
    	
    	
    	//  mav.addObject("datos2", datos2);
        mav.setViewName("/rRegistro");
        return mav;
        
        
    }
    
    
    
    
    
}


