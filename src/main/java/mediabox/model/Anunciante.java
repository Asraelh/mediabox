package mediabox.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table
public class Anunciante implements Serializable {

	@Id
	 private String username;
	 private String password;
	 private String email;
	 private Integer phone;
	 private String type;
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	 
	 

}
