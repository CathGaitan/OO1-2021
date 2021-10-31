package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDateTime;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

public abstract class Llamada {
	private LocalDateTime fecha;
	private double duracion; //en minutos
	private Integer numeroQueLlama;
	private Integer numeroQueRecibe;
	
	public Llamada(LocalDateTime fecha, double duracion, Integer numeroQueLlama, Integer numeroQueRecibe) {
		this.fecha=fecha;
		this.duracion=duracion;
		this.numeroQueLlama=numeroQueLlama;
		this.numeroQueRecibe=numeroQueRecibe;
	}

	public abstract double calcularCosto();
	
	public double getDuracion(){
		return this.duracion;
	}
	
	public LocalDateTime getFecha(){
		return this.fecha;
	}
	
	public boolean estaDentro(DateLapse periodo){
		return periodo.includesDate(this.fecha.toLocalDate());
	} 
}
