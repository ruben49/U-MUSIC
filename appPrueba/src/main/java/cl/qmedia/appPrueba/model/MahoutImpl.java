package cl.qmedia.appPrueba.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.GenericItemSimilarity.ItemItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import cl.qmedia.appPrueba.model.ItemRecomendado;

public class MahoutImpl {

	

	public MahoutImpl()
	{
		
	}	
	
	
	public List<ItemRecomendado> recomendacionBasadaUsuario(int idUsuario, int cantidadUsuarios) throws TasteException, IOException, NoSuchFieldException, SecurityException{
	
		
		 Archivo archivo = new Archivo();
		 List<Map> val = archivo.cargarListaCancionUsuario();
		 archivo.generarArchivoCancionesUser(val);
		 
		 
		 DataModel model = new FileDataModel(new File("C:/cancionesUser.csv"));
		 UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 
		 
		 //NearestNuserneighborhood primer parametro, cantidad total de usuarios
		 UserNeighborhood neighborhood = new NearestNUserNeighborhood(cantidadUsuarios, similarity, model);
		 UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		 
		 List<RecommendedItem> recommendations = recommender.recommend(idUsuario , 5);
		 
		 // primer parametro, id del usuario
		 // segundo parametro, cantidad de elementos a recomendar
		
		 
		 List <ItemRecomendado>itemsRecomendados = new ArrayList<>(); 
		 
		 for(int i = 0; i < recommendations.size(); i++)
		 {
			 ItemRecomendado r =  new ItemRecomendado();
			 r.SetItemId(recommendations.get(i).getItemID());
			 r.SetValue(recommendations.get(i).getValue());
			 
			 itemsRecomendados.add(r);
		 }
		 
		 return itemsRecomendados;
	 
	 }
	
	
	
	
	
	/*----------------------------------------------------------------------------------------------------*/
	
	public List<ItemRecomendado> recomendacionBasadaItem(int codCancion) throws TasteException, IOException, NoSuchFieldException, SecurityException{
		

		 DataModel model = new FileDataModel(new File("C:/cancionesUser.csv"));
		 ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 
		 GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);
		 
		
		 //primer parametro: codigo de la cancion
		 //segundo parametro: cantidad de canciones similares a recomendar
		 List<RecommendedItem>recommendations = recommender.mostSimilarItems(codCancion, 5);
		 
		 List <ItemRecomendado>itemsRecomendados = new ArrayList<>();
		 
		 for(int i = 0; i < recommendations.size(); i++)
		 {
			 ItemRecomendado r =  new ItemRecomendado();
			 r.SetItemId(recommendations.get(i).getItemID());
			 r.SetValue(recommendations.get(i).getValue());
			 
			itemsRecomendados.add(r);
		 }
		 
		 
		 
		 
		 return itemsRecomendados;
	 
	 }
	
	/*----------------------------------------------------------------------------------------------------*/
	

	
	public List<ItemRecomendado> artistaRecomendarBasadaUsuario(int idUsuario, int cantidadUsuarios) throws TasteException, IOException, NoSuchFieldException, SecurityException{
		
		 Archivo archivo = new Archivo();
		 List<Map> val = archivo.cargarListaArtistasUsuario();
		 archivo.generarArchivoArtistaUser(val);
		
		
		 DataModel model = new FileDataModel(new File("C:/artistasUser.csv"));
		 UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 
		 
		 //NearestNuserneighborhood primer parametro, cantidad total de usuarios
		 UserNeighborhood neighborhood = new NearestNUserNeighborhood(cantidadUsuarios, similarity, model);
		 UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		 
		 List<RecommendedItem> recommendations = recommender.recommend(idUsuario , 5);
		 
		 // primer parametro, id del usuario
		 // segundo parametro, cantidad de elementos a recomendar
		
		 
		 
		 List <ItemRecomendado>ItemsRecomendados = new ArrayList<>(); 
		 
		 for(int i = 0; i < recommendations.size(); i++)
		 {
			 ItemRecomendado r =  new ItemRecomendado();
			 r.SetItemId(recommendations.get(i).getItemID());
			 r.SetValue(recommendations.get(i).getValue());
			 
			 ItemsRecomendados.add(r);
		 }
		 
		 
		 
		 
		 return ItemsRecomendados;
	 
	 }
	
	
	
	public List<ItemRecomendado> recomendacionArtistaBasadaItem(String idArtista) throws TasteException, IOException, NoSuchFieldException, SecurityException{

		 int idArt = Integer.parseInt(idArtista);
		
		 DataModel model = new FileDataModel(new File("C:/artistasUser.csv"));
		 ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 
		 GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);
		 
		
		 //primer parametro: codigo de la cancion
		 //segundo parametro: cantidad de canciones similares a recomendar
		 List<RecommendedItem>recommendations = recommender.mostSimilarItems(idArt, 5);
		 
		 List <ItemRecomendado>itemsRecomendados = new ArrayList<>();
		 
		 for(int i = 0; i < recommendations.size(); i++)
		 {
			 ItemRecomendado r =  new ItemRecomendado();
			 r.SetItemId(recommendations.get(i).getItemID());
			 r.SetValue(recommendations.get(i).getValue());
			 
			itemsRecomendados.add(r);
		 }
		 
		 
		 
		 
		 return itemsRecomendados;
	 
	 }
	
	
	
	
}
