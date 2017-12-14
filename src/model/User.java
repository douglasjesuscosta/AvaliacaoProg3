package model;

import annotation.Column;
import annotation.Table;

@Table(name="autentificacao", useCase="ManterUsuario")
public class User extends Model<String>{
	
	private static final long serialVersionUID = 1L;
			
	@Column(autenticable=true, name="usuario", nameOnView = "Usuario")
	private String nome;
	@Column(autenticable=true, name="senha", nameOnView = "Senha")
	private String password;

	
	public User(String nome, String password){
		setNome(nome);
		setPassword(password);
	}
	
	public User(){
		
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getPassword(){
		return password;
	}

	@Override
	public Object getPk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPk(Object pk) {
		// TODO Auto-generated method stub
		
	}
}
