package cl.qmedia.appPrueba.model;

import static org.mockito.Matchers.anyInt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.google.gson.Gson;

public class Archivo {

	
	private JdbcTemplate jdbcTemplate;
	
	public Archivo()
	{
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
	}
	
	public void generarArchivoCancionesUser(List<Map> listado) throws IOException, NoSuchFieldException, SecurityException
	{
		
		listado = cargarListaCancionUsuario();
		
		
		File fichero = new File("C:/cancionesUser.csv");
		BufferedWriter bw ;
		System.out.println(listado);
		
		if(fichero.exists())
		{
			bw= new BufferedWriter(new FileWriter("C:/cancionesUser.csv"));
			bw.write("");
			bw.close();
			
		}
		
		bw= new BufferedWriter(new FileWriter("C:/cancionesUser.csv"));
		
		for (Map b  : listado) {
			bw.write(b.get("idUsuario") + "," + b.get("codCancion")  + "," + b.get("valoracion") + "\n");

		}

		
		bw.close();
		
		
	
	}
	
	
	public void generarArchivoArtistaUser(List<Map> listado) throws IOException, NoSuchFieldException, SecurityException
	{
		
		listado = cargarListaArtistasUsuario();
		
		
		File fichero = new File("C:/artistasUser.csv");
		BufferedWriter bw ;
		System.out.println(listado);
		
		if(fichero.exists())
		{
			bw= new BufferedWriter(new FileWriter("C:/artistasUser.csv"));
			bw.write("");
			bw.close();
			
		}
		
		bw= new BufferedWriter(new FileWriter("C:/artistasUser.csv"));
		
		for (Map b  : listado) {
			bw.write(b.get("idUsuario") + "," + b.get("idArtista")  + "," + b.get("valoracion") + "\n");

		}

		
		bw.close();
		
		
	
	}
	
	
	
	
	
	
	public List cargarListaCancionUsuario()
	{
		
        String sql="SELECT * FROM vDetalleValoracionesUsuario";
        List d = this.jdbcTemplate.queryForList(sql);
		return d;
		
	}
	

	
	public List cargarListaArtistasUsuario()
	{
		
        String sql="SELECT * FROM vValoracionArtista";
        List d = this.jdbcTemplate.queryForList(sql);
		return d;
		
	}
	
	
	
}
