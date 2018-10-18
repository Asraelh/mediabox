package mediabox.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table
public class Prueba implements Serializable {

	@Id
	 private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	
	

}
