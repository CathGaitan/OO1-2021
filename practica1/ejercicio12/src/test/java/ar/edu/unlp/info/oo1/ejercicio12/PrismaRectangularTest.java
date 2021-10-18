package ar.edu.unlp.info.oo1.ejercicio12;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	private PrismaRectangular prisma1,prisma2;
	
	@BeforeEach
	public void setUp(){
		prisma1 = new PrismaRectangular(11,5,4,"Metal","Rojo");
		prisma2 = new PrismaRectangular(17,6,8,"Plastico","Rojo");
	}
	
	@Test
	public void getVolumenTest(){
		assertEquals(prisma1.getVolumen(),220);
		assertEquals(prisma2.getVolumen(),816);
	}
	
	@Test
	public void getSuperficieTest(){
		assertEquals(prisma1.getSuperficie(),238);
		assertEquals(prisma2.getSuperficie(),572);
	}
}
