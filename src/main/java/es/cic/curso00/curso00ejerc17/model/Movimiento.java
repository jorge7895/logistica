package es.cic.curso00.curso00ejerc17.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import es.cic.curso00.curso00ejerc17.util.AbstractModel;
import es.cic.curso00.curso00ejerc17.util.TipoMovimiento;

@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento extends AbstractModel{

	private static final long serialVersionUID = -7856945635006206480L;

	private LocalDate fecha;
	
	private double importeTotal;
	
	private TipoMovimiento tipoMovimiento;
	
	private boolean activa;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
