package es.cic.curso00.curso00ejerc17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic.curso00.curso00ejerc17.model.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{

}
