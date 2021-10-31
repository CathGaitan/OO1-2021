package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;
import ar.edu.unlp.info.oo1.ejercicio14.*;

public class Reserva {
	private Propiedad propiedad;
	private DateLapse periodo;

	public Reserva(Propiedad propiedad, DateLapse periodo) {
		this.propiedad = propiedad;
		this.periodo = periodo;
	}
	
	public double calcularPrecioReserva(){
		return (this.propiedad.getPrecioNoche()*this.periodo.sizeInDays());
	}
	
	public DateLapse getPeriodo(){
		return this.periodo;
	}
	
	public double eliminarReserva(LocalDate fecha,Reserva reserva){
		return this.propiedad.eliminarReserva(fecha,reserva);
	}
	
	public boolean seSuperponen(DateLapse otroPeriodo){
		return this.periodo.overlaps(otroPeriodo);
	}
	
	public boolean estaDespues(LocalDate fecha){
		return this.periodo.getFrom().isAfter(fecha);
	}
}
