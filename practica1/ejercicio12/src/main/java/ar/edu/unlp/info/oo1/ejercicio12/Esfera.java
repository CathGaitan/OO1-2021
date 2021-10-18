package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza{
	private int radio;
	
	public Esfera(int radio, String material, String color) {
		super(material,color);
		this.radio=radio;
	}
	
	public int getVolumen(){
		return (int) Math.round(4*Math.PI*Math.pow(this.radio,3)/3);	
	}
	
	public int getSuperficie(){
		return (int) Math.round(4*Math.PI*Math.pow(this.radio,2));
	}

}
