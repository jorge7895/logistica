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

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;
import es.cic.curso00.curso00ejerc17.service.VentaService;

@RestController
@RequestMapping(path = "/api/v1/venta")
public class VentaController {
	
	private static final Logger LOGGER = LogManager.getLogger(VentaController.class);

	@Autowired
	private VentaService ventaService;
	
	@PostMapping
	public ResponseEntity<Venta> crearVenta(@Validated @RequestBody List<Producto> productos) {

		LOGGER.trace("Creando una venta nueva cantidad: {}", productos.size());
		
		Venta ventaCreada = this.ventaService.crear(productos);

		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(ventaCreada);
	}
	
	@GetMapping("/totales")
	public ResponseEntity<Page<Venta>> obtenerVentas(Pageable pageable) {

		LOGGER.trace("Recuperando los datos de las ventas");

		Page<Venta> resultados = ventaService.readVentas(pageable);

		return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(resultados);

	}
}
