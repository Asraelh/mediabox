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
			
			for(Serie s:seriesRepository.listarTodas()) {//Parece que hay que cambiar el metodo findAll
				
				series.add(s);
				
			}
			
			return series;
		}

		@Override
		public List<Serie> listarCincoSeries() {
			// TODO Auto-generated method stub
			
			Optional<List<Serie>> o=seriesRepository.show5Series();
			
			if(o.isPresent()) {
				
				return o.get();
				
			}else {
				
				return null;
		}
		}

}



