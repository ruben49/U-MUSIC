package cl.qmedia.appPrueba.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Busquedas {

	
	private JdbcTemplate jdbcTemplate;
	
	private int idBusquedas;
	private int idUsuario;
	private String Detalle;
	
	

	public Busquedas()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	public List listaBusquedas(int idUsuario)
	{
        String sql="SELECT * FROM Busquedas WHERE idUsuario = "+idUsuario;
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	
	
	
	
	
	
}
