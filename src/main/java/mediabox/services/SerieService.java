package mediabox.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.ISerieRepository;
import mediabox.interfaces.ISerieService;
import mediabox.model.Serie;

@Service
public class SerieService implements ISerieService {
		
		@Autowired
		private ISerieRepository seriesRepository;
		
		@Override
		public List<Serie> listarSeries() {
			// TODO Auto-generated method stub
			
			List<Serie> series=new ArrayList();
			
			for(Serie s:seriesRepository.findAll()) {
				
				series.add(s);
				
			}
			
			return series;
		}

}



