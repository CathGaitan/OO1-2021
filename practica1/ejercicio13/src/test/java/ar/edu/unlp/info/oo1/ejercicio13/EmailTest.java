package ar.edu.unlp.info.oo1.ejercicio13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class EmailTest {
	private Archivo foto,juego;
	private Email mailSinArchivos,mailConArchivos,mailVacio;
	
	@BeforeEach
	public void setUp(){
		foto=new Archivo("FotoPlaya.png");
		juego=new Archivo("juego.exe");
		mailSinArchivos = new Email("Saludo","Hola Cath, como estas?");
		List<Archivo> adjuntos = new ArrayList<Archivo>();
		adjuntos.add(foto);
		adjuntos.add(juego);
		mailConArchivos = new Email("Mando archivos","Hola Cath, te mando estos archivos",adjuntos);
		mailVacio = new Email("","");
	}
	
	@Test
	public void tamanioTest(){
		assertEquals(mailSinArchivos.tamanio(),28);
		assertEquals(mailConArchivos.tamanio(),70);
		assertEquals(mailVacio.tamanio(),0);
	}

}
