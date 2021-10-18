package ar.edu.unlp.info.oo1.ejercicio8;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidoraTestCath {
	private Distribuidora distribuidora, calcularTotal;
	private Usuario cath,lulu,leti;
	private Consumo alto,medio,bajo;
	
	
	@BeforeEach
	public void setUp(){
		distribuidora = new Distribuidora(20);
		calcularTotal = new Distribuidora(10);
		cath = new Usuario("Cath","Tolosa");
		lulu = new Usuario("Lulu","Berazategui");
		leti = new Usuario("Leti","La Plata");
		
		alto = new Consumo(LocalDate.of(2021, 6, 1), 5000, 2500);
		bajo = new Consumo(LocalDate.of(2021, 6, 2), 300, 300);
		medio = new Consumo(LocalDate.of(2021, 6, 3), 100, 800);
		
		calcularTotal.agregarUsuario(cath);
		calcularTotal.agregarUsuario(lulu);
		calcularTotal.agregarUsuario(leti);
	}
	
	@Test
	public void testConstructor(){
		assertEquals(20, distribuidora.getPrecioKW());
		assertTrue(distribuidora.getUsuarios().isEmpty());
	}
	
	@Test
	public void testAgregarUsuario(){
		distribuidora.agregarUsuario(cath);
		assertEquals(1,distribuidora.getUsuarios().size());
		assertSame(cath,distribuidora.getUsuarios().get(0));		
	}
	
	@Test
	public void testConsumoTotal(){
		this.cath.agregarMedicion(bajo);
		this.lulu.agregarMedicion(medio);
		this.leti.agregarMedicion(alto);
		assertEquals(5400,calcularTotal.consumoTotalActiva());
		Consumo nuevoConsumo = new Consumo(LocalDate.of(2021,6,10),2000,100);
		leti.agregarMedicion(nuevoConsumo);
		assertEquals(2400,calcularTotal.consumoTotalActiva());
	}
}
