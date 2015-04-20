package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Time;

public interface TimeDAO extends DAO<Time,Integer>{

	List<Time> list();
	
	List<Time> searchByName(String nome);
	
}
