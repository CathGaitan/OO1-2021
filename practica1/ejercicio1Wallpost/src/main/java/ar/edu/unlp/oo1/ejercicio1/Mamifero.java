package ar.edu.unlp.oo1.ejercicio1;

public abstract class Mamifero {
	private String pelaje;

	public Mamifero() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPelaje(){
		return this.pelaje;
	}
	
	public abstract String hacerSonido();
	public abstract String caminar();
}
