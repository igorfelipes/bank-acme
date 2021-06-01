package br.com.bank.service;

import java.util.List;

import br.com.bank.model.User;

public interface UserService {
	
	public void registerUser(User usuario);
	
	public void editUser(User usuario);
	
	public void deleteUser(Long id);
	
	public List<User> getAll();
	
	public boolean isValidUser(String email, String senha);
	
	public boolean usernameAlreadyExists(String username);

}
