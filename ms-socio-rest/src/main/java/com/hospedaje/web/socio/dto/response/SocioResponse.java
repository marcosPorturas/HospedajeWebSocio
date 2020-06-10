package com.hospedaje.web.socio.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class SocioResponse implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer idSocio;
	private String nombres;
	private String apellidos;
	private String dni;
	private String telefono;
	private String creationDate;
	private boolean enabled;
	
	public SocioResponse () {
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
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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
