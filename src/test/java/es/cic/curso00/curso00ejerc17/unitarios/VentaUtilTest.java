package es.cic.curso00.curso00ejerc17.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;
import es.cic.curso00.curso00ejerc17.util.TestUtil;
import es.cic.curso00.curso00ejerc17.util.VentaUtil;

class VentaUtilTest {

	private VentaUtil cut;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private Venta venta;
	private TestUtil testUtil;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new VentaUtil();
		testUtil = new TestUtil();
		
		venta = testUtil.getVenta();
		
		producto1 = testUtil.getProducto1();
		producto1.setVenta(venta);
		producto2 = testUtil.getProducto2();
		producto2.setVenta(venta);
		producto3 = testUtil.getProducto3();
		producto3.setVenta(venta);
	}

	@Test
	void actualizarStockVentaTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(40, producto2.getStock());
		
		assertEquals(100, venta.getImporteTotal());
	}

}
