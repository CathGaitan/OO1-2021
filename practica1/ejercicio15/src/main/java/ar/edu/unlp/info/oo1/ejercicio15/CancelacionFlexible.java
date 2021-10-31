package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;

public class CancelacionFlexible implements Cancelacion{
	
	public double reembolso(LocalDate fecha,Reserva reserva){
		return reserva.calcularPrecioReserva();
	}

}
