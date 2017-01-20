package cl.qmedia.appPrueba.model;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Usuario {

	private JdbcTemplate jdbcTemplate;
	
	private String nombreUsuario;
	private String email;
	private int edad;
	private String uLogin;
	private String uPassword;
	private int idSexo;
	private int idPais;
	private int anoIngreso;
	private int nuevoAntiguo;
	
	
	
	public Usuario()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
		
	
	public void SetuLogin(String uLogin)
	{
		this.uLogin = uLogin;
	}
	
	public String GetuLogin()
	{
		return this.uLogin;
	}
	
	public void SetuPassword(String uPassword)
	{
		this.uPassword = uPassword;
	}
	
	public String Getupassword()
	{
		return this.uPassword;
	}
	
	
	
	
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getIdSexo() {
		return idSexo;
	}


	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}


	public int getIdPais() {
		return idPais;
	}


	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}


	public int getAnoIngreso() {
		return anoIngreso;
	}


	public void setAnoIngreso(int anoIngreso) {
		this.anoIngreso = anoIngreso;
	}


	public int getNuevoAntiguo() {
		return nuevoAntiguo;
	}


	public void setNuevoAntiguo(int nuevoAntiguo) {
		this.nuevoAntiguo = nuevoAntiguo;
	}


	public List listarUsuarios()
	{
        String sql="SELECT * FROM Usuario";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	
	public int buscarCodUsuario(String uLogin)
	{
        String sql="SELECT idUsuario FROM Usuario WHERE uLogin = '"+uLogin+"'";
        int id = this.jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(id);
        
        return id;
	}
	
	
	public boolean loginUsuario(String uLogin, String uPassword){
		
		boolean sw = false;
	    String sql="SELECT ulogin, upassword FROM Usuario WHERE ulogin = '" + uLogin +"' AND upassword = '"+uPassword+"'";	    
	    List datos = this.jdbcTemplate.queryForList(sql);

	    if(datos.size() == 1)
	    {	
	    	sw = true;
	    }else{
	    	sw = false;
	    }
		
		return sw;
	}
	
	public int obtenerTotalUsuarios()
	{
		String sql="SELECT (MAX(idUsuario)) AS id FROM Usuario";	
		int id = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return id;
	}
	
	
	public boolean registroUsuario(Usuario u)
	{
		String sql="SELECT (MAX(idUsuario)+1) AS id FROM Usuario";	
		int id = this.jdbcTemplate.queryForObject(sql, Integer.class);
	    
	    
	    String sql2 ="INSERT INTO Usuario (idUsuario,nombreUsuario,email,uLogin,uPassword,edad,idSexo,idPais,anoIngreso,nuevoAntiguo) VALUES "
	    			+ "("+id+",'"+u.getNombreUsuario()+"','"+u.getEmail()+"','"+u.GetuLogin() +"','"+u.Getupassword()+"',"+u.getEdad()+","+u.getIdSexo()
	    			+ ","+u.getIdPais()+","+u.anoIngreso+","+u.getNuevoAntiguo()+")";
	    
	    int res = this.jdbcTemplate.update(sql2);
	    
	    if(res>0)
	    {
	    	String sql3 = "delete from Valoracion where idUsuario = "+id;
	    	res = this.jdbcTemplate.update(sql3);
		   
	    	String sql4 = "insert into Valoracion select 13000 + idValoracion, valoracion,  "+id+" as idUsuario, idCancion  from Valoracion where idUsuario = 16";
	    	res = this.jdbcTemplate.update(sql4);
		    
	    	
	    }
	    
	    
	    
	    if(res>0)
	    {
	    	return true;
	    }else
	    {
	    	return false;
	    }
	    

	}
	
	
	
}
