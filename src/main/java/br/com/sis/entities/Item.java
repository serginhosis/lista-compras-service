package br.com.sis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Item implements Serializable {
	
	private static final long serialVersionUID = 5964031555135352149L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
		
	private String nome;
	
	private boolean foiComprado;
	
	@Version
	private Integer version; 
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isFoiComprado() {
		return foiComprado;
	}
	public void setFoiComprado(boolean foiComprado) {
		this.foiComprado = foiComprado;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", foiComprado=" + foiComprado + ", version=" + version + "]";
	}
	
	

}
