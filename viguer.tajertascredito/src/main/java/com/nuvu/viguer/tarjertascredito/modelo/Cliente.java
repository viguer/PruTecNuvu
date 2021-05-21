package com.nuvu.viguer.tarjertascredito.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Autor Vincetl Guerrero
 * @version 1.0
 */

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String tipoIdentificacionCli;
	private String numIdentificacionCli;
	private String nombresClie;
	private String apellidosCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@Temporal(TemporalType.DATE)
	private Date fechaModificacion;
	private String estado;
	@OneToMany(mappedBy = "cliente")
	private Set<TarjetaCredito> tarjetaCredito;

	public String getEmailCli() {
		return emailCli;
	}

	public String getNumIdentificacionCli() {
		return numIdentificacionCli;
	}

	public void setNumIdentificacionCli(String numIdentificacionCli) {
		this.numIdentificacionCli = numIdentificacionCli;
	}

	public String getTipoIdentificacionCli() {
		return tipoIdentificacionCli;
	}

	public void setTipoIdentificacionCli(String tipoIdentificacionCli) {
		this.tipoIdentificacionCli = tipoIdentificacionCli;
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

	public String getApellidosCli() {
		return apellidosCli;
	}

	public void setApellidosCli(String apellidosCli) {
		this.apellidosCli = apellidosCli;
	}

	public String getNombresClie() {
		return nombresClie;
	}

	public void setNombresClie(String nombresClie) {
		this.nombresClie = nombresClie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getTelefonoCli() {
		return telefonoCli;
	}

	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

}