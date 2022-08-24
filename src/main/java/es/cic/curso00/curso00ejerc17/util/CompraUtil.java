package es.cic.curso00.curso00ejerc17.util;

import java.util.List;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;

public class CompraUtil {

	
	public void actualizarImporteTotal(List<Producto> listaProductos, Compra compra) {
		
		double importeTotalActual = compra.getImporteTotal();
		
//		listaProductos.forEach(p -> (importeTotalActual += p.getPrecio() * p.getCantidad()));
	}
}
