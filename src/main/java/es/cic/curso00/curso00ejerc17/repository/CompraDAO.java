package es.cic.curso00.curso00ejerc17.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.cic.curso00.curso00ejerc17.model.Compra;

@Repository
public interface CompraDAO extends JpaRepository<Compra, Long>{

	@Query(value = "SELECT c FROM Compra c  WHERE c.activa = true")
	public Page<Compra> readCompras(Pageable pageable);
}
