package es.cic.curso00.curso00ejerc17.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.repository.CompraDAO;
import es.cic.curso00.curso00ejerc17.repository.ProductoDAO;
import es.cic.curso00.curso00ejerc17.util.CompraUtil;

@Service
@Transactional
public class CompraService {
	
	private static final Logger LOGGER = LogManager.getLogger(CompraService.class);

	@Autowired
	private CompraDAO compraDao;
	
	@Autowired
	private ProductoDAO productoDao;
	
	private CompraUtil compraUtil = new CompraUtil();

	
	public List<Producto> crear(List<Producto> productos){
		
		LOGGER.trace("Accediendo a la creacion de una compra");
		
		compraUtil.actualizarImporteTotal(productos);
		compraUtil.actualizarStrock(productos);
		
		compraDao.save(productos.get(0).getCompra());
		
		return productoDao.saveAll(productos);
	}
}
