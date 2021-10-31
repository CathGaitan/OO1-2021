package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unlp.info.oo1.ejercicio14.*;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioNoche;
	private Usuario propietario;
	private Cancelacion cancelacion;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioNoche, Usuario propietario, Cancelacion cancelacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioNoche = precioNoche;
		this.propietario = propietario;
		this.cancelacion=cancelacion;
		this.reservas = new ArrayList<>();
	}
	
	public boolean estaDisponible(DateLapse periodo){
		return !this.reservas.stream().anyMatch(r -> r.seSuperponen(periodo));
	}
	
	public double eliminarReserva(LocalDate fecha,Reserva reserva){
		if((this.reservas.contains(reserva))&&(reserva.estaDespues(fecha))){
			this.reservas.remove(reserva);
			return this.cancelacion.reembolso(fecha, reserva);
		}else{
			return -1;
		}
	}
	
	public void agregarReserva(Reserva reserva){
		this.reservas.add(reserva);
	}
	
	public List<Reserva> obtenerReservas(){
		return this.reservas;
	}
	
	public double getPrecioNoche(){
		return this.precioNoche;
	}
	
	public double calcularIngresos(DateLapse periodo){
		return this.reservas.stream()
				.filter(r -> r.seSuperponen(periodo))
				.mapToDouble(r -> r.calcularPrecioReserva())
				.sum();
	}

}
