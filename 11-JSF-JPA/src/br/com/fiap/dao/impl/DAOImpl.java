package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DAO;
import br.com.fiap.exceptions.BDException;
import br.com.fiap.exceptions.IdNaoEncontradoException;

public class DAOImpl<T,K> implements DAO<T,K>{

	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager em){
		this.em = em;
		this.classe = 
			(Class<T>) 
			((ParameterizedType) getClass().getGenericSuperclass())
									.getActualTypeArguments()[0];
	}
	
	@Override
	public T registrar(T entity) throws BDException {
		try{
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao persistir");
		}
		return entity;
	}

	@Override
	public void atualizar(T entity) throws BDException {
		try{
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao Atualizar");
		}
	}

	@Override
	public void excluir(K id) throws IdNaoEncontradoException, BDException {
		T entity = buscarPorId(id);
		if (entity == null)
			throw new IdNaoEncontradoException("Id não existe");
		try{
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao remover");
		}
	}

	@Override
	public T buscarPorId(K id) {
		return em.find(classe, id);
	}

}



