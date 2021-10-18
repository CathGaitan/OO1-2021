package ar.edu.unlp.info.oo1.ejercicio13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CarpetaTest {
	private Archivo foto,juego;
	private Email mailSinArchivos,mailConArchivos;
	private Carpeta carpeta,carpetaVacia;
	
	@BeforeEach
	public void setUp(){
		foto=new Archivo("FotoPlaya.png");
		juego=new Archivo("juego.exe");
		List<Archivo> adjuntosLleno = new ArrayList<Archivo>();
		adjuntosLleno.add(foto);
		adjuntosLleno.add(juego);
		mailSinArchivos = new Email("Saludo","Hola Cath, como estas?");
		mailConArchivos = new Email("Mando cositas!","Hola Cath, te mando estos archivos",adjuntosLleno);
		List<Email> emails=new ArrayList<>();
		emails.add(mailSinArchivos);
		emails.add(mailConArchivos);
		carpeta = new Carpeta("carpeta",emails);
		carpetaVacia = new Carpeta("carpetaVacia");
	}
	
	@Test
	public void tamanioTest(){
		assertEquals(carpeta.tamanio(),98);
		assertEquals(carpetaVacia.tamanio(),0);

	}
	
	@Test
	public void almacenarMailTest(){
		Email nuevoMail = new Email("Test","Queria saber como estabas");
		carpeta.almacenarMail(nuevoMail);
		assertSame(carpeta.buscarEmail("Test"),nuevoMail);
	}
	
	@Test
	public void eliminarMailTest(){
		assertSame(carpeta.buscarEmail("cositas"),mailConArchivos);
		carpeta.eliminarMail(mailConArchivos);
		assertNull(carpeta.buscarEmail("cositas"));
	}
	
	@Test
	public void buscarEmailTest(){
		assertSame(carpeta.buscarEmail("archivos"),mailConArchivos);
		assertSame(carpeta.buscarEmail("Saludo"),mailSinArchivos);
		assertSame(carpeta.buscarEmail("Hola Cath"),mailSinArchivos);
		assertNull(carpeta.buscarEmail("Una ballena"));
		assertNull(carpetaVacia.buscarEmail("Nada"));
	}
}
