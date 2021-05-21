package com.nuvu.viguer.tarjertascredito.vista.resources;

import java.util.Date;
import java.util.List;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;
import com.nuvu.viguer.tarjertascredito.negocio.services.ClienteService;
import com.nuvu.viguer.tarjertascredito.vista.vo.ClienteVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que representa el servicio web de cliente
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	/**
	 * POST Crear cliente
	 * 
	 * @param clienteVo
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findTipoIdeNumIde(clienteVo.getTipoIdentificacionCli(),
				clienteVo.getIdentificacionCli(), "A");

		if (cliente != null && cliente.getEstado().equals("A")) {
			return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.BAD_REQUEST);
		} else {
			cliente = this.clienteService.findTipoIdeNumIde(clienteVo.getTipoIdentificacionCli(),
					clienteVo.getIdentificacionCli(), "I");

			if (cliente != null && cliente.getEstado().equals("I")) {

				cliente.setNombresClie(clienteVo.getNombres());
				cliente.setApellidosCli(clienteVo.getApellidos());
				cliente.setDireccionCli(clienteVo.getDireccionCli());
				cliente.setTelefonoCli(clienteVo.getTelefonoCli());
				cliente.setEmailCli(clienteVo.getEmailCli());
				cliente.setFechaModificacion(new Date());
				cliente.setEstado("A");
				return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.CREATED);

			} else {
				System.out.println("cliente no existe");
				cliente = new Cliente();
				cliente.setTipoIdentificacionCli(clienteVo.getTipoIdentificacionCli());
				cliente.setNumIdentificacionCli(clienteVo.getIdentificacionCli());
				cliente.setNombresClie(clienteVo.getNombres());
				cliente.setApellidosCli(clienteVo.getApellidos());
				cliente.setDireccionCli(clienteVo.getDireccionCli());
				cliente.setTelefonoCli(clienteVo.getTelefonoCli());
				cliente.setEmailCli(clienteVo.getEmailCli());
				cliente.setFechaCreacion(new Date());
				cliente.setFechaModificacion(new Date());
				cliente.setEstado("A");
				return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
			}
		}

	}

	/**
	 * PUT ActualizarCliente
	 * 
	 * @param tipoIdentificacionCli
	 * @param numIdentificacionCli
	 * @param clienteVo
	 * @return
	 */
	@PutMapping("/{tipoIdentificacionCli}/{numIdentificacionCli}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("tipoIdentificacionCli") String tipoIdentificacionCli,
			@PathVariable("numIdentificacionCli") String numIdentificacionCli, @RequestBody ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, "A");

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {

			cliente.setNombresClie(clienteVo.getNombres());
			cliente.setApellidosCli(clienteVo.getApellidos());
			cliente.setDireccionCli(clienteVo.getDireccionCli());
			cliente.setEmailCli(clienteVo.getEmailCli());
			cliente.setFechaModificacion(new Date());
			cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		}
		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
	}

	/**
	 * DELETE Inactivar un cliente
	 * 
	 * @param tipoIdentificacionCli
	 * @param numIdentificacionCli
	 * @param clienteVo
	 * @return
	 */
	@DeleteMapping("/{tipoIdentificacionCli}/{numIdentificacionCli}")
	public ResponseEntity<Cliente> removeCliente(@PathVariable("tipoIdentificacionCli") String tipoIdentificacionCli,
			@PathVariable("numIdentificacionCli") String numIdentificacionCli, @RequestBody ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, "A");

		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			this.clienteService.inactivarCliente(cliente);
			return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
		}

	}

	/**
	 * GET Obtener lista de los clientes activos
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> ListarClientesActivos() {
		return ResponseEntity.ok(this.clienteService.listarClientesbyEstado("A"));
	}

	/**
	 * GET Obtener cliente por tipo de identificación y número de identificación
	 * 
	 * @return
	 */
	@GetMapping("/{tipoIdentificacionCli}/{numIdentificacionCli}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("tipoIdentificacionCli") String tipoIdentificacionCli,
			@PathVariable("numIdentificacionCli") String numIdentificacionCli) {

		return ResponseEntity
				.ok(this.clienteService.findTipoIdeNumIde(tipoIdentificacionCli, numIdentificacionCli, "A"));
	}

}