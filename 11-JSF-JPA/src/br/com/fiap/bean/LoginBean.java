package br.com.fiap.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String usuario;
	
	private String senha;
	
	public String logar(){
		if (usuario.equals("fiap") && senha.equals("2015")){
			return "lista-time";
		}else{
			FacesMessage msg = new FacesMessage("Usuário ou senha inválidos");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
