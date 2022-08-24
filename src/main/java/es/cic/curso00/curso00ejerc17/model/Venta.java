package es.cic.curso00.curso00ejerc17.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;

@Entity
@Table(name = "VENTA")
public class Venta extends AbstractModel{

	private static final long serialVersionUID = 4462799544158774628L;

	private LocalDate fechaVenta;
	
	private double importeTotal;
	
	private boolean activa;

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
