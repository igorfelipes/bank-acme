package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.UserDaoImpl;
import br.com.bank.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDaoImpl dao;
	
	public UserServiceImpl() {
		this.dao = new UserDaoImpl();
	}
	
	public void registerUser(User usuario) {
		this.dao.registerNewUser(usuario);	
	}

	public void editUser(User usuario) {
		this.dao.editUser(usuario);
	}
	
	public void deleteUser(Long id) {
		this.dao.deleteUser(id);
		
	}

	public List<User> getAll() {
		return this.dao.getAll();
	}

	public boolean isValidUser(String email, String senha) {
		return this.dao.isValidUser(email, senha);
	}

	public boolean usernameAlreadyExists(String username) {
		return this.dao.usernameAlreadyExists(username);
	}

}
