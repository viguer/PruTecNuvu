package com.nuvu.viguer.tarjertascredito.negocio.repository;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;
import com.nuvu.viguer.tarjertascredito.modelo.TarjetaCredito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface para definir las operaciones de bdd relacionadas con las
 * TarjetasCredito
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, String> {

    /**
     * Definción método busqueda de una tarjeta para un Cliente
     * 
     * @param cliente
     * @param numTarjeta
     * @param estado
     * @return
     */
    @Query("Select c from TarjetaCredito c where c.cliente =:cliente and c.numeroTarjeta =:numTarjeta and c.estado = :estado")
    public TarjetaCredito findNumTarjeta(@Param("cliente") Cliente cliente, @Param("numTarjeta") String numTarjeta,
            @Param("estado") String estado);

}