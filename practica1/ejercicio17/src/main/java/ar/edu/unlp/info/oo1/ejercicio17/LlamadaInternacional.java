package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(LocalDateTime fecha, double duracion, Integer numeroQueLlama, Integer numeroQueRecibe,String paisOrigen,String paisDestino) {
		super(fecha,duracion,numeroQueLlama,numeroQueRecibe);
		this.paisOrigen=paisOrigen;
		this.paisDestino=paisDestino;
	}

	public double calcularCosto(){
		int precio=0;
		int horaComienzo=super.getFecha().toLocalTime().getHour();
		LocalTime ochoAm = LocalTime.of(8,0);
		LocalTime ochoPm = LocalTime.of(20,0);
		//horario diurno
		if((horaComienzo >= 8)&&(horaComienzo <= 20)) precio=4;
		//horario nocturno
		if((horaComienzo > 20)||((horaComienzo > 0))&&(horaComienzo <8)) precio=3;
		return (super.getDuracion()*precio);
	}
}
