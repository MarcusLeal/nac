package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.entity.Time;

public class TimeDAOImpl extends DAOImpl<Time, Integer> implements TimeDAO{

	public TimeDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Time> list() {
		TypedQuery<Time> query = em.createQuery("from Time",Time.class);
		return query.getResultList();
	}

	@Override
	public List<Time> searchByName(String nome) {
		return em.createQuery(
			"from Time t where upper(t.nome) like upper(:n)",Time.class)
			.setParameter("n", "%"+nome+"%").getResultList();
	}

}



