package es.cic.curso00.curso00ejerc17.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.util.CompraUtil;
import es.cic.curso00.curso00ejerc17.util.TestUtil;

class CompraUtilTest {
	
	private CompraUtil cut;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private Compra compra;
	private TestUtil testUtil;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new CompraUtil();
		testUtil = new TestUtil();
		
		compra = testUtil.getCompra();
		
		producto1 = testUtil.getProducto1();
		producto1.setCompra(compra);
		producto2 = testUtil.getProducto2();
		producto2.setCompra(compra);
		producto3 = testUtil.getProducto3();
		producto3.setCompra(compra);
	}

	@Test
	void actualizarImporteTotalTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(75, compra.getImporteTotal());
	}
	
	@Test
	void actualizarStockCompraTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(55, producto1.getStock());
	}
	


}
