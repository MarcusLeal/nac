package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Time;
import br.com.fiap.exceptions.BDException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class TimeBean {

	private Time time;
	
	private TimeDAO dao;
	
	@PostConstruct
	private void init(){
		time = new Time();
		time.setDataFundacao(Calendar.getInstance());
		
		//Inicializa o dao
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new TimeDAOImpl(em);
	}
	
	//Clique do botão...
	public void cadastrar(){
		FacesMessage msg;
		try {
			dao.registrar(time);
			msg = new FacesMessage("Time cadastrado!");
		} catch (BDException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
		}
		//Adiciona a mensagem...
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
