package es.cic.curso00.curso00ejerc17.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.service.CompraService;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class CompraController {

	private static final Logger LOGGER = LogManager.getLogger(CompraController.class);

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<Compra> crearCompra(@Validated @RequestBody List<Producto> productos) {

		LOGGER.trace("Creando una compra nueva cantidad: {}", productos.size());
		
		Compra compraCreada = this.compraService.crear(productos);

		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(compraCreada);
	}
	
	@GetMapping("/totales")
	public ResponseEntity<Page<Compra>> obtenerCompras(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Page<Compra> resultados = compraService.readCompras(pageable);

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}
}
