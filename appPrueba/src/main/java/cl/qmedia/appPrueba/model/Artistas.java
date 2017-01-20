package cl.qmedia.appPrueba.model;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Artistas {

	private JdbcTemplate jdbcTemplate;

	

	public Artistas()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	public List top6Artistas()
	{
        String sql="SELECT * FROM  vDetalleValoracionesArtistaAlbum ORDER BY valoracion DESC LIMIT 5";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	public String artistaRetornaQuery(List <ItemRecomendado>artistas)
	{
		
		
        String sql="SELECT * FROM Artista WHERE idArtista IN (";
        
        for(int i = 0; i < artistas.size(); i++)
        {
        	sql = sql+ artistas.get(i).GetItemId()+",";
        	
        }
        
        sql = sql.substring(0, sql.length()-1);
        sql = sql+")";
        
        
        return sql;
	}
	
	
	
	
	public List artistasRecomendadosBasadosUsuarios(int idUsuario, int cantidadUsuarios) throws TasteException, IOException, NoSuchFieldException, SecurityException
	{
		
		MahoutImpl mahout = new MahoutImpl();
		String sql = null;
		
		
		//datos items recomendados
		List <ItemRecomendado> datosArtistas =  mahout.artistaRecomendarBasadaUsuario(idUsuario, cantidadUsuarios);
		
		
		//Generar query
		sql = artistaRetornaQuery(datosArtistas);
		System.out.println(sql);
		
		//retornar artistas recomendados
		
        List artistas = this.jdbcTemplate.queryForList(sql);
        
		return artistas;
		
	
	}
	
	
	public List artistasRecomendadosBasadosItem(String idArtista) throws TasteException, IOException, NoSuchFieldException, SecurityException
	{
		
		MahoutImpl mahout = new MahoutImpl();
		String sql = null;
		
		
		//datos items recomendados
		List <ItemRecomendado> datosArtistas =  mahout.recomendacionArtistaBasadaItem(idArtista);
		
		
		//Generar query
		sql = artistaRetornaQuery(datosArtistas);
		System.out.println(sql);
		
		//retornar artistas recomendados
		
        List artistas = this.jdbcTemplate.queryForList(sql);
        
		return artistas;
		
	
	}
	
	
	public List listarArtistas()
	{
        String sql="SELECT * FROM Artista";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	public List listarArtistasGenero(int idGenero)
	{
        String sql="SELECT Artista.idArtista as idArtista, Artista.nombreArtista as nombreArtista FROM Artista, SubGenero WHERE Artista.idSubGenero = SubGenero.idSubGenero AND SubGenero.idGenero = "+idGenero;
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	
	public List retornaNombreArtistaPorId(String idArtista)
	{
        String sql="SELECT Artista.nombreArtista as nombreArtista  FROM Artista WHERE idArtista =  '"+idArtista+"'";
        List datos = this.jdbcTemplate.queryForList(sql);

        return datos;
	}
	
	
	
}
