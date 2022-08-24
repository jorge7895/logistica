package es.cic.curso00.curso00ejerc17.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;
import es.cic.curso00.curso00ejerc17.util.VentaUtil;

class VentaUtilTest {

	private VentaUtil cut;
	private Producto producto;
	private Producto producto2;
	private Venta venta;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new VentaUtil();
		
		venta = new Venta();
		venta.setActiva(true);
		venta.setFechaVenta(LocalDate.of(2022, Month.OCTOBER, 8));
		
		producto = new Producto();
		producto.setActiva(true);
		producto.setCantidadComprada(5);
		producto.setVenta(venta);
		producto.setMarca("MiCasa");
		producto.setNombre("Balón de fútbol");
		producto.setPrecioCompra(2.0f);
		producto.setPrecioVenta(5.0f);
		producto.setStock(100);
		
		producto2 = new Producto();
		producto2.setActiva(true);
		producto2.setCantidadComprada(10);
		producto2.setVenta(venta);
		producto2.setMarca("MiCasa");
		producto2.setNombre("Balón de fútbol");
		producto2.setPrecioCompra(3.0f);
		producto2.setPrecioVenta(5.0f);
		producto2.setStock(100);
	}

	@Test
	void actualizarStockVentaTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto2);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(90, producto2.getStock());
	}

}
