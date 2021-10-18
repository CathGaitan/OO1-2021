package ar.edu.unlp.info.oo1.ejercicio12;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	private Cilindro cilindro1,cilindro2;
	private Esfera esfera1,esfera2;
	private PrismaRectangular prisma1,prisma2;
	private ReporteDeConstruccion reporte;
	
	@BeforeEach
	public void setUp(){
		cilindro1 = new Cilindro(7,11,"Madera","Rojo");
		cilindro2 = new Cilindro(15,8,"Metal","Azul");
		esfera1 = new Esfera(13,"Madera","Azul");
		esfera2 = new Esfera(8, "Plastico", "Negro");
		prisma1 = new PrismaRectangular(11,5,4,"Metal","Rojo");
		prisma2 = new PrismaRectangular(17,6,8,"Plastico","Rojo");
		List<Pieza> piezas = new ArrayList<>();
		piezas.add(cilindro1);
		piezas.add(cilindro2);
		piezas.add(esfera1);
		piezas.add(esfera2);
		piezas.add(prisma1);
		piezas.add(prisma2);
		reporte = new ReporteDeConstruccion(piezas);
	}

	@Test
	public void getVolumenMaterialTest(){
		assertEquals(reporte.getVolumenDeMaterial("Madera"),10896);
		assertEquals(reporte.getVolumenDeMaterial("Plastico"),2961);
		assertEquals(reporte.getVolumenDeMaterial("Metal"),5875);
	}
	
	@Test
	public void getSuperficieDeColorTest(){
		assertEquals(reporte.getSuperficieDeColor("Rojo"),1602);
		assertEquals(reporte.getSuperficieDeColor("Azul"),4292);
		assertEquals(reporte.getSuperficieDeColor("Negro"),804);
	}
}
