package es.cic.curso00.curso00ejerc17.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.service.ProductoService;

@RestController
@RequestMapping(path = "/api/v1/producto")
public class ProductoController {
	
	private static final Logger LOGGER = LogManager.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/totales")
	public ResponseEntity<Page<Producto>> obtenerProductos(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Page<Producto> resultados = productoService.readProductos(pageable);

		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(resultados);

	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Producto> buscarProducto(@RequestParam String nombre) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Producto producto = productoService.buscarProducto(nombre);

		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(producto);

	}

	@PutMapping("/inventario")
	public ResponseEntity<Optional<Producto>> realizarInventario(@Validated @RequestBody Producto producto) {

		LOGGER.trace("Realizando un ajuste del stock des producto: {}", producto.toString());
		
		Optional<Producto> nuevoProducto = this.productoService.realizarInventario(producto);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(nuevoProducto);
	}
}
