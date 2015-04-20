package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactorySingleton {

	//Construtor privado -> ninguem consegue instanciar
	private EMFactorySingleton(){ }
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			factory = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return factory;
	}
	
}
