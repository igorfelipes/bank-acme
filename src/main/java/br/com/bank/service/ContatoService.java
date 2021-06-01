/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Contact;

/**
 * @author cbgomes
 *
 */
public interface ContatoService {
	
	void salvar(Contact contato);
	
	List<Contact> list();

}
