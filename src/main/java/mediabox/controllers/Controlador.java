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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		//List<Serie> Cincoseries=serieservice.listarCincoSeries();
		
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
			
			System.err.println((int)horas+"h"+(int)minutos+"min");
			
			}else {
				
				double minutos=(aux-horas)*60;
				
				System.err.println((int)horas+"h"+(int)minutos+"min");
				
			}
			
		}*/
		
		/*for(Serie s:Cincoseries) {
			
			System.err.println(s);
			//System.err.println(s.getIdserie() + " " + "Serie: " + s.getTitulo());
			
		}*/
		
		modelAndview.setViewName("index");
		
		session.setAttribute("Cincopeliculas", Cincopeliculas);
		modelAndview.addObject("peliculas5",Cincopeliculas);
		
		//modelAndview.addObject("5series",Cincoseries);
		
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
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Pelicula> peliculasTodo=peliculaservice.listarPeliculas();
		
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		
		for(Pelicula p:peliculasTodo) {
			
			Pelicula pelicula=new Pelicula();
			
			pelicula.setIdpelicula(p.getIdpelicula());
			pelicula.setTitulo(p.getTitulo());
			pelicula.setImagen(p.getImagen());
			
			peliculas.add(pelicula);
			
		}
		
		/*int i=0;
		while(i<5) {
			
		Pelicula pelicula=peliculasTodo.get(i);
		System.err.println(pelicula.getIdpelicula() + " " + "Pelicula: " + pelicula.getTitulo() + " Imagen: " + pelicula.getImagen());
		i++;
		}*/
		
		Usuario usuario=(Usuario)session.getAttribute("usr");
		
		modelAndview.addObject("usr", usuario.getIdusuario());
		modelAndview.setViewName("peliculas");
		modelAndview.addObject("peliculas", peliculas);
				
		return modelAndview;
	}
	
	@RequestMapping("peliculaprovisional") 
	
	public ModelAndView Verpelicula(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		System.err.println("redirige a Ver pelicula");
		
		int Idpelicula=Integer.parseInt(req.getParameter("Idpelicula"));
		
		ModelAndView modelAndview=new ModelAndView();
		
		Pelicula pelicula=peliculaservice.buscarPeliculaporId(Idpelicula);
		
		System.err.println(pelicula);
		
		modelAndview.addObject("usr", session.getAttribute("usr"));
		modelAndview.setViewName("pelicula");
		modelAndview.addObject("pelicula", pelicula);
				
		return modelAndview;
	}
	
	@RequestMapping("series") 
	
	public ModelAndView series(HttpServletRequest req) {
		
		System.err.println("redirige a series");
		
		ModelAndView modelAndview=new ModelAndView();
		
		List<Serie> series=serieservice.listarSeries();
		
		int i=0;
		while(i<10) {
			
		Serie serie=series.get(i);
		System.err.println(serie.getIdserie() + " " + "Serie: " + serie.getTitulo());
		i++;
		}
		
		modelAndview.setViewName("series");
		modelAndview.addObject("series", series);
				
		return modelAndview;
	}
	
	@RequestMapping("fav_pelis") 
	
	public String peliculasfav(HttpServletRequest req) {
		
		System.err.println("redirige a peliculas favoritas");
		
		
				
		return "peliculas_favoritas";
	}
	
	@RequestMapping("fav_series") 
	
	public String seriesfav(HttpServletRequest req) {
		
		System.err.println("redirige a series favoritas");
				
		return "series_favoritas";
	}
	
	@RequestMapping("cerrarSesion") 
	
	public ModelAndView cerrarSesion(HttpServletRequest req) {
		System.err.println("Entra en cerrar sesion");
		ModelAndView modelAndview=new ModelAndView();
		HttpSession session = req.getSession(true);
		
		List<Pelicula> Cincopeliculas=(List<Pelicula>)session.getAttribute("Cincopeliculas");
		modelAndview.addObject("peliculas5",Cincopeliculas);
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
