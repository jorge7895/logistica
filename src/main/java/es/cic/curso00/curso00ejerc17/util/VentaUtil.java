package es.cic.curso00.curso00ejerc17.util;

import java.util.List;

import es.cic.curso00.curso00ejerc17.exception.ProductoException;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;

public class VentaUtil {
	
	public void actualizarImporteTotal(List<Producto> listaProductos) {
		
		double importeTotalActual = 
				listaProductos.stream()
				.mapToDouble(p -> p.getCantidad()*p.getPrecioVenta())
				.sum();
		
		listaProductos.forEach(p -> validarVenta(p.getVenta(), importeTotalActual));
	}
	
	public void actualizarStrock(List<Producto> listaProductos) {
				
		listaProductos.forEach(p -> p.setStock(p.getStock()-p.getCantidad()));
	}
	
	public void validarVenta(Venta venta, double importeTotal) {
		venta.setImporteTotal(importeTotal);
	}
	
	public void comprobarStock(List<Producto> listaProductos) {
		
		for (Producto producto : listaProductos) {
			if(producto.getStock() <= producto.getCantidad()) {
				throw new ProductoException("Stock insuficiente", producto);
			}
		}
	}
}
