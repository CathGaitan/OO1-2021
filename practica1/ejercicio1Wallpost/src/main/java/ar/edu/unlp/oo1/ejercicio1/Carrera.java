package ar.edu.unlp.oo1.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
	private String nombre;
	private int dificultad;
	//collecciones -> arreglos,listas,arboles
	private List<Materia> materias;
	private Materia ISO;
	private Persona Cata;
	
	public Carrera(){
		//vacio
	}
	
	public Carrera(String nombre) { //Constructor
		this.nombre=nombre;
		this.materias=new ArrayList<Materia>();
		

	}
	
	public Carrera(String nombre, int dificultad) { //Constructor
		this.nombre=nombre;
		this.dificultad=dificultad;
	}
	
	public String nombresMaterias() {
		this.ISO.getNombre();
		this.Cata.getEdad();
	}
	

}
