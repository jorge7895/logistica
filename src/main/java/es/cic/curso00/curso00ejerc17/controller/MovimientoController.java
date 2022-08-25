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

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.service.MovimientoService;

@RestController
@RequestMapping(path = "/api/v1/movimiento")
public class MovimientoController {
	
	private static final Logger LOGGER = LogManager.getLogger(MovimientoController.class);

	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping
	public ResponseEntity<Movimiento> crearCompra(@Validated @RequestBody List<Producto> productos) {

		LOGGER.trace("Creando una compra nueva cantidad: {}", productos.size());
		
		Movimiento compraCreada = movimientoService.crearMovimiento(productos);

		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(compraCreada);
	}
	
	@GetMapping("/compra")
	public ResponseEntity<Page<Movimiento>> obtenerComprasTotales(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Page<Movimiento> resultados = movimientoService.obtenerCompras(pageable);

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}
}
