package es.cic.curso00.curso00ejerc17;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.service.CompraService;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class CompraController {

	private Logger logger = LogManager.getLogger(CompraController.class);

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<List<Producto>> crearVenta(@Validated @RequestBody List<Producto> productos) {

		logger.trace("Creando una venta nueva cantidad: {}", productos.size());
		
		this.compraService.crear(productos);

		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(productos);
	}
}
