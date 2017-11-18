package br.com.sis.domain.dtos;

import io.swagger.annotations.ApiModelProperty;

public class ItemDTO {
	private Long idLista;
	private String nome;
	private Integer version;
	private boolean foiComprado;
	@ApiModelProperty(hidden=true)
	private Long id;	
	
	public ItemDTO() {

	}
	public Long getIdLista() {
		return idLista;
	}
	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public boolean isFoiComprado() {
		return foiComprado;
	}
	public void setFoiComprado(boolean foiComprado) {
		this.foiComprado = foiComprado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
