package ar.edu.unlp.info.oo1.ejercicio15;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unlp.info.oo1.ejercicio14.*;

public class Usuario {
	private String nombre;
	private String direccion;
	private int DNI;
	private List<Propiedad> propiedades;
	
	public Usuario(){}
	public Usuario(String nombre, String direccion, int DNI) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.DNI=DNI;
		this.propiedades=new ArrayList<>();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void agregarPropiedad(Propiedad propiedad){
		this.propiedades.add(propiedad);
	}
	
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo){
		return this.propiedades.stream()
				.filter(p -> p.estaDisponible(periodo))
				.collect(Collectors.toList());
	}
	
	public List<Reserva> obtenerReservas(){
		List<Reserva> reservas = new ArrayList<>();
		this.propiedades.stream()
				.forEach(p -> reservas.addAll(p.obtenerReservas()));
		return reservas;
	}
	
	public double calcularIngresos(DateLapse periodo){
		return this.propiedades.stream().mapToDouble(p -> p.calcularIngresos(periodo)).sum();
	}

}
