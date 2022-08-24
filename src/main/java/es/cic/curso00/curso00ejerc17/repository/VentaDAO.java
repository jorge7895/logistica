package es.cic.curso00.curso00ejerc17.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.cic.curso00.curso00ejerc17.model.Venta;

@Repository
public interface VentaDAO extends JpaRepository<Venta, Long>{

	@Query(value = "SELECT v FROM Venta v  WHERE v.activa = true")
	public Page<Venta> readVentas(Pageable pageable);
}
