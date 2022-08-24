package es.cic.curso00.curso00ejerc17.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}

}
