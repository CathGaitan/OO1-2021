package ar.edu.unlp.info.oo1.ejercicio12;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
	private Esfera esfera1,esfera2;

	@BeforeEach
	public void setUp(){
		esfera1 = new Esfera(13,"Madera","Azul");
		esfera2 = new Esfera(8, "Plastico", "Negro");
	}
	
	@Test
	public void getVolumenTest(){
		assertEquals(esfera1.getVolumen(),9203);
		assertEquals(esfera2.getVolumen(),2145);
	}
	
	@Test
	public void getSuperficieTest(){
		assertEquals(esfera1.getSuperficie(),2124);
		assertEquals(esfera2.getSuperficie(),804);
	}
}
