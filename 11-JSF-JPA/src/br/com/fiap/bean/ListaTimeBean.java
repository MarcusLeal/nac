package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class ListaTimeBean {

	private List<Time> times;
	
	private TimeDAO timeDao;
	
	private String nome;
	
	@PostConstruct
	private void init(){
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		timeDao = new TimeDAOImpl(em);
		times = timeDao.list();
	}
	
	public void buscar(){
		times = timeDao.searchByName(nome);
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
