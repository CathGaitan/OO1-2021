package ar.edu.unlp.info.oo1.ejercicio8;
import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoActiva, double consumoReactiva){
		this.fecha=fecha;
		this.consumoEnergiaActiva=consumoActiva;
		this.consumoEnergiaReactiva=consumoReactiva;
	}
	
	public LocalDate getFecha(){
		return this.fecha;
	}
	
	public double getEnergiaActiva(){
		return this.consumoEnergiaActiva;
	}
	
	public double costoEnBaseA(double precioKWh){
		return this.consumoEnergiaActiva*precioKWh;
	}
	
	public double factorDePotencia(){
		return (this.consumoEnergiaActiva/(Math.sqrt(Math.pow(this.consumoEnergiaActiva,2)+Math.pow(this.consumoEnergiaReactiva,2))));
	}
}
