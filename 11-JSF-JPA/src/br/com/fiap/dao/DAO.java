package br.com.fiap.dao;

import br.com.fiap.exceptions.BDException;
import br.com.fiap.exceptions.IdNaoEncontradoException;

public interface DAO<T,K> {

	T registrar(T entity) throws BDException;
	void atualizar(T entity) throws BDException;
	void excluir(K id) 
		throws IdNaoEncontradoException, BDException;
	T buscarPorId(K id);
	
}