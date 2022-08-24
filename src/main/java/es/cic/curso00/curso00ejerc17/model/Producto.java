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
	
	private float precio;
	
	private long cantidad;
	
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
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
	
}
