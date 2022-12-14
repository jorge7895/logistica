package es.cic.curso00.curso00ejerc17.controller;

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
import es.cic.curso00.curso00ejerc17.service.MovimientoService;

@RestController
@RequestMapping(path = "/api/v1/movimiento")
public class MovimientoController {
	
	private static final Logger LOGGER = LogManager.getLogger(MovimientoController.class);

	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping
	public ResponseEntity<Movimiento> crearMovimiento(@Validated @RequestBody Movimiento movimiento) {

		LOGGER.trace("Creando un movimiento nuevo: {}", movimiento.toString());
		
		Movimiento movimientoCreado = movimientoService.crearMovimiento(movimiento);

		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(movimientoCreado);
	}
	
	@GetMapping("/compra")
	public ResponseEntity<Page<Movimiento>> obtenerComprasTotales(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las compras");

		Page<Movimiento> resultados = movimientoService.obtenerCompras(pageable);

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}
	
	@GetMapping("/venta")
	public ResponseEntity<Page<Movimiento>> obtenerVentasTotales(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Page<Movimiento> resultados = movimientoService.obtenerVentas(pageable);

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}
}
