package com.nuvu.viguer.tarjertascredito.vista.resources;

import java.util.Date;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;
import com.nuvu.viguer.tarjertascredito.modelo.TarjetaCredito;
import com.nuvu.viguer.tarjertascredito.negocio.services.ClienteService;
import com.nuvu.viguer.tarjertascredito.negocio.services.TarjetaCreditoService;
import com.nuvu.viguer.tarjertascredito.vista.vo.TarjetaCreditoVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que representa el servicio web de TarjetaCredito
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/api/tarjetacredito")
public class TarjetaCreditoResource {

    private final ClienteService clienteService;
    private final TarjetaCreditoService tarjetaCreditoService;

    public TarjetaCreditoResource(ClienteService clienteService, TarjetaCreditoService tarjetaCreditoService) {
        this.clienteService = clienteService;
        this.tarjetaCreditoService = tarjetaCreditoService;
    }

    /**
     * POST Crear TarjetaCredito
     * 
     * @param tipoIdentificacionCli
     * @param numIdentificacionCli
     * @param tarjetaCreditoVO
     * @return
     */
    @PostMapping("/{tipoIdentificacionCli}/{numIdentificacionCli}")
    public ResponseEntity<TarjetaCredito> createTarjetaCredito(
            @PathVariable("tipoIdentificacionCli") String tipoIdentificacionCli,
            @PathVariable("numIdentificacionCli") String numIdentificacionCli,
            @RequestBody TarjetaCreditoVO tarjetaCreditoVO) {

        Cliente cliente = this.clienteService.findTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, "A");

        TarjetaCredito tarjetaCredito = new TarjetaCredito();

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tarjetaCredito.setCliente(cliente);
        tarjetaCredito.setCodigoVerificacion(tarjetaCreditoVO.getCodigoVerificacion());
        tarjetaCredito.setContraseña(tarjetaCreditoVO.getContraseña());
        tarjetaCredito.setEstado("A");
        tarjetaCredito.setFechaCreacion(new Date());
        tarjetaCredito.setFechaModifcacion(new Date());
        tarjetaCredito.setFechaVencimiento(new Date());
        tarjetaCredito.setFranquicia(tarjetaCreditoVO.getFranquicia());
        tarjetaCredito.setNumeroTarjeta(tarjetaCreditoVO.getNumeroTarjeta());

        return new ResponseEntity<>(this.tarjetaCreditoService.create(tarjetaCredito), HttpStatus.OK);

    }

    /**
     * PUT Modificar datos TarjetaCredito
     * 
     * @param tipoIdentificacionCli
     * @param numIdentificacionCli
     * @param numTarjeta
     * @param tarjetaCreditoVO
     * @return
     */
    @PutMapping("/{tipoIdentificacionCli}/{numIdentificacionCli}/{numTarjeta}")
    public ResponseEntity<TarjetaCredito> updateCliente(
            @PathVariable("tipoIdentificacionCli") String tipoIdentificacionCli,
            @PathVariable("numIdentificacionCli") String numIdentificacionCli,
            @PathVariable("numTarjeta") String numTarjeta, @RequestBody TarjetaCreditoVO tarjetaCreditoVO) {

        Cliente cliente = this.clienteService.findTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, "A");

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        TarjetaCredito tarjetaCredito = this.tarjetaCreditoService.findNumTarjeta(cliente, numTarjeta, "A");

        tarjetaCredito.setFechaModifcacion(new Date());
        tarjetaCredito.setContraseña(tarjetaCreditoVO.getContraseña());

        return new ResponseEntity<>(this.tarjetaCreditoService.update(tarjetaCredito), HttpStatus.OK);
    }

}
