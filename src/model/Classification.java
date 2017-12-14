package model;

import java.util.ArrayList;
import java.util.HashMap;

import annotation.Column;
import util.Return;

/**Class CLassification**/
/*This class represents the classification of the text*/

@annotation.Table(name="classificacao", useCase="ManterClassificacao")
public class Classification extends Model<Integer> {
	
	@Column(name="id", pk=true, obrigatory=false, nameOnView="aaaa")
	private Integer id;
	
	@Column(name="nome", obrigatory=true, nameOnView="Nome")
	private String name;
	
	@Column(name="descricao", obrigatory=true, nameOnView="Descrição")
	private String description;
	
	@Column(name="referenciacao", obrigatory=true, nameOnView="Referenciação")
	private String reference;
	
	/**Attach attributes**/
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public void setName(String nome){
		this.name = nome;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setReference(String reference){
		this.reference = reference;
	}
	
	/**Get Attributes**/
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getReference(){
		return reference;
	}

	public String getTable() {
		return "classificacao";
	}
	
	public Object getPk(){
		return (Object) id;
	}

	public String getPkName() {
		return "id";
	}

	@Override
	public void setPk(Object pk) {
		this.id = (Integer) pk;
		
	}
}
