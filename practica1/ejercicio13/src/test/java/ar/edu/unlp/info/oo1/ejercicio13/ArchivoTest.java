package ar.edu.unlp.info.oo1.ejercicio13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArchivoTest {
	private Archivo foto,juego,vacio;

	@BeforeEach
	public void setUp(){
		foto=new Archivo("FotoPlaya.png");
		juego=new Archivo("juego.exe");
		vacio=new Archivo("");
	}
	
	@Test
	public void tamanioTest(){
		assertEquals(foto.tamanio(),13);
		assertEquals(juego.tamanio(),9);
		assertEquals(vacio.tamanio(),0);

	}
	

}
