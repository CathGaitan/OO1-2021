package ar.edu.unlp.info.oo1.ejercicio11;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlazoFijoTest {
	private PlazoFijo plazoFijo1,plazoFijo2;
	
	@BeforeEach
	public void setUp(){
		plazoFijo1=new PlazoFijo(LocalDate.now().minusDays(10),1000,5);
		plazoFijo2=new PlazoFijo(LocalDate.now().minusDays(50),50000,20);
	}
	
	@Test
	public void valorActualTest(){
		assertEquals(500,plazoFijo1.valorActual());
		assertEquals(500000,plazoFijo2.valorActual());
	}

}
