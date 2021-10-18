package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo=titulo;
		this.cuerpo=cuerpo;
		this.adjuntos=new ArrayList<Archivo>();
	}
	
	public Email(String titulo, String cuerpo, List<Archivo> adjuntos) {
		this.titulo=titulo;
		this.cuerpo=cuerpo;
		this.adjuntos=adjuntos;
	}
	
	public double tamanio(){
		return titulo.length()+cuerpo.length()+adjuntos.stream().mapToDouble(Archivo::tamanio).sum();	
	}
	
	public String getTitulo(){
		return this.titulo;
	}

	public String getCuerpo(){
		return this.cuerpo;
	}
}
