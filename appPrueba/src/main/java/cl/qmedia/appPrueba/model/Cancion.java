package cl.qmedia.appPrueba.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Cancion {

	private JdbcTemplate jdbcTemplate;

	public Cancion ()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	public List top6Canciones()
	{
        String sql="SELECT * FROM vCancionesMasValoradas ORDER BY cantidadValoraciones DESC LIMIT 5";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	
	//public List ListarCancionesRecomendadas(List <ItemRecomendado>canciones)
	public String retornaQuery(List <ItemRecomendado>canciones)
	{
		
		
        String sql="SELECT * FROM Cancion WHERE codCancion IN (";
        
        for(int i = 0; i < canciones.size(); i++)
        {
        	sql = sql+ canciones.get(i).GetItemId()+",";
        	
        }
        
        sql = sql.substring(0, sql.length()-1);
        sql = sql+")";
        

        return sql;
	}
	
	

	
	public List buscarCancionPorCodigo(int codCancion)
	{
        String sql="SELECT Cancion.codCancion as codCancion, Cancion.nombreCancion as nombreCancion, Artista.idArtista as idArtista, Artista.nombreArtista as nombreArtista, Album.idAlbum as idAlbum, Album.nombreAlbum as nombreAlbum FROM Cancion, Album, Artista WHERE Cancion.idAlbum = Album.idAlbum AND Album.idArtista = Artista.idArtista AND codCancion = "+codCancion;
        List datos = this.jdbcTemplate.queryForList(sql);

        return datos;
	}
	
	
	
	//Recomendacion canciones basadas en filtrado colaborativo
	
	public List cancionesRecomendadasBasadoUsuario(int idUsuario, int cantidadUsuarios) throws TasteException, IOException, NoSuchFieldException, SecurityException
	{
		
		
		MahoutImpl mahout = new MahoutImpl();
		String sql = null;
		
		//datos items recomendados
		List datosCanciones = mahout.recomendacionBasadaUsuario(idUsuario, cantidadUsuarios);
		
		//Generar query
		sql = retornaQuery(datosCanciones);
		System.out.println(sql);
		
		
		//retornar canciones recomendados
		List canciones = this.jdbcTemplate.queryForList(sql);
		
		return canciones;
		
		
	}
		
	
	
	public List cancionesRecomendadasBasadoItem(int codCancion) throws TasteException, IOException, NoSuchFieldException, SecurityException
	{
		MahoutImpl mahout = new MahoutImpl();
		String sql = null;
		
		//datos items recomendados		
		List<ItemRecomendado> datosCanciones =  mahout.recomendacionBasadaItem(codCancion);
		 
		//Generar query
		sql = retornaQuery(datosCanciones);
		
		//retornar canciones recomendados
		List Canciones = this.jdbcTemplate.queryForList(sql);
		
		return Canciones;		
		
	}
		
	
	//recomendar en base al ultimo item buscado
	public List recomendarCancionesHistorial(int codCancion) throws TasteException, IOException, NoSuchFieldException, SecurityException
	{
		
		
		MahoutImpl mahout = new MahoutImpl();
		String sql = null;
		
		//datos items recomendados		
		List<ItemRecomendado> datosCanciones =  mahout.recomendacionBasadaItem(codCancion);
		 
		//Generar query
		sql = retornaQuery(datosCanciones);
		
		//retornar canciones recomendados
		List canciones = this.jdbcTemplate.queryForList(sql);
		
		return canciones;		

	}
	
	public List listarCanciones()
	{
        String sql="SELECT * FROM Cancion";
        List datos = this.jdbcTemplate.queryForList(sql);
		return datos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
