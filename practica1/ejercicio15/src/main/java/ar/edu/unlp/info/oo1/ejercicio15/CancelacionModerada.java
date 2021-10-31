package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionModerada implements Cancelacion{
	
	public double reembolso(LocalDate fecha,Reserva reserva){
		double dias=fecha.until(reserva.getPeriodo().getFrom(),ChronoUnit.DAYS);
		if(dias >= 7) return reserva.calcularPrecioReserva();
		if(dias >= 2) return (reserva.calcularPrecioReserva()/2);
		return 0;
	}

}
