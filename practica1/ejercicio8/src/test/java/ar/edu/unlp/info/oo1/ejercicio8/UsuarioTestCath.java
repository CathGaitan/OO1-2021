package ar.edu.unlp.info.oo1.ejercicio8;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTestCath {
	private Usuario cath,lulu;
	private Consumo consumo1,consumo2;
	
	@BeforeEach
	public void setUp(){
		cath = new Usuario("Cath","Tolosa");
		lulu = new Usuario("Lulu", "Berazategui");
		consumo1 = new Consumo(LocalDate.of(2021, 6, 1), 5000, 2500);
		consumo2 = new Consumo(LocalDate.of(2021, 6, 2), 800, 100);
		
		cath.agregarMedicion(consumo1);
		cath.agregarMedicion(consumo2);
	}
	
	@Test
	public void testAgregarConsumo(){
		Consumo ultimoConsumo = new Consumo(LocalDate.of(2021, 6, 20), 500, 5000);
		this.cath.agregarMedicion(ultimoConsumo);
		assertEquals(this.cath.ultimoConsumo(),ultimoConsumo);
	}
	
	@Test
	public void testFacturarEnBaseA(){
		Factura facturaCath = this.cath.facturarEnBaseA(10);
		Factura facturaLulu = this.lulu.facturarEnBaseA(10);
		assertEquals(facturaCath.montoTotal(),8000);
		assertEquals(10, facturaCath.getDescuento());
		assertEquals(facturaLulu.montoTotal(),0);
		assertEquals(facturaLulu.getDescuento(),0);
	}

}
