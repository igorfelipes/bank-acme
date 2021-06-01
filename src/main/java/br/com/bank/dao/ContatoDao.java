package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Contact;

public interface ContatoDao {

	void salvar(Contact contato);
	
	List<Contact> list();
}
