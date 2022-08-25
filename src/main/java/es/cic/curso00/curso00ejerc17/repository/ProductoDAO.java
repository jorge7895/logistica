package es.cic.curso00.curso00ejerc17.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.cic.curso00.curso00ejerc17.model.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{
	
	@Query(value = "SELECT p FROM Producto p  WHERE p.activa = true")
	public Page<Producto> readProductos(Pageable pageable);
	
	@Modifying
	@Query(value = "UPDATE Producto p set p.stock = :stock WHERE p.id = :id")
	public void actualizarStock(long id, long stock);

}
