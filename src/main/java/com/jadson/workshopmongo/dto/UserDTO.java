package com.jadson.workshopmongo.dto;

import java.io.Serializable;

import com.jadson.workshopmongo.domain.User;

public class UserDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private String id;	
	private String name;
	private String email;
	
	public UserDTO() {		
	}
	
	public UserDTO(User user) {		
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}
	
	

}
