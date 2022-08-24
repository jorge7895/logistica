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
import es.cic.curso00.curso00ejerc17.util.CompraUtil;

class CompraUtilTest {
	
	private CompraUtil cut;
	private Producto producto;
	private Producto producto2;
	private Compra compra;

	@BeforeEach
	void setUp() throws Exception {
		
		cut= new CompraUtil();
		
		compra = new Compra();
		compra.setActiva(true);
		compra.setFechaCompra(LocalDate.of(2022, Month.OCTOBER, 8));
		
		producto = new Producto();
		producto.setActiva(true);
		producto.setCantidadComprada(5);
		producto.setCompra(compra);
		producto.setMarca("MiCasa");
		producto.setNombre("Balón de fútbol");
		producto.setPrecioCompra(2.0f);
		producto.setPrecioVenta(5.0f);
		
		producto2 = new Producto();
		producto2.setActiva(true);
		producto2.setCantidadComprada(10);
		producto2.setCompra(compra);
		producto2.setMarca("MiCasa");
		producto2.setNombre("Balón de fútbol");
		producto2.setPrecioCompra(3.0f);
		producto2.setPrecioVenta(5.0f);
	}

	@Test
	void actualizarImporteTotalTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto);

		listaProductos.add(producto2);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(40, compra.getImporteTotal());
	}
	
	@Test
	void actualizarStockTest() {
		
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto);
		
		cut.actualizarImporteTotal(listaProductos);
		cut.actualizarStrock(listaProductos);
		
		assertEquals(5, producto.getStock());
	}

}
