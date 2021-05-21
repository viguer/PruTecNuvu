package com.nuvu.viguer.tarjertascredito.negocio.services;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;
import com.nuvu.viguer.tarjertascredito.modelo.TarjetaCredito;
import com.nuvu.viguer.tarjertascredito.negocio.repository.TarjetaCreditoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para implementar las operaciones de bdd relacionadas con las
 * TarjetasCredito
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
@Service
@Transactional(readOnly = true)
public class TarjetaCreditoService {

	private final TarjetaCreditoRepository tarjetaCreditoRepository;

	public TarjetaCreditoService(TarjetaCreditoRepository tarjetaCreditoRepository) {
		this.tarjetaCreditoRepository = tarjetaCreditoRepository;
	}

	/**
	 * Método para realizar la operación de guardar una Tarjeta
	 * 
	 * @param tarjetaCredito
	 * @return
	 */
	@Transactional
	public TarjetaCredito create(TarjetaCredito tarjetaCredito) {
		return this.tarjetaCreditoRepository.save(tarjetaCredito);
	}

	/**
	 * Método para realizar la operación de actualizar informacion de una Tarjeta
	 * 
	 * @param tarjetaCredito
	 * @return
	 */
	@Transactional
	public TarjetaCredito update(TarjetaCredito tarjetaCredito) {
		return this.tarjetaCreditoRepository.save(tarjetaCredito);
	}

	/**
	 * Método busqueda de una tarjeta para un Cliente
	 * 
	 * @param cliente
	 * @param numTarjeta
	 * @param estado
	 * @return
	 */
	public TarjetaCredito findNumTarjeta(Cliente cliente, String numTarjeta, String estado) {
		return this.tarjetaCreditoRepository.findNumTarjeta(cliente, numTarjeta, estado);
	}

}
