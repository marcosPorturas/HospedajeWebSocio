package com.hospedaje.web.socio.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Document(collection="socio")
public class Socio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Field("id_socio")
	private Integer idSocio;
	@Field("nombres")
	private String nombres;
	@Field("apellidos")
	private String apellidos;
	@Field("dni")
	private String dni;
	@Field("telefono")
	private String telefono;
	@Field("creation_date")
	private Date creationDate;
	@Field("update_date")
	private Date updateDate;
	@Field("enabled")
	private boolean enabled;
	
	public Socio() {
		super();
	}
	
	public Integer getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
