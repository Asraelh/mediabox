package mediabox.interfaces;

import mediabox.model.Usuario;

public interface IUsuarioService {

	public String addusuario(String user, String password, String email, String alias, String nombre, String apellidos);

	public Usuario comprobarusuario(String user,String password);


}
