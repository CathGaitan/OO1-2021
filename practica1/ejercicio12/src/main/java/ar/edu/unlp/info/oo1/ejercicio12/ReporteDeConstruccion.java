package ar.edu.unlp.info.oo1.ejercicio12;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion(List<Pieza> piezas) {
		this.piezas=piezas;
	}
	
	public double getVolumenDeMaterial(String material){
		return this.piezas.stream()
				.filter(pieza -> pieza.getMaterial() == material)
				.mapToDouble(Pieza::getVolumen)
				.sum();
	}
	
	public double getSuperficieDeColor(String color){
		return this.piezas.stream()
				.filter(pieza -> pieza.getColor() == color)
				.mapToDouble(Pieza::getSuperficie)
				.sum();
	}
}
