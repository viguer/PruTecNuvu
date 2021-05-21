package com.nuvu.viguer.tarjertascredito.vista.resources;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.nuvu.viguer.tarjertascredito.vista.vo.UsuarioVO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Clase que representa el servicio web para la autenticación de un usuario
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
@RestController
public class UsuarioResource {

    /**
     * POST autenticación Usuario web
     * 
     * @param username
     * @param pwd
     * @return
     */
    @PostMapping("usuario")
    public UsuarioVO login(@RequestParam("usuario") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        UsuarioVO usuario = new UsuarioVO();
        usuario.setUsuario(username);
        usuario.setToken(token);
        return usuario;

    }

    /**
     * Método para generar un Token JWT
     * 
     * @param username
     * @return
     */
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
