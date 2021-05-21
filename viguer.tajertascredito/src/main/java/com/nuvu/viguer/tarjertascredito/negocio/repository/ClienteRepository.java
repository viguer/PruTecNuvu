package com.nuvu.viguer.tarjertascredito.negocio.repository;

import java.util.List;

import com.nuvu.viguer.tarjertascredito.modelo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface para definir las operaciones de bdd relacionadas con cliente
 * 
 * @author Vincetl Guerrero
 * @version 1.0
 *
 */

public interface ClienteRepository extends JpaRepository<Cliente, String> {

	/**
	 * Definición de método para buscar un cliente por tipo de indetificación y
	 * numero de identificación
	 * 
	 * @param tipoIdentificacionCli
	 * @param numIdentificacionCli
	 * @param estado
	 * @return
	 */

	@Query("Select c from Cliente c where c.tipoIdentificacionCli = :tipoIdentificacionCli and c.numIdentificacionCli = :numIdentificacionCli and c.estado = :estado")
	public Cliente findByTipoIdeNumIde(@Param("tipoIdentificacionCli") String tipoIdentificacionCli,
			@Param("numIdentificacionCli") String numIdentificacionCli, @Param("estado") String estado);

	/**
	 * Definción de método para listar clientes por estado
	 * 
	 * @param estado
	 * @return
	 */
	@Query("Select c from Cliente c where c.estado = :estado")
	public List<Cliente> listarClientesbyEstado(@Param("estado") String estado);

}