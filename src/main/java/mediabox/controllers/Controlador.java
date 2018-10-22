package mediabox.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus.Series;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mediabox.interfaces.IPelFavoritaService;
import mediabox.interfaces.IPeliculaService;
import mediabox.interfaces.ISerieService;
import mediabox.interfaces.IUsuarioService;
import mediabox.model.*;
import mediabox.services.*;

@Controller
public class Controlador  {
	@Autowired
	private PruebaService pruebaservice;
	@Autowired
	private IUsuarioService usuarioservice;
	@Autowired
	private IPeliculaService peliculaservice;
	@Autowired
	private ISerieService serieservice;
	
	//*************************************PRUEBA AREA******************************************************************************
	//*************************************************************************************************************************************
	
@RequestMapping("/prueba") 
	
	public String prueba(HttpServletRequest req) {
		
		System.out.println("prueba");
		pruebaservice.pruebaSelect();
				
		return "index";
	}
	
	
	
	//*************************************PUBLIC AREA******************************************************************************
	//*************************************************************************************************************************************
	
	
	@RequestMapping("/") 
	
	public ModelAndView indice(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		ModelAndView modelAndview=new ModelAndView();
		
		System.err.println("entra indice");
		
		List<Pelicula> CincopeliculasTodo=peliculaservice.listarCincoPeliculas();
		
		List<Pelicula> Cincopeliculas= new ArrayList<Pelicula>();
		
		for(Pelicula p:CincopeliculasTodo) {
			
			//System.err.println(p);
			
			Pelicula pelicula=new Pelicula();
			pelicula.setIdpelicula(p.getIdpelicula());
			pelicula.setImagen(p.getImagen());
			pelicula.setTitulo(p.getTitulo());
			
			Cincopeliculas.add(pelicula);
			
		}
		
		/*for(Pelicula pel:CincopeliculasTodo) {
			
			
			System.err.println("Idpelicula: " + pel.getIdpelicula() + " Titulo: " + pel.getTitulo()
			+ " Imagen: " + pel.getImagen());
			
			double duracion=Double.parseDouble(pel.getDuracion());
			System.err.println("duracion: " + duracion);
			double aux=duracion/60;
			System.err.println("Aux: " + aux);
			double horas=Math.round(aux);
			
			if((aux-horas)<0) {
				
			double minutos=(aux-horas+1)*60;
			
			horas=horas-1;
			
			System.err.println((int)horas+"h"+(int)minutos+"min");
			
			}else {
				
				double minutos=(aux-horas)*60;
				
				System.err.println((int)horas+"h"+(int)minutos+"min");
				
			}
			
		}*/
		
		List<Serie> CincoseriesTodo=serieservice.listarCincoSeries();
		
		List<Serie> Cincoseries= new ArrayList<Serie>();
		
		for(Serie s:CincoseriesTodo) {
			
			//System.err.println(p);
			
			Serie serie=new Serie();
			serie.setIdserie(s.getIdserie());
			serie.setTitulo(s.getTitulo());
			serie.setImagen(s.getImagen());
			
			Cincoseries.add(serie);
			
		}
		
		/*System.err.println("Ejemplo serie: " + CincoseriesTodo.get(0));
		System.err.println("Ejemplo pelicula: " + CincopeliculasTodo.get(0));
		
		for(Serie s:Cincoseries) {
			
			//System.err.println(s);
			System.err.println(s.getIdserie() + " " + "Serie: " + s.getTitulo() + " Imagen: " + s.getImagen());
			
		}*/
		
		modelAndview.setViewName("index");
		
		session.setAttribute("Cincopeliculas", Cincopeliculas);
		modelAndview.addObject("peliculas5",Cincopeliculas);
		
		session.setAttribute("Cincoseries", Cincoseries);
		modelAndview.addObject("series5",Cincoseries);
		
		return modelAndview;
	}
	
	@RequestMapping("altausuarios") 
	
	public String altausuarios(HttpServletRequest req) {
		
		System.err.println("redirige a registro");
				
		return "registro";
	}
	
	@RequestMapping("admin_usuario") 
	
	public String administrarusuario(HttpServletRequest req) {
		
		System.err.println("redirige a admin_usuario");
				
		return "admin_usuario";
	}
	
	
	
	@RequestMapping("pelis") 
	
	public ModelAndView peliculas(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("redirige a peliculas");
		
		String id=req.getParameter("id");
		String categoriabuscador=req.getParameter("Categoria");
		String titulobuscador=req.getParameter("Titulo");
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Pelicula> peliculasTodo=peliculaservice.listarPeliculas();
		
		List<Pelicula> peliculasmostrar=new ArrayList<Pelicula>();
		peliculasmostrar=peliculasTodo;
		
		/*if(titulobuscador.equals("") || categoriabuscador.equals("")) {
			
			peliculasmostrar=peliculasTodo;
			System.err.println("Mostrará todas las peliculas disponibles");
			
		}else {
			
			
			
		}*/
		
		/*if(categoriabuscador.equals("")) {
			
			peliculasmostrar=peliculasTodo;
			System.err.println("Mostrará todas las peliculas disponibles");
			
		}else {
			
			for(Pelicula p:peliculasTodo) {
				
				if(p.getCategoria().contains(categoriabuscador)) {
					
					peliculasmostrar.add(p);
					
				}
				
			}
			
		}
		
		if(titulobuscador.equals("")) {
			
			peliculasmostrar=peliculasTodo;
			System.err.println("Mostrará todas las peliculas disponibles");
			
		}else {
			
			for(Pelicula p:peliculasTodo) {
				
				if(p.getCategoria().contains(categoriabuscador)) {
					
					peliculasmostrar.add(p);
					
				}
				
			}
			
		}*/
		
		int npeliculas=peliculasmostrar.size();
		
		int npaginas=npeliculas/8;
		
		int pelinicio;
		int pelfinal;
		
		String identificador;
		
		if(id==null) {
		
		pelinicio=0;
		pelfinal=8;
		identificador=id;
		
		}else if(Integer.parseInt(id)<1) {
			
			identificador="1";
			pelinicio=0;
			pelfinal=8;
			
		}else if(Integer.parseInt(id)>npaginas) {
			
			identificador=String.valueOf(npaginas);
			pelinicio=(Integer.parseInt(id)-2)*8;
			pelfinal=pelinicio+8;
			
	}else {
			
			pelinicio=(Integer.parseInt(id)-1)*8;
			pelfinal=pelinicio+8;
			identificador=id;
			
		}
		
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		
		
		
		for(int i=pelinicio; i<pelfinal; i++) {
			
			Pelicula pelicula=new Pelicula();
			
			pelicula.setIdpelicula(peliculasmostrar.get(i).getIdpelicula());
			pelicula.setTitulo(peliculasmostrar.get(i).getTitulo());
			pelicula.setImagen(peliculasmostrar.get(i).getImagen());
			
			peliculas.add(pelicula);
			
		}
		
		/*int i=0;
		while(i<5) {
			
		Pelicula pelicula=peliculasTodo.get(i);
		System.err.println(pelicula.getIdpelicula() + " " + "Pelicula: " + pelicula.getTitulo() + " Imagen: " + pelicula.getImagen()
		+ " Enlace: " + pelicula.getWatch());
		i++;
		}*/
		
		System.err.println("Numero de peliculas: " + npeliculas + " Numero de paginas: " + npaginas);
		
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("peliculas");
		modelAndview.addObject("pelis", peliculas);
		modelAndview.addObject("npaginas", npaginas);
		modelAndview.addObject("id", identificador);
				
		return modelAndview;
	}
	
	@RequestMapping("pelicula") 
	
	public ModelAndView Verpelicula(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("redirige a Ver pelicula");
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		int Idpelicula=Integer.parseInt(req.getParameter("idPel"));
		
		ModelAndView modelAndview=new ModelAndView();
		
		Pelicula p=peliculaservice.buscarPeliculaporId(Idpelicula);
		//boolean comprobacion=peliculaservice.comprobarFavorito(Idpelicula, usuario.getIdusuario());
		
		System.err.println(p);
		System.err.println("Categoria: " + p.getCategoria());
		
		Pelicula pelicula=new Pelicula();
		
		pelicula.setIdpelicula(p.getIdpelicula());
		pelicula.setCategoria(p.getCategoria());
		pelicula.setTitulo(p.getTitulo());
		pelicula.setYear(p.getYear());
		pelicula.setCalificacion(p.getCalificacion());
		pelicula.setDescripcion(p.getDescripcion());
		if(p.getDirector().equals("null")) {
			
			pelicula.setDirector("No disponible");
			
		}else {
			
			pelicula.setDirector(p.getDirector());
			
		}
		
		if(p.getProtagonista().equals("null")) {
			
			pelicula.setProtagonista("No disponible");
			
		}else {
			
			pelicula.setProtagonista(p.getProtagonista());
			
		}
		pelicula.setImagen(p.getImagen());
		pelicula.setWatch(p.getWatch());
		
		String duracionPelicula;
		
		if(p.getDuracion()==null) {
			
			duracionPelicula="No está disponible";
			
		}else {
			double duracion=Double.parseDouble(p.getDuracion());
			System.err.println("duracion: " + duracion);
			double aux=duracion/60;
			System.err.println("Aux: " + aux);
			double horas=Math.round(aux);
			double minutos;
			
			if((aux-horas)<0) {
				
			minutos=(aux-horas+1)*60;
			
			horas=horas-1;
			
			}else {
				
				minutos=(aux-horas)*60;
				
			}
			
			duracionPelicula=(int)horas+"h"+(int)minutos+"min";
			System.err.println(duracionPelicula);
			
		}
		
		//modelAndview.addObject("favorito", comprobacion);
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("pelicula");
		modelAndview.addObject("pelicula", pelicula);
		modelAndview.addObject("duracion", duracionPelicula);
				
		return modelAndview;
	}
	
	
	
	@RequestMapping("series") 
	
	public ModelAndView series(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("redirige a series");
		
		String id=req.getParameter("id");
		//String categoriabuscador=req.getParameter("Categoria");
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Serie> seriesTodo=serieservice.listarSeries();
		
		List<Serie> seriesmostrar=new ArrayList<Serie>();
		seriesmostrar=seriesTodo;
		/*if(categoriabuscador.equals("")) {
			
			peliculasmostrar=peliculasTodo;
			System.err.println("Mostrará todas las peliculas disponibles");
			
		}else {
			
			for(Pelicula p:peliculasTodo) {
				
				if(p.getCategoria().contains(categoriabuscador)) {
					
					peliculasmostrar.add(p);
					
				}
				
			}
			
		}*/
		
		int nseries=seriesmostrar.size();
		
		int npaginas=nseries/8;
		
		int serieinicio;
		int seriefinal;
		
		String identificador;
		
		if(id==null) {
		
		serieinicio=0;
		seriefinal=8;
		identificador=id;
		
		}else if(Integer.parseInt(id)<1) {
			
			identificador="1";
			serieinicio=0;
			seriefinal=8;
			
		}else if(Integer.parseInt(id)>npaginas) {
			
			identificador=String.valueOf(npaginas);
			serieinicio=(Integer.parseInt(id)-2)*8;
			seriefinal=serieinicio+8;
			
	}else {
			
			serieinicio=(Integer.parseInt(id)-1)*8;
			seriefinal=serieinicio+8;
			identificador=id;
			
		}
		
		List<Serie> series= new ArrayList<Serie>();
		
		
		
		for(int i=serieinicio; i<seriefinal; i++) {
			
			Serie serie=new Serie();
			
			serie.setIdserie(seriesmostrar.get(i).getIdserie());
			serie.setTitulo(seriesmostrar.get(i).getTitulo());
			serie.setImagen(seriesmostrar.get(i).getImagen());
			
			series.add(serie);
			
		}
		
		/*int i=0;
		while(i<5) {
			
		Pelicula pelicula=peliculasTodo.get(i);
		System.err.println(pelicula.getIdpelicula() + " " + "Pelicula: " + pelicula.getTitulo() + " Imagen: " + pelicula.getImagen()
		+ " Enlace: " + pelicula.getWatch());
		i++;
		}*/
		
		System.err.println("Numero de peliculas: " + nseries + " Numero de paginas: " + npaginas);
		
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("series");
		modelAndview.addObject("series", series);
		modelAndview.addObject("npaginas", npaginas);
		modelAndview.addObject("id", identificador);
				
		return modelAndview;
		
	}
	
	@RequestMapping("serie") 
	
	public ModelAndView Verserie(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("redirige a Ver serie");
		
		int Idserie=Integer.parseInt(req.getParameter("idserie"));
		
		ModelAndView modelAndview=new ModelAndView();
		
		//Empieza pelicula
		
		Serie s=serieservice.buscarSerieporId(Idserie);
		
		System.err.println(s);
		System.err.println("Categoria: " + s.getCategoria());
		
		Serie serie=new Serie();
		
		serie.setIdserie(s.getIdserie());
		serie.setCategoria(s.getCategoria());
		serie.setTitulo(s.getTitulo());
		serie.setYear(s.getYear());
		serie.setCalificacion(s.getCalificacion());
		serie.setDescripcion(s.getDescripcion());
		if(s.getDirector().equals("null")) {
			
			serie.setDirector("No disponible");
			
		}else {
			
			serie.setDirector(s.getDirector());
			
		}
		
		if(s.getProtagonista().equals("null")) {
			
			serie.setProtagonista("No disponible");
			
		}else {
			
			serie.setProtagonista(s.getProtagonista());
			
		}
		serie.setImagen(s.getImagen());
		serie.setWatch(s.getWatch());
		
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("serie");
		modelAndview.addObject("serie", serie);
		
				
		return modelAndview;
	}
	
	@RequestMapping("fav_pelis") 
	
	public ModelAndView peliculasfav(HttpServletRequest req) {
		
		System.err.println("redirige a peliculas favoritas");
		
		HttpSession session = req.getSession(true);
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		String id=req.getParameter("id");
		/*String categoriabuscador=req.getParameter("Categoria");
		String titulobuscador=req.getParameter("Titulo");*/
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Pelicula> peliculasFav=peliculaservice.listarPeliculasFavporUsuario(usuario.getIdusuario());
		
		List<Pelicula> peliculasmostrar=new ArrayList<Pelicula>();
		peliculasmostrar=peliculasFav;
		
		int npeliculas=0;
		int npaginas=1;
		String mensaje="";
		String identificador;
		
		if(peliculasmostrar.size()==0) {
			
			mensaje="No hay favoritos";
			System.err.println(mensaje);
			identificador="0";
			
		}else {
		
		npeliculas=peliculasmostrar.size();
		
		npaginas=npeliculas/8;
		
		}
		
		int pelinicio;
		int pelfinal;
		
		if(id==null) {
		
		pelinicio=0;
		pelfinal=8;
		identificador=id;
		
		}else if(Integer.parseInt(id)<1) {
			
			identificador="1";
			pelinicio=0;
			pelfinal=8;
			
		}else if(Integer.parseInt(id)>npaginas) {
			
			identificador=String.valueOf(npaginas);
			pelinicio=(Integer.parseInt(id)-2)*8;
			pelfinal=pelinicio+8;
			
	}else {
			
			pelinicio=(Integer.parseInt(id)-1)*8;
			pelfinal=pelinicio+8;
			identificador=id;
			
		}
		
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		
		if(npeliculas!=0) {
		
		for(int i=pelinicio; i<pelfinal; i++) {
			
			Pelicula pelicula=new Pelicula();
			
			pelicula.setIdpelicula(peliculasmostrar.get(i).getIdpelicula());
			pelicula.setTitulo(peliculasmostrar.get(i).getTitulo());
			pelicula.setImagen(peliculasmostrar.get(i).getImagen());
			
			peliculas.add(pelicula);
			
		}
		
		int i=0;
		while(i<5) {
			
		Pelicula pelicula=peliculas.get(i);
		System.err.println(pelicula.getIdpelicula() + " " + "Pelicula: " + pelicula.getTitulo() + " Imagen: " + pelicula.getImagen());
		i++;
		}
		}
		System.err.println("Numero de peliculas: " + npeliculas + " Numero de paginas: " + npaginas);

		modelAndview.addObject("mensaje", mensaje);
		modelAndview.addObject("pelis", peliculas);
		modelAndview.addObject("npaginas", npaginas);
		modelAndview.addObject("id", identificador);
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("peliculas_favoritas");
		return modelAndview;
			
	}
	
	@RequestMapping("fav_series") 
	
	public ModelAndView seriesfav(HttpServletRequest req) {
		
		System.err.println("redirige a series favoritas");
		
		HttpSession session = req.getSession(true);
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		String id=req.getParameter("id");
		/*String categoriabuscador=req.getParameter("Categoria");
		String titulobuscador=req.getParameter("Titulo");*/
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Serie> seriesFav=serieservice.listarSeriesFavporUsuario(usuario.getIdusuario());
		
		List<Serie> seriesmostrar=new ArrayList<Serie>();
		seriesmostrar=seriesFav;
		
		int nseries=0;
		int npaginas=1;
		String mensaje="";
		String identificador;
		
		if(seriesmostrar.size()==0) {
			
			mensaje="No hay favoritos";
			System.err.println(mensaje);
			identificador="0";
			
		}else {
		
		nseries=seriesmostrar.size();
		
		npaginas=nseries/8;
		
		}
		
		int serieinicio;
		int seriefinal;
		
		if(id==null) {
		
		serieinicio=0;
		seriefinal=8;
		identificador=id;
		
		}else if(Integer.parseInt(id)<1) {
			
			identificador="1";
			serieinicio=0;
			seriefinal=8;
			
		}else if(Integer.parseInt(id)>npaginas) {
			
			identificador=String.valueOf(npaginas);
			serieinicio=(Integer.parseInt(id)-2)*8;
			seriefinal=serieinicio+8;
			
	}else {
			
			serieinicio=(Integer.parseInt(id)-1)*8;
			seriefinal=serieinicio+8;
			identificador=id;
			
		}
		
		List<Serie> series= new ArrayList<Serie>();
		
		if(nseries!=0) {
		
		for(int i=serieinicio; i<seriefinal; i++) {
			
			Serie serie=new Serie();
			
			serie.setIdserie(seriesmostrar.get(i).getIdserie());
			serie.setTitulo(seriesmostrar.get(i).getTitulo());
			serie.setImagen(seriesmostrar.get(i).getImagen());
			
			series.add(serie);
			
		}
		
		int i=0;
		while(i<5) {
			
		Serie serie=series.get(i);
		System.err.println(serie.getIdserie() + " " + "Pelicula: " + serie.getTitulo() + " Imagen: " + serie.getImagen());
		i++;
		}
		}
		System.err.println("Numero de series: " + nseries + " Numero de paginas: " + npaginas);
		
		modelAndview.addObject("mensaje", mensaje);
		modelAndview.addObject("series", series);
		modelAndview.addObject("npaginas", npaginas);
		modelAndview.addObject("id", identificador);
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("series_favoritas");
		return modelAndview;
			
	}
	
	@RequestMapping("cerrarSesion") 
	
	public ModelAndView cerrarSesion(HttpServletRequest req) {
		System.err.println("Entra en cerrar sesion");
		ModelAndView modelAndview=new ModelAndView();
		HttpSession session = req.getSession(true);
		
		List<Pelicula> Cincopeliculas=(List<Pelicula>)session.getAttribute("Cincopeliculas");
		modelAndview.addObject("peliculas5",Cincopeliculas);
		
		List<Serie> Cincoseries=(List<Serie>)session.getAttribute("Cincoseries");
		modelAndview.addObject("series5",Cincoseries);
		
		/*for(Pelicula pel:Cincopeliculas) {
			
			System.err.println("Idpelicula: " + pel.getIdpelicula() + " Titulo: " + pel.getTitulo()
			+ " Imagen: " + pel.getImagen());
			
		}*/
		
		session.removeAttribute("usr");
		modelAndview.setViewName("index");
		return modelAndview;
	}
	
	@RequestMapping("addusuario") 
	public ModelAndView registrarse(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("registrandose");
		String mensaje;
		
		String user=req.getParameter("usu");
		String pass=req.getParameter("password");
		String repass=req.getParameter("re_password");
		String email=req.getParameter("email");
		String alias="";
		//String alias=req.getParameter("alias");
		String nombre="";
		String apellidos="";
		/*String nombre=req.getParameter("nombre");
		String apellidos=req.getParameter("apellidos");*/
	
		ModelAndView modelAndview=new ModelAndView();
		
		System.err.println("Usuario: " + user + " Pass: " + pass + " Repass: " + repass + " email: " + email);
		
		/*if(user.equals("") ||pass.equals("") || email.equals("") || 
				nombre.equals("") || apellidos.equals("") || alias.equals("")) { */
		
		if(user.equals("") ||pass.equals("") || repass.equals("") || email.equals("")) {
		
			mensaje="Rellene todos los campos"; 
			
			modelAndview.setViewName("registro");
			modelAndview.addObject("mensaje_registro", mensaje);
		
		}else {
			
			if(pass.equals(repass)){
			
			mensaje=usuarioservice.addusuario(user, pass, email,alias, 
					nombre, apellidos );
			
			if(mensaje.equals("Este usuario ya existe")) {
				
				modelAndview.addObject("mensaje_registro", mensaje);
				modelAndview.setViewName("registro");
				
			}else if(mensaje.equals("Este email ya existe")){
				
				modelAndview.addObject("mensaje_registro", mensaje);
				modelAndview.setViewName("registro");
				
			}else {
			
				List<Pelicula> Cincopeliculas=(List<Pelicula>)session.getAttribute("Cincopeliculas");
				modelAndview.addObject("peliculas5",Cincopeliculas);
				/*for(Pelicula pel:Cincopeliculas) {
					
					System.err.println("Idpelicula: " + pel.getIdpelicula() + " Titulo: " + pel.getTitulo()
					+ " Imagen: " + pel.getImagen());
					
				}*/
			modelAndview.addObject("mensaje_login", mensaje);
			modelAndview.setViewName("index");
			
			}
			
		}else {
			
			mensaje="La contraseña introducida no coincide";
			modelAndview.setViewName("registro");
			modelAndview.addObject("mensaje_registro", mensaje);
			
		}
		
		}
		return modelAndview; 
	}
	
	@RequestMapping("/iniSesion") 
	public ModelAndView iniciosesion(HttpServletRequest req) {
		System.err.println("entra en inicio sesion");
		HttpSession session = req.getSession(true);
		
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		
		String mensaje;
		
		ModelAndView modelAndview=new ModelAndView(); 
		
		List<Pelicula> Cincopeliculas=(List<Pelicula>)session.getAttribute("Cincopeliculas");
		/*for(Pelicula pel:Cincopeliculas) {
			
			System.err.println("Idpelicula: " + pel.getIdpelicula() + " Titulo: " + pel.getTitulo()
			+ " Imagen: " + pel.getImagen());
			
		}*/
		
		if(user.equals("") || password.equals("")) {
		
			mensaje="Rellene todos los campos"; 
			
			
		}else {
			
			Usuario usuario=usuarioservice.comprobarusuario(user, password); //El Usuario que genera solo tiene id y password
		
		if(usuario==null) { 
			
			mensaje="Usuario o contraseña incorrecto"; 
			
			
		}else {
			
			session.setAttribute("usr", usuario);
			
			modelAndview.addObject("usr", user);
			
			mensaje="Sesión iniciada";
			
		}
		}	modelAndview.addObject("peliculas5",Cincopeliculas);
			modelAndview.setViewName("index");
			modelAndview.addObject("mensaje_login", mensaje);
			return modelAndview; 
	
	}
	
	
	
}
