package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carpeta {
	private List<Email> emails;
	private String nombre;
	
	public Carpeta(String nombre){
		this.emails=new ArrayList<Email>();
		this.nombre=nombre;
	}
	
	public Carpeta(String nombre,List<Email> emails) {
		this.emails=emails;
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void almacenarMail(Email newEmail){
		this.emails.add(newEmail);
	}
	
	public void eliminarMail(Email email){
		this.emails.remove(email);
	}
	
	//devuelve el mail que contenga ese texto
	//si la lista esta vacia devuelve null
	public Email buscarEmail(String texto){
		return this.buscarEmail2(texto).orElse(null);
	}
	
	//Devuelve el primer mail que contenga ese texto en el titulo o en el cuerpo
	//si no lo encuentra devuelve null
	private Optional<Email> buscarEmail2(String texto){
		return this.emails.stream()
				.filter(e -> e.getTitulo().contains(texto)||e.getCuerpo().contains(texto))
				.findFirst();
	}
	
	public double tamanio(){
		return this.emails.stream().mapToDouble(Email::tamanio).sum();
	}

}
