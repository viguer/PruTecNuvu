package com.nuvu.viguer.tarjertascredito.vista.vo;

/**
 * Pojo de Usuario para autenticación del cliente Web
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
public class UsuarioVO {

    private String usuario;
    private String token;

    public String getUsuario() {
        return usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
