package ar.edu.unlp.info.oo1.ejercicio8;
import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double montoActiva, double descuento, Usuario usuario){
		this.montoEnergiaActiva=montoActiva;
		this.descuento=descuento;
		this.usuario=usuario;
		this.fecha=LocalDate.now();
	}
	
	public double montoTotal(){
		return this.montoEnergiaActiva;
	}
	
	public Usuario usuario(){
		return this.usuario;
	}
	
	public LocalDate fecha(){
		return this.fecha;
	}
	
	public double getDescuento(){
		return this.descuento;
	}
}
