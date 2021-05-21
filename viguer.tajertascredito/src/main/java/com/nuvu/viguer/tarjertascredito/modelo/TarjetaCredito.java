package com.nuvu.viguer.tarjertascredito.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Autor Vincetl Guerrero
 * @version 1.0
 */

@Entity
@Table(name = "tarejtascredito")
public class TarjetaCredito {

    @Id
    private String numeroTarjeta;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    private Date fechaModifcacion;
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    private int codigoVerificacion;
    private int contraseña;
    private String franquicia;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "idCli")
    private Cliente cliente;

    public String getFranquicia() {
        return franquicia;
    }

    public Date getFechaModifcacion() {
        return fechaModifcacion;
    }

    /*
    */

    public void setFechaModifcacion(Date fechaModifcacion) {
        this.fechaModifcacion = fechaModifcacion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(int codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

}
