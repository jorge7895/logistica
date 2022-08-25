package es.cic.curso00.curso00ejerc17.util;

import java.util.List;

import es.cic.curso00.curso00ejerc17.exception.ProductoException;
import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;

public class MovimientoUtil {

	public void actualizarImporteTotal(List<Producto> listaProductos) {
		
		double importeTotalActual = 
				listaProductos.stream()
				.mapToDouble(p -> p.getCantidad()*p.getPrecioVenta())
				.sum();
		
		listaProductos.forEach(p -> actualizarImporteTotalMovimiento(p.getMovimiento(), importeTotalActual));
	}
	
	public void actualizarImporteTotalMovimiento(Movimiento movimiento, double importeTotal) {
		movimiento.setImporteTotal(importeTotal);
	}
	
	public void actualizarStrock(List<Producto> listaProductos, TipoMovimiento tipoMovimiento) {
				
		if (tipoMovimiento.equals(TipoMovimiento.VENTA)) {
			
			listaProductos.forEach(p -> p.setStock(p.getStock()-p.getCantidad()));
			
		}else if (tipoMovimiento.equals(TipoMovimiento.COMPRA)){
			
			listaProductos.forEach(p -> p.setStock(p.getStock()+p.getCantidad()));
		}
		
	}
	
	public void comprobarStock(List<Producto> listaProductos) {
		
		for (Producto producto : listaProductos) {
			if(producto.getStock() <= producto.getCantidad()) {
				throw new ProductoException("Stock insuficiente", producto);
			}
		}
	}
}
