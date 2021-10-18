package ar.edu.unlp.info.oo1.ejercicio11;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {
	private InversionEnAcciones inversion1,inversion2;
	
	@BeforeEach
	public void setUp(){
		inversion1=new InversionEnAcciones("Nintendo",34,700);
		inversion2=new InversionEnAcciones("Sony",10,400);
	}
	
	@Test
	public void valorActualTest(){
		assertEquals(23800,inversion1.valorActual());
		assertEquals(4000,inversion2.valorActual());
	}
}
