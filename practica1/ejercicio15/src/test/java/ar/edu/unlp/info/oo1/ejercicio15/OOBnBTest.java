package ar.edu.unlp.info.oo1.ejercicio15;
import org.junit.jupiter.api.BeforeEach;
import ar.edu.unlp.info.oo1.ejercicio14.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OOBnBTest {
	private OOBnB ooBnBVacio, ooBnB;
	private Usuario Cath,Maciel,Lulu,Inquilino;
	private Propiedad Casa,Monoambiente,Oficina;
	private CancelacionModerada moderada;
	private CancelacionEstricta estricta;
	private CancelacionFlexible flexible;
	private DateLapse periodoOct,periodoDic,periodoLibre,periodoNoLibre;
	
	@BeforeEach
	public void setUp(){
		ooBnB = new OOBnB();
		ooBnBVacio = new OOBnB();
		moderada=new CancelacionModerada();
		estricta=new CancelacionEstricta();
		flexible= new CancelacionFlexible();
		//registrar usuarios
		Cath=ooBnB.registrarUsuario("Cath","Tolosa",123456);
		Maciel=ooBnB.registrarUsuario("Maciel","Cordoba",654321);
		Lulu=ooBnB.registrarUsuario("Lulu","Berazategui",666666);
		Usuario Inquilino = new Usuario();
		//registrar propiedades
		Casa=ooBnB.registrarPropiedad("Casa","Bella","Tolosa",25,Cath,moderada);
		Monoambiente=ooBnB.registrarPropiedad("Monoambiente","Calida","BS.AS",12,Cath, estricta);
		Oficina=ooBnB.registrarPropiedad("Oficina","Aburrida","Cordoba",8,Maciel,flexible);
		//inicializar periodos
		periodoOct = new DateLapse(LocalDate.of(2021,10,11),LocalDate.of(2021,10,17));
		periodoDic = new DateLapse(LocalDate.of(2021,12,20),LocalDate.of(2021,12,30));
		periodoLibre = new DateLapse(LocalDate.of(2022,2,13),LocalDate.of(2022,2,20));
		periodoNoLibre= new DateLapse(LocalDate.of(2021,9,3),LocalDate.of(2021,10,30));
	}
	
	@Test
	public void hacerReservaTest(){
		assertNotNull(ooBnB.hacerReserva(Casa,periodoOct,Inquilino));
		assertNull(ooBnB.hacerReserva(Casa,periodoNoLibre,Inquilino));
		assertNotNull(ooBnB.hacerReserva(Casa, periodoDic, Inquilino));
		assertNull(ooBnB.hacerReserva(Casa, periodoDic, Inquilino));
	}
	
	@Test
	public void buscarPropiedadesDisponiblesTest(){
		ooBnB.hacerReserva(Casa,periodoOct,Inquilino);
		ooBnB.hacerReserva(Monoambiente,periodoDic,Inquilino);
		ooBnB.hacerReserva(Oficina,periodoOct,Inquilino);
		List<Propiedad> disp = List.of(Casa,Oficina);
		assertEquals(ooBnB.buscarPropiedadesDisponibles(periodoDic),disp);	
	}
	
	@Test
	public void precioReservaTest(){
		Reserva reserva=ooBnB.hacerReserva(Casa,periodoOct,Inquilino);
		assertEquals(150,ooBnB.precioReserva(reserva));
	}
	
	@Test
	public void eliminarReservaTest(){
		Reserva reserva=ooBnB.hacerReserva(Casa,periodoOct,Inquilino);
		//eliminar reserva despues de la fecha de reserva
		assertEquals(-1,ooBnB.eliminarReserva(LocalDate.of(2022,01,01),reserva));
		//eliminar reserva con cancelacion moderada
		assertEquals(75,ooBnB.eliminarReserva(LocalDate.of(2021,10,8),reserva));
		//eliminar reserva con cancelacion estricta
		Reserva reserva2=ooBnB.hacerReserva(Monoambiente,periodoOct,Inquilino);
		assertEquals(0,ooBnB.eliminarReserva(LocalDate.of(2021,10,8),reserva2));
		//eliminar reserva con cancelacion flexible
		Reserva reserva3=ooBnB.hacerReserva(Oficina,periodoOct,Inquilino);
		assertEquals(48,ooBnB.eliminarReserva(LocalDate.of(2021,10,8),reserva3));
	}
	
	@Test
	public void obtenerReservasTest(){
		Reserva reserva1=ooBnB.hacerReserva(Oficina,periodoOct,Inquilino);
		Reserva reserva2=ooBnB.hacerReserva(Oficina,periodoDic,Inquilino);
		//con reservas
		List<Reserva> res = List.of(reserva1,reserva2);
		assertEquals(res,ooBnB.obtenerReservas(Maciel));
		//sin reservas
		List<Reserva> res2 = new ArrayList<>();
		assertEquals(res2,ooBnB.obtenerReservas(Cath));
	}
	
	@Test
	public void calcularIngresosTest(){
		DateLapse periodo2021 = new DateLapse(LocalDate.of(2021,1,1),LocalDate.of(2021,12,31));
		DateLapse periodo2018 = new DateLapse(LocalDate.of(2018,1,1),LocalDate.of(2018,12,31));
	
		ooBnB.hacerReserva(Oficina,periodoOct,Inquilino);
		ooBnB.hacerReserva(Oficina,periodoDic,Inquilino);
		assertEquals(128,ooBnB.calcularIngresos(Maciel, periodo2021));
		assertEquals(0,ooBnB.calcularIngresos(Maciel, periodo2018));
		
		ooBnB.hacerReserva(Casa,periodoOct,Inquilino);
		ooBnB.hacerReserva(Casa,periodoDic,Inquilino);
		ooBnB.hacerReserva(Monoambiente,periodoDic,Inquilino);
		assertEquals(520,ooBnB.calcularIngresos(Cath,periodo2021));
		assertEquals(0,ooBnB.calcularIngresos(Cath,periodo2018));

	}
}
