package es.cic.curso00.curso00ejerc17.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.repository.ProductoDAO;

@Service
@Transactional
public class ProductoService{
	
	private static final Logger LOGGER = LogManager.getLogger(ProductoService.class);
	
	@Autowired
	private ProductoDAO productoDao;
	
	public Page<Producto> readProductos(Pageable pageable){
		
		LOGGER.trace("Accediendo a la lectura de productos disponibles");
		
		return productoDao.readProductos(pageable);
	}
	
	public Optional<Producto> realizarInventario (long productoId, long stock){
		
		productoDao.actualizarStock(productoId, stock);
		
		return productoDao.findById(productoId);
	
	}
	
	public Producto buscarProducto (String nombre){
				
		return productoDao.findByNombre(nombre);
	
	}
	
	public Producto crearProducto(Producto producto) {
		
		return productoDao.save(producto);
	}
}
