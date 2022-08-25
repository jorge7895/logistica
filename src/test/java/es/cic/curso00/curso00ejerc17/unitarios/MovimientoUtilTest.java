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
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private Movimiento movimiento;
	private TestUtil testUtil;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new MovimientoUtil();
		testUtil = new TestUtil();
		
		movimiento = testUtil.getMovimiento();
		
		producto1 = testUtil.getProducto1();
		producto1.setMovimiento(movimiento);
		producto2 = testUtil.getProducto2();
		producto2.setMovimiento(movimiento);
		producto3 = testUtil.getProducto3();
		producto3.setMovimiento(movimiento);
	}

	@Test
	void actualizarImporteTotalTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos, TipoMovimiento.COMPRA);
		
		
		assertEquals(100, movimiento.getImporteTotal());
	}
	
	@Test
	void actualizarStockCompraTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos, TipoMovimiento.COMPRA);
		
		assertEquals(55, producto1.getStock());
	}
	


}
