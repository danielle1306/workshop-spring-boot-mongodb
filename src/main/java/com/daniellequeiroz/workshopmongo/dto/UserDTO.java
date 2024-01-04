package com.daniellequeiroz.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.daniellequeiroz.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {}

	//construtor sobrecarregado que vai buscar os dados lá do User (para instanciar a partir do objeto Entity)
	public UserDTO(User obj) {
		id = obj.getId();//esses dados estão sendo buscado do User
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
