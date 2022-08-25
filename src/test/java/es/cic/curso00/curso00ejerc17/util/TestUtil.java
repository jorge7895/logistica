package es.cic.curso00.curso00ejerc17.util;

import java.time.LocalDate;
import java.time.Month;

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;

public class TestUtil {
	
	private Movimiento movimiento;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private LocalDate fecha;
	
	public TestUtil()  {
		
		fecha = LocalDate.of(2022, Month.OCTOBER, 8);
		
		movimiento = new Movimiento();
		movimiento.setActiva(true);
		movimiento.setFecha(fecha);
		movimiento.setTipoMovimiento(TipoMovimiento.COMPRA);
		
		producto1 = new Producto();
		producto1.setActiva(true);
		producto1.setCantidad(5);
		producto1.setMarca("Micasa");
		producto1.setNombre("Balón de fútbol");
		producto1.setPrecioCompra(5.0f);
		producto1.setPrecioVenta(6.0f);
		producto1.setStock(50);
		
		producto2 = new Producto();
		producto2.setActiva(true);
		producto2.setCantidad(10);
		producto2.setMarca("Micasa");
		producto2.setNombre("Balón de baloncesto");
		producto2.setPrecioCompra(3.0f);
		producto2.setPrecioVenta(4.0f);
		producto2.setStock(50);
		
		producto3 = new Producto();
		producto3.setActiva(true);
		producto3.setCantidad(10);
		producto3.setMarca("Micasa");
		producto3.setNombre("Balón de balonmano");
		producto3.setPrecioCompra(2.0f);
		producto3.setPrecioVenta(3.0f);
		producto3.setStock(50);
	}

	public Producto getProducto1() {
		return producto1;
	}

	public Producto getProducto2() {
		return producto2;
	}

	public Producto getProducto3() {
		return producto3;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}


}
