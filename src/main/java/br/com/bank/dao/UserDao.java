package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.User;

public interface UserDao {

	public void registerNewUser(User usuario);
	
	public void editUser(User usuario);
	
	public List<User> getAll();
	
	public void deleteUser(Long id);
	
	public boolean isValidUser(String username, String password);
	
	public boolean usernameAlreadyExists(String username);

}
