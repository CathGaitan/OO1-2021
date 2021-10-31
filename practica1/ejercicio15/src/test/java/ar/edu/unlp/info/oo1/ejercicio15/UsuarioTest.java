package ar.edu.unlp.info.oo1.ejercicio15;
import org.junit.jupiter.api.BeforeEach;
import ar.edu.unlp.info.oo1.ejercicio14.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {
	private Propiedad Casa,Monoambiente,Oficina;
	private Usuario Cath,Maciel;
	private CancelacionModerada moderada;
	private CancelacionEstricta estricta;
	private CancelacionFlexible flexible;
	private DateLapse periodoOct,periodoDic,periodo2021;

	@BeforeEach
	public void setUp(){
		moderada=new CancelacionModerada();
		estricta=new CancelacionEstricta();
		flexible= new CancelacionFlexible();
		Cath=new Usuario("Cath","Tolosa",123456);
		Maciel=new Usuario("Maciel","Cordoba",654321);
		Casa=new Propiedad("Casa","Bella","Tolosa",25,Cath,moderada);
		Monoambiente=new Propiedad("Monoambiente","Calida","BS.AS",12,Cath,estricta);
		Oficina=new Propiedad("Oficina","Aburrida","Cordoba",8,Cath,flexible);
		Cath.agregarPropiedad(Casa);
		Cath.agregarPropiedad(Monoambiente);
		Cath.agregarPropiedad(Oficina);
		periodoOct = new DateLapse(LocalDate.of(2021,10,11),LocalDate.of(2021,10,17));
		periodoDic = new DateLapse(LocalDate.of(2021,12,20),LocalDate.of(2021,12,30));
	}
	
	@Test
	public void propiedadesDisponiblesTest(){
		Reserva reservaCasa=new Reserva(Casa,periodoOct);
		Reserva reservaMonoambiente=new Reserva(Monoambiente,periodoDic);
		Reserva reservaOficina=new Reserva(Oficina,periodoDic);
		Casa.agregarReserva(reservaCasa);
		Monoambiente.agregarReserva(reservaMonoambiente);
		Oficina.agregarReserva(reservaOficina);
		List<Propiedad> disp = List.of(Monoambiente,Oficina);
		assertEquals(disp,Cath.propiedadesDisponibles(periodoOct));
	}
	
	@Test
	public void obtenerReservasTest(){
		Reserva reservaCasa=new Reserva(Casa,periodoOct);
		Reserva reservaMonoambiente=new Reserva(Monoambiente,periodoDic);
		Reserva reservaOficina=new Reserva(Oficina,periodoDic);
		Casa.agregarReserva(reservaCasa);
		Monoambiente.agregarReserva(reservaMonoambiente);
		Oficina.agregarReserva(reservaOficina);
		List<Reserva> res = List.of(reservaCasa,reservaMonoambiente,reservaOficina);
		assertEquals(res,Cath.obtenerReservas());
		
		List<Reserva> vacia = new ArrayList<>();
		assertEquals(vacia,Maciel.obtenerReservas());
	}
	
	@Test
	public void calcularIngresosTest(){
		DateLapse periodo2021 = new DateLapse(LocalDate.of(2021,1,1),LocalDate.of(2021,12,31));
		DateLapse periodo2018 = new DateLapse(LocalDate.of(2018,1,1),LocalDate.of(2018,12,31));
		Reserva reservaCasa=new Reserva(Casa,periodoOct);
		Reserva reservaMonoambiente=new Reserva(Monoambiente,periodoDic);
		Casa.agregarReserva(reservaCasa);
		Monoambiente.agregarReserva(reservaMonoambiente);
		assertEquals(270,Cath.calcularIngresos(periodo2021));
		assertEquals(0,Cath.calcularIngresos(periodo2018));
		
		assertEquals(0,Maciel.calcularIngresos(periodo2021));
	}
	
	

}
