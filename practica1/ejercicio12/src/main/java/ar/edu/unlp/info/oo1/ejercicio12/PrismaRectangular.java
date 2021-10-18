package ar.edu.unlp.info.oo1.ejercicio12;

public class PrismaRectangular extends Pieza{
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(int ladoMayor, int ladoMenor, int altura, String material, String color) {
		super(material,color);
		this.ladoMayor=ladoMayor;
		this.ladoMenor=ladoMenor;
		this.altura=altura;
	}
	
	public int getVolumen(){
		return this.ladoMayor*this.ladoMenor*this.altura;
	}
	
	public int getSuperficie(){
		return 2*(this.ladoMayor*this.ladoMenor
				+this.ladoMayor*this.altura
				+this.ladoMenor*this.altura);
	}
}
