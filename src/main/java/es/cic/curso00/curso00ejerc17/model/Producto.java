package es.cic.curso00.curso00ejerc17.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;

@Entity
@Table(uniqueConstraints ={@UniqueConstraint(name = "UniqueProducto", columnNames = {"nombre", "marca"})})
public class Producto extends AbstractModel{
	
	private static final long serialVersionUID = 8372988849485424671L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Movimiento movimiento;
	
	@NonNull
	private String nombre;
	
	@NonNull
	private String marca;
	
	private float precioVenta;
	
	private float precioCompra;
	
	private long cantidad;
	
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

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
}
