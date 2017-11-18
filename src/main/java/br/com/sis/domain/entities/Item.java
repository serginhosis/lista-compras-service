package br.com.sis.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Item implements BaseEntities{
	
	private static final long serialVersionUID = 5964031555135352149L;

	private String nome;
	
	private boolean foiComprado;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Version
	private Integer version;
	
	
	@ApiModelProperty(hidden=true)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_lista_compras")
	private ListaCompras listaCompras;
	
	public Item() {	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
		
	public ListaCompras getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ListaCompras listaCompras) {
		this.listaCompras = listaCompras;
	}

	@Override
	public String toString() {
		return "Item [id=" + getId() + ", nome=" + nome + ", foiComprado=" + foiComprado + ", version=" + getVersion()+ "]";
	}
	
	

}
