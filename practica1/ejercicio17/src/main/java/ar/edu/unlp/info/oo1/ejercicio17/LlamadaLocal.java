package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{

	public LlamadaLocal(LocalDateTime fecha, double duracion, Integer numeroQueLlama, Integer numeroQueRecibe) {
		super(fecha,duracion,numeroQueLlama,numeroQueRecibe);
	}
	
	public double calcularCosto(){
		return super.getDuracion();
	}

}
