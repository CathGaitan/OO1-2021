package ar.edu.unlp.info.oo1.ejercicio12;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {
	private Cilindro cilindro1,cilindro2;
	
	@BeforeEach
	public void setUp(){
		cilindro1 = new Cilindro(7,11,"Madera","Rojo");
		cilindro2 = new Cilindro(15,8,"Metal","Azul");
	}
	
	@Test
	public void getVolumenTest(){
		assertEquals(cilindro1.getVolumen(),1693);
		assertEquals(cilindro2.getVolumen(),5655);
	}
	
	@Test
	public void getSuperficieTest(){
		assertEquals(cilindro1.getSuperficie(),792);
		assertEquals(cilindro2.getSuperficie(),2168);
	}
}
