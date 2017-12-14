package model;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import DAO.GenericDao;
import annotation.Column;
import util.Return;

/**CLasse Textos**/
/*Class that represent the texts*/

@annotation.Table(name="textos", useCase="ManterTexto")
public class Texts extends Model<Integer>{
	
	@Column(name="id", pk=true, obrigatory=false, nameOnView="")
	private Integer id;
	
	@Column(name="data", obrigatory=true, nameOnView="Data", searchable=true)
	private Date date;
	
	@Column(name="autor", obrigatory=true, nameOnView="Autor")
	private String author;
	
	@Column(name="titulo", obrigatory=true, nameOnView="Título")
	private String title;
	
	@Column(name="meio_fisico", obrigatory=false, nameOnView="Meio físico")
	private boolean physical;
	
	@Column(name="meio_digital", obrigatory=false, nameOnView="Meio digital")
	private boolean digital;
	
	@Column(name="tipo", obrigatory=true, nameOnView="Tipo")
	private String kind;
	
	@Column(name="info_privada", obrigatory=false, nameOnView="Conteúdo privado")
	private String privateContent;
	
	@Column(name="conteudo", obrigatory=true, nameOnView="Conteúdo")
	private String content;
	
	@Column(name="classificacao_id", fk=true, nameOnView="Classificação")
	private Classification classification;
	
	public Texts(){
		this.classification = new Classification();
	}

	/*Attach Values*/
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getPhysical() {
		return physical;
	}

	public void setPhysical(boolean physical) {
		this.physical = physical;
	}

	public boolean getDigital() {
		return digital;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getPrivateContent() {
		return privateContent;
	}

	public void setPrivateContent(String privateContent) {
		this.privateContent = privateContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@Override
	public Object getPk(){
		return (Object) id;
	}

	@Override
	public void setPk(Object pk) {
		this.id = (Integer) pk;
		
	}

	
}
