package es.cic.curso00.curso00ejerc17.util;

import java.util.List;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;

public class CompraUtil {

	
	public void actualizarImporteTotal(List<Producto> listaProductos) {
		
		double importeTotalActual = 
				listaProductos.stream()
				.mapToDouble(p -> p.getCantidad()*p.getPrecioCompra())
				.sum();
		
		listaProductos.forEach(p -> validarCompra(p.getCompra(), importeTotalActual));
	}
	
	public void actualizarStrock(List<Producto> listaProductos) {
				
		listaProductos.forEach(p -> p.setStock(p.getStock()+p.getCantidad()));
	}
	
	public void validarCompra(Compra compra, double importeTotal) {
		compra.setImporteTotal(importeTotal);
	}
}
