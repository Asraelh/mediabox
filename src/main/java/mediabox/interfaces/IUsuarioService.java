package mediabox.interfaces;

import mediabox.model.Usuario;

public interface IUsuarioService {

	public String addusuario(String user, String password, String email, String alias, String nombre, String apellidos);

	public Usuario comprobarusuario(String user,String password);
	
	public Usuario buscarUsuarioPorId(String user);
	
	public String actualizarUsuario(String user, String password, String email);
	
	public boolean comprobarEmail(String email);


}
