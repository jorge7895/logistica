package es.cic.curso00.curso00ejerc17.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;

@Entity
@Table(name = "PRODUCTO")
public class Producto extends AbstractModel{
	
	private static final long serialVersionUID = 8372988849485424671L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Compra compra;
	
	private String nombre;
	
	private String marca;
	
	private float precioVenta;
	
	private float precioCompra;
	
	private long cantidadComprada;
	
	private long stock;
	
	private boolean activa;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public long getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(long cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}
	
}
