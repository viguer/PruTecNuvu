package com.nuvu.viguer.tarjertascredito.negocio.services;

import java.util.List;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;
import com.nuvu.viguer.tarjertascredito.negocio.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para implementar las operaciones de bdd relacionadas con cliente
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Método para realizar la operación de guardar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para realizar la operación de actualizar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para realizar la operación de eliminar un cliente
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	/**
	 * Método para buscar un cliente por tipo de indetificación y numero de
	 * identificación
	 * 
	 * @param tipoIdentificacionCli
	 * @param numIdentificacionCli
	 * @param estado
	 * @return
	 */
	public Cliente findTipoIdeNumIde(String tipoIdentificacionCli, String numIdentificacionCli, String estado) {
		return this.clienteRepository.findByTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, estado);
	}

	/**
	 * Método para inactivar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente inactivarCliente(Cliente cliente) {
		cliente.setEstado("I");
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para listar clientes por estado
	 * 
	 * @param estado
	 * @return
	 */
	public List<Cliente> listarClientesbyEstado(String estado) {
		return this.clienteRepository.listarClientesbyEstado(estado);
	}

}
