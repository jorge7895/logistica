package es.cic.curso00.curso00ejerc17.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;
import es.cic.curso00.curso00ejerc17.repository.ProductoDAO;
import es.cic.curso00.curso00ejerc17.repository.VentaDAO;
import es.cic.curso00.curso00ejerc17.util.VentaUtil;

@Service
@Transactional
public class VentaService {

	private static final Logger LOGGER = LogManager.getLogger(VentaService.class);

	@Autowired
	private VentaDAO ventaDao;
	
	@Autowired
	private ProductoDAO productoDao;
	
	private VentaUtil ventaUtil = new VentaUtil();
	
	
	public Venta crear(List<Producto> productos){
		
		LOGGER.trace("Accediendo a la creacion de una venta");
		
		ventaUtil.comprobarStock(productos);
		ventaUtil.actualizarImporteTotal(productos);
		ventaUtil.actualizarStrock(productos);
		
		Venta venta = productos.get(0).getVenta();
		
		productoDao.saveAll(productos);
		
		return ventaDao.save(venta);
	}
	
	public Page<Venta> readVentas(Pageable pageable){
		return ventaDao.readVentas(pageable);
	}
}
