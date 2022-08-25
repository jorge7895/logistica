package es.cic.curso00.curso00ejerc17.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.repository.IMovimientoDAO;
import es.cic.curso00.curso00ejerc17.repository.ProductoDAO;
import es.cic.curso00.curso00ejerc17.util.MovimientoUtil;

@Service
@Transactional
public class MovimientoService {

	private static final Logger LOGGER = LogManager.getLogger(MovimientoService.class);
	
	@Autowired
	private IMovimientoDAO movimientoDao;
	
	@Autowired
	private ProductoDAO productoDao;
	
	private MovimientoUtil movimientoUtil = new MovimientoUtil();
	
	public Movimiento crearMovimiento(List<Producto> productos){
		
		LOGGER.trace("Accediendo a la creacion de una venta");
		
		movimientoUtil.comprobarStock(productos);
		movimientoUtil.actualizarImporteTotal(productos);
		movimientoUtil.actualizarStrock(productos);
		
		Movimiento movimiento = productos.get(0).getMovimiento();
		
		productoDao.saveAll(productos);
		
		return movimientoDao.save(movimiento);
	}
	
	public Page<Movimiento> obtenerVentas(Pageable pageable){
		return movimientoDao.obtenerVentas(pageable);
	}
	
	public Page<Movimiento> obtenerCompras(Pageable pageable){
		return movimientoDao.obtenerCompras(pageable);
	}
}
