package es.cic.curso00.curso00ejerc17.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;

@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractModel{
	
	private static final long serialVersionUID = 4979732051651217322L;

	private LocalDate fechaCompra;
	
	private double importeTotal;
	
	private boolean activa;

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
}
