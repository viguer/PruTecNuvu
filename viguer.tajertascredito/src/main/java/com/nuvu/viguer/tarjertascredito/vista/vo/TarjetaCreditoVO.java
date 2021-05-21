package com.nuvu.viguer.tarjertascredito.vista.vo;

import java.util.Date;

/**
 * Pojo de TarjetaCredito para interactual con el cliente Web
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
public class TarjetaCreditoVO {

    private String numeroTarjeta;
    private Date fechaCreacion;
    private Date fechaModifcacion;
    private Date fechaVencimiento;
    private int codigoVerificacion;
    private int contraseña;
    private String franquicia;
    private String estado;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Date getFechaModifcacion() {
        return fechaModifcacion;
    }

    public void setFechaModifcacion(Date fechaModifcacion) {
        this.fechaModifcacion = fechaModifcacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public int getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(int codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

}
