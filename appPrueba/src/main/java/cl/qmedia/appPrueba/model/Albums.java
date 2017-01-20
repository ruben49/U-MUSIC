package cl.qmedia.appPrueba.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Albums {

	private JdbcTemplate jdbcTemplate;

	public Albums()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	public List top6Albums()
	{
        String sql="SELECT * FROM vDetalleValoracionesAlbum ORDER BY valoracion DESC LIMIT 5";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	public List listarAlbums()
	{
        String sql="SELECT * FROM Album";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	public List albumsArtistas(String idArtista)
	{
        String sql="SELECT * FROM Album WHERE idArtista = '"+idArtista+"'";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
}
