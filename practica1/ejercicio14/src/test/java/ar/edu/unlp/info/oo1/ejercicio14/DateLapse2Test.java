package ar.edu.unlp.info.oo1.ejercicio14;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateLapse2Test {
	private LocalDate diezAtras = LocalDate.now().minusDays(10);
	private LocalDate hoy = LocalDate.now();
	private LocalDate diezAdelante = LocalDate.now().plusDays(10);
	private DateLapse lapso1, lapso2,lapso3;
	
	@BeforeEach
	public void setUp(){
		lapso1 = new DateLapse(hoy,diezAdelante);
		lapso2 = new DateLapse(diezAtras,hoy);
		lapso3 = new DateLapse(diezAtras,diezAdelante);
	}
	
	@Test
	public void sizeInDaysTest(){
		assertEquals(lapso1.sizeInDays(),10);
		assertEquals(lapso2.sizeInDays(),10);
		assertEquals(lapso3.sizeInDays(),20);
	}
	
	@Test
	public void includesDateTest(){
		assertTrue(lapso1.includesDate(hoy.plusDays(2)));
		assertFalse(lapso1.includesDate(hoy.plusDays(200)));
		
		assertTrue(lapso2.includesDate(hoy.minusDays(2)));
		assertFalse(lapso2.includesDate(hoy.minusDays(200)));
		
		//from y to se consideran como adentro del rango
		assertTrue(lapso3.includesDate(diezAtras));
		assertTrue(lapso3.includesDate(diezAdelante));
	}
}