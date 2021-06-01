package br.com.bank.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.bank.model.User;
import br.com.bank.util.JPAUtil;

public class UserDaoImpl implements UserDao{
	
	@Override
	public void registerNewUser(User user) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	

	@Override
	public void editUser(User user) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		User userToEdit = entityManager.find(User.class, user.getId());
		userToEdit.setUsername(user.getUsername());
		userToEdit.setPassword(user.getPassword());
		
		try {
			
			entityManager.persist(userToEdit);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch(NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
	}


	@Override
	public List<User> getAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Query query = entityManager.createQuery("SELECT u FROM User u");
			List<User> usuarios = query.getResultList();
					
			return usuarios;
			
		} catch(NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return Arrays.asList();
	}

	@Override
	public void deleteUser(Long id) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		User usuarioToRemove = entityManager.find(User.class, id);
		
		entityManager.getTransaction().begin();
		entityManager.remove(usuarioToRemove);
		entityManager.getTransaction().commit();
			
	}
	
	@Override
	public boolean isValidUser(String user, String password) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
		
			Query query = entityManager.createQuery("SELECT u FROM User u where u.username = :user and u.password = :password");
			query.setParameter("user", user);
			query.setParameter("password", password);
			
			User usuarioCredenciais = (User) query.getSingleResult();
		
			return Objects.nonNull(usuarioCredenciais);			
			
		} 
		catch(NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return false;
	}
	
	
	@Override
	public boolean usernameAlreadyExists(String username) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
		
			Query query = entityManager.createQuery("SELECT u FROM User u where u.username = :username");
			query.setParameter("username", username);

			
			User userExists = (User) query.getSingleResult();
		
			return Objects.nonNull(userExists);			
			
		} 
		catch(NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return false;
	}

}
