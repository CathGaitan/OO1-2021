package ar.edu.unlp.info.oo1.ejercicio15;
import org.junit.jupiter.api.BeforeEach;
import ar.edu.unlp.info.oo1.ejercicio14.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PropiedadTest {
	private Propiedad Casa,Monoambiente,Oficina;
	private Usuario Cath,Maciel;
	private CancelacionModerada moderada;
	private CancelacionEstricta estricta;
	private CancelacionFlexible flexible;
	private DateLapse periodoOct,periodoDic,periodoLibre,periodoNoLibre;
	
	@BeforeEach
	public void setUp(){
		moderada=new CancelacionModerada();
		estricta=new CancelacionEstricta();
		flexible= new CancelacionFlexible();
		Cath=new Usuario("Cath","Tolosa",123456);
		Maciel=new Usuario("Maciel","Cordoba",654321);
		Casa=new Propiedad("Casa","Bella","Tolosa",25,Cath,moderada);
		Monoambiente=new Propiedad("Monoambiente","Calida","BS.AS",12,Cath,estricta);
		Oficina=new Propiedad("Oficina","Aburrida","Cordoba",8,Maciel,flexible);
		//inicializar periodos
		//son 6 dias
		periodoOct = new DateLapse(LocalDate.of(2021,10,11),LocalDate.of(2021,10,17));
		//son 10 dias
		periodoDic = new DateLapse(LocalDate.of(2021,12,20),LocalDate.of(2021,12,30));
		periodoLibre = new DateLapse(LocalDate.of(2022,2,13),LocalDate.of(2022,2,20));
		periodoNoLibre= new DateLapse(LocalDate.of(2021,9,3),LocalDate.of(2021,10,30));
	}

	@Test
	public void agregarReservaTest(){
		Reserva reservaOct = new Reserva(Casa,periodoOct);
		Reserva reservaDic = new Reserva(Casa,periodoDic);
		List<Reserva> res = List.of(reservaOct,reservaDic);
		List<Reserva> vacia = new ArrayList<>();
		assertEquals(Casa.obtenerReservas(),vacia);
		Casa.agregarReserva(reservaOct);
		Casa.agregarReserva(reservaDic);
		assertEquals(Casa.obtenerReservas(),res);
	}
	
	@Test
	public void estaDisponibleTest(){
		Reserva reservaOct = new Reserva(Casa,periodoOct);
		Reserva reservaDic = new Reserva(Casa,periodoDic);
		Casa.agregarReserva(reservaOct);
		Casa.agregarReserva(reservaDic);
		assertTrue(Casa.estaDisponible(periodoLibre));
		assertFalse(Casa.estaDisponible(periodoNoLibre));
		assertTrue(Monoambiente.estaDisponible(periodoDic));
	}
	
	@Test
	public void eliminarReservaTest(){
		Reserva reservaCasa= new Reserva(Casa,periodoOct);
		Reserva reservaOficina = new Reserva(Oficina,periodoOct);
		Reserva reservaMonoambiente = new Reserva(Monoambiente,periodoOct);
		Reserva reservaNoExiste = new Reserva(Casa,periodoDic);
		Casa.agregarReserva(reservaCasa);
		Oficina.agregarReserva(reservaOficina);
		Monoambiente.agregarReserva(reservaMonoambiente);
		//eliminar reserva despues de la fecha de reserva
		assertEquals(-1,Casa.eliminarReserva(LocalDate.of(2022,01,01),reservaCasa));
		//eliminar reserva con cancelacion moderada
		assertEquals(75,Casa.eliminarReserva(LocalDate.of(2021,10,8),reservaCasa));
		//eliminar reserva con cancelacion estricta
		assertEquals(0,Monoambiente.eliminarReserva(LocalDate.of(2021,10,8),reservaMonoambiente));
		//eliminar reserva con cancelacion flexible
		assertEquals(48,Oficina.eliminarReserva(LocalDate.of(2021,10,8),reservaOficina));
		//eliminar reserva que no existe
		assertEquals(-1,Casa.eliminarReserva(LocalDate.of(2021,12,18),reservaNoExiste));
	}
	
	@Test
	public void calcularIngresos(){
		Reserva reservaOct = new Reserva(Casa,periodoOct);
		Reserva reservaDic = new Reserva(Casa,periodoDic);
		DateLapse periodo2021 = new DateLapse(LocalDate.of(2021,1,1),LocalDate.of(2021,12,31));
		DateLapse periodo2018 = new DateLapse(LocalDate.of(2018,1,1),LocalDate.of(2018,12,31));
		Casa.agregarReserva(reservaOct);
		Casa.agregarReserva(reservaDic);
		assertEquals(400,Casa.calcularIngresos(periodo2021));
		assertEquals(0,Oficina.calcularIngresos(periodo2018));
	}
}
