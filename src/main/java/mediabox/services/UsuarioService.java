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
		boolean check=usuariosRepository.checkUser(user);
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
	}

	@Override
	public Usuario comprobarusuario(String user, String password) {
		// TODO Auto-generated method stub
		
		System.err.println("Entra en comprobarusuario");
		
		boolean check=usuariosRepository.checkLogin(user, password);
		System.err.println("Comprueba si el usuario esta registrado");
		
		if(check) {
		System.err.println("Antes del inicio");
		Usuario usuario=new Usuario();
		usuario.setIdusuario(user);
		usuario.setPassword(password);
		System.err.println("Despues del inicio");
		return usuario;
		}else {
			
			System.err.println("Este usuario no existe");
			return null;
		}
		
	}

}
