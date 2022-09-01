package es.cic.curso00.curso00ejerc17.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.repository.IMovimientoDAO;
import es.cic.curso00.curso00ejerc17.util.MovimientoUtil;
import es.cic.curso00.curso00ejerc17.util.TipoMovimiento;

@Service
@Transactional
public class MovimientoService {

	private static final Logger LOGGER = LogManager.getLogger(MovimientoService.class);

	@Autowired
	private IMovimientoDAO movimientoDao;

	private MovimientoUtil movimientoUtil = new MovimientoUtil();

	public Movimiento crearMovimiento(Movimiento movimiento) {

		LOGGER.trace("Accediendo a la creacion de una venta");

		if (movimiento.getTipoMovimiento().equals(TipoMovimiento.VENTA)) {

			movimientoUtil.comprobarStock(movimiento.getProductos());
			movimientoUtil.actualizarImporteTotal(movimiento);
			movimientoUtil.actualizarStrock(movimiento.getProductos(), movimiento.getTipoMovimiento());

		} else if (movimiento.getTipoMovimiento().equals(TipoMovimiento.COMPRA)) {

			movimientoUtil.actualizarImporteTotal(movimiento);
			movimientoUtil.actualizarStrock(movimiento.getProductos(), movimiento.getTipoMovimiento());
		}

		return movimientoDao.save(movimiento);
	}

	public Page<Movimiento> obtenerVentas(Pageable pageable) {
		return movimientoDao.obtenerVentas(pageable);
	}

	public Page<Movimiento> obtenerCompras(Pageable pageable) {
		return movimientoDao.obtenerCompras(pageable);
	}
}
