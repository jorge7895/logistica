package es.cic.curso00.curso00ejerc17.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;

@Entity
public class Compra extends AbstractModel{

	private static final long serialVersionUID = 1L;
	
	private LocalDate fechaCompra;
	
	private float importeTotal;
	
	private boolean activa;

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
