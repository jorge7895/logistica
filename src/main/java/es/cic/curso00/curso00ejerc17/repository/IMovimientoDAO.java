package es.cic.curso00.curso00ejerc17.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.cic.curso00.curso00ejerc17.model.Movimiento;

@Repository
public interface IMovimientoDAO extends JpaRepository<Movimiento, Long>{

	@Query(value = "SELECT m FROM Movimiento m  WHERE m.activa = true AND m.tipoMovimiento = 1")
	public Page<Movimiento> obtenerVentas(Pageable pageable);
	
	@Query(value = "SELECT m FROM Movimiento m  WHERE m.activa = true AND m.tipoMovimiento = 0")
	public Page<Movimiento> obtenerCompras(Pageable pageable);
}
