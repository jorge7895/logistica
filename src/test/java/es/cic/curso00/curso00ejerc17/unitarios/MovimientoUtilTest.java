package es.cic.curso00.curso00ejerc17.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.util.MovimientoUtil;
import es.cic.curso00.curso00ejerc17.util.TestUtil;
import es.cic.curso00.curso00ejerc17.util.TipoMovimiento;

class MovimientoUtilTest {
	
	private MovimientoUtil cut;
	private Movimiento movimiento;
	private TestUtil testUtil;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new MovimientoUtil();
		testUtil = new TestUtil();
		
		movimiento = testUtil.getMovimiento();
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(testUtil.getProducto1());
		listaProductos.add(testUtil.getProducto2());
		listaProductos.add(testUtil.getProducto3());
		
		movimiento.setProductos(listaProductos);
	}

	@Test
	void actualizarImporteTotalTest() {
		
		cut.actualizarImporteTotal(movimiento);
		cut.actualizarStrock(movimiento.getProductos(), TipoMovimiento.COMPRA);
		
		
		assertEquals(100, movimiento.getImporteTotal());
	}
	
	@Test
	void actualizarStockCompraTest() {
		
		cut.actualizarImporteTotal(movimiento);
		cut.actualizarStrock(movimiento.getProductos(), TipoMovimiento.COMPRA);
		
		assertEquals(55, movimiento.getProductos().get(0).getStock());
	}
}
