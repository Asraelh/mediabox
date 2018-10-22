package mediabox.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.ISerieRepository;
import mediabox.interfaces.ISerieService;
import mediabox.model.Pelicula;
import mediabox.model.Serie;

@Service
public class SerieService implements ISerieService {
		
		@Autowired
		private ISerieRepository seriesRepository;
		
		@Override
		public List<Serie> listarSeries() {
			// TODO Auto-generated method stub
			
			List<Serie> series=new ArrayList();
			
			for(Serie s:seriesRepository.listarTodas()) {//Incluir metodo listarTodas en el dao
				
				series.add(s);
				
			}
			
			return series;
		}

		@Override
		public List<Serie> listarCincoSeries() {
			// TODO Auto-generated method stub
			
			List<Serie> o=seriesRepository.show5Series(); //Incluir metodo show5Series en el dao
			return o;
			
		}
		
		@Override
		public Serie buscarSerieporId(int Idserie) {
			// TODO Auto-generated method stub
			
			Serie serie=seriesRepository.findSerieById(Idserie); 
			//Crear funcion findFilmById(Idpelicula) que devuelva una pelicula dado su Idpelicula
			
			return serie;
		}

		@Override
		public List<Serie> listarSeriesFavporUsuario(String user) {
			// TODO Auto-generated method stub
			
			List<Serie> SeriesFav=seriesRepository.listAllFavoriteSeries(user);
			
			return SeriesFav;
		}
		
		@Override
		public boolean comprobarFavorito(int Idserie, String user) {
			// TODO Auto-generated method stub
			
			boolean comprobacion=seriesRepository.checkSerieFav(user,Idserie);
			
			return comprobacion;
		}

		@Override
		public boolean addseriefavoritos(String user, int Idserie) {
			// TODO Auto-generated method stub
				
				boolean addserie=seriesRepository.insertarSerieFav(user, Idserie);
				
				return addserie;
			}

		@Override
		public void deleteseriefavoritos(String user, int Idserie) {
			// TODO Auto-generated method stub
			
			seriesRepository.deleteFavorito(user, Idserie);
			
		}

}



