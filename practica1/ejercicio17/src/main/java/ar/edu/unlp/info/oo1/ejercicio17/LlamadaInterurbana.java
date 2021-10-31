package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada{
	private double distanciaEntreNumeros;
	
	public LlamadaInterurbana(LocalDateTime fecha, double duracion, Integer numeroQueLlama, Integer numeroQueRecibe, double distancia) {
		super(fecha,duracion,numeroQueLlama,numeroQueRecibe);
		this.distanciaEntreNumeros=distancia;
	}
	
	public double calcularCosto(){
		double costoDistancia=0;
		if(this.distanciaEntreNumeros < 100) costoDistancia=2;
		if((this.distanciaEntreNumeros >= 100) && (this.distanciaEntreNumeros <= 500)) costoDistancia=2.5;
		if(this.distanciaEntreNumeros > 500) costoDistancia=3;
		return (5+(super.getDuracion()*costoDistancia));
	}

}
