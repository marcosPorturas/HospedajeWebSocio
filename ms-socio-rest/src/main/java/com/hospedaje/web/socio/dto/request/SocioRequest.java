package com.hospedaje.web.socio.dto.request;

public class SocioRequest {

	private Integer idSocio;
	private String nombres;
	private String apellidos;
	private String dni;
	private String telefono;
	
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
