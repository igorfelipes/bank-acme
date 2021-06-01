/**
 * 
 */
package br.com.bank.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bank.model.Contact;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ContatoDaoImpl implements ContatoDao {

	@Override
	public void salvar(Contact contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {

			entityManager.persist(contato);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public List<Contact> list() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contact c");
		List<Contact> contatos = query.getResultList();
		return contatos;
		
	}

}









