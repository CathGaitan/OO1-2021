package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;

public interface Cancelacion {
	public double reembolso(LocalDate fecha, Reserva reserva);
}
