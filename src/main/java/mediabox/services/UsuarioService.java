package mediabox.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.IUsuarioRepository;
import mediabox.interfaces.IUsuarioService;
import mediabox.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuariosRepository;

	@Override
	public String addusuario(String user, String password, String email,String alias, String nombre, String apellidos) {
		//System.err.println("Entra en el checkeo usuario");
		boolean check=usuariosRepository.checkUser(user, password);
		//System.err.println("Hace el checkeo usuario");
		String mensaje;
		if(!check) {
			//System.err.println("Entra en el checkeo email");
			boolean checkEmail=usuariosRepository.checkEmail(email);
			//System.err.println("Hace el checkeo email");
			if(!checkEmail) {
			//System.err.println("Antes de insertar usuario");
			usuariosRepository.insertUser(user,password,email,alias,nombre,apellidos);
			//System.err.println("Despues de insertar usuario");
			return mensaje="Usuario registrado correctamente";
			}else {
			return mensaje="Este email ya existe";
		}
		}else {
			return mensaje="Este usuario ya existe";
		}
		
		
		
//		Usuario usuario=new Usuario();
//		usuario.setIdusuario(user);
//		usuario.setPassword(password);
//		usuario.setAlias(alias);
//		usuario.setNombre(nombre);
//		usuario.setApellidos(apellidos);
//		usuario.setEmail(email);
//		
//		String mensaje;
//		//System.out.println("addusuario antes");
//		
//		Optional<Usuario> pro=usuariosRepository.findById(user); 
//		//System.out.println("addusuario despues");
//		
//		
//	
//		if(pro.isPresent()) {
//			System.err.println("existe");
//			mensaje="Este usuario ya existe";
//			
//		}else {
//			System.err.println("no existe");
//			usuariosRepository.save(usuario);
//			mensaje="Usuario registrado correctamente";
//		}
//		return mensaje;
	}

	@Override
	public Usuario comprobarusuario(String user, String password) {
		// TODO Auto-generated method stub
		
		System.err.println("Entra en comprobarusuario");
		Usuario usuario=null;
		Optional<Usuario> pro=usuariosRepository.findById(user); 
		System.err.println("Comprueba si el usuario esta registrado");
		if(pro.isPresent()) { //Si lo encuentra
		System.err.println("Usuario encontrado");
		
		
	if(pro.get().getPassword().equals(password)) { //Comprueba contraseña
		System.err.println("Contraseña correcta");
		
		usuario=pro.get();
		
	}else {
		System.err.println("Contraseña incorrecta");

	}
	
	}else {
		
		System.err.println("Este usuario no existe");
		
	}
	
	return usuario;
		
	}

}
