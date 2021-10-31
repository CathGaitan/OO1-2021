package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

public class Factura {
	private Cliente duenio;
	private DateLapse periodo;
	private LocalDate fechaFacturacion;
	private double montoTotal;
	
	public Factura(Cliente duenio, DateLapse periodo,LocalDate fecha, double montoTotal) {
		this.duenio=duenio;
		this.periodo=periodo;
		this.montoTotal=montoTotal;
		this.fechaFacturacion=fecha;
	}
	
	public double getMontoTotal(){
		return this.montoTotal;
	}

}
