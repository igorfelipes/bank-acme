/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ContatoDaoImpl;
import br.com.bank.model.Contact;

/**
 * @author Rodrigo Undried
 *
 */
public class ContatoServiceImpl implements ContatoService {
	
	private ContatoDaoImpl dao;
	
	public ContatoServiceImpl() {
		this.dao = new ContatoDaoImpl();
	}

	@Override
	public void salvar(Contact contato) {
		this.dao.salvar(contato);
	}

	@Override
	public List<Contact> list() {
		return this.dao.list();
	}

}
