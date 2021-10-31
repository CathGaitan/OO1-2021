package ar.edu.unlp.info.oo1.ejercicio17;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private Integer numero;
	private List<Llamada> llamadas;

	public Cliente(String nombre, String direccion,Integer numero) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.numero=numero;
		this.llamadas= new ArrayList<>();
	}
	
	public void agregarLlamada(Llamada llamada){
		this.llamadas.add(llamada);
	}
	
	public Integer getNumero(){
		return this.numero;
	}
	
	public double facturarLlamadas(DateLapse periodo){
		return this.llamadas.stream()
				.filter(l -> l.estaDentro(periodo))
				.mapToDouble(l -> l.calcularCosto())
				.sum();
	}

}
