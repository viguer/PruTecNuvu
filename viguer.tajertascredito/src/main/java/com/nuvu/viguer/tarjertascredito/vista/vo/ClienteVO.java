package com.nuvu.viguer.tarjertascredito.vista.vo;

import java.util.Date;

/**
 * Pojo de cliente para interactual con el cliente Web
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
public class ClienteVO {

	private String nombres;
	private String apellidos;
	private String tipoIdentificacionCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	private Date fechaCreacion;
	private Date fechaModificacion;

	public String getEmailCli() {
		return emailCli;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTipoIdentificacionCli() {
		return tipoIdentificacionCli;
	}

	public void setTipoIdentificacionCli(String tipoIdentificacionCli) {
		this.tipoIdentificacionCli = tipoIdentificacionCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public String getTelefonoCli() {
		return telefonoCli;
	}

	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getIdentificacionCli() {
		return identificacionCli;
	}

	public void setIdentificacionCli(String identificacionCli) {
		this.identificacionCli = identificacionCli;
	}
}
