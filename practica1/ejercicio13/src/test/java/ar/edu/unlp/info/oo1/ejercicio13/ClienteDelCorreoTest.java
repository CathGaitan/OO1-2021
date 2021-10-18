package ar.edu.unlp.info.oo1.ejercicio13;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDelCorreoTest {
	private Archivo foto,juego,virus;
	private Email mailSinArchivos,mailConArchivos,mailPaypal,mailBanco;
	private Carpeta spam,familia;
	private ClienteDelCorreo Cath;
	
	@BeforeEach
	public void setUp(){
		//Crear carpeta familia
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
		familia = new Carpeta("familia",emails);
		//Crear carpeta spam
		virus=new Archivo("noSoyUnVirus.exe");
		List<Archivo> adjuntos = new ArrayList<Archivo>();
		adjuntos.add(virus);
		mailBanco=new Email("App","Descargue la nueva app del Banco",adjuntos);
		mailPaypal=new Email("Gane 5usd","Entre a Paypal y reclame su dinero!");
		List<Email> emails2=new ArrayList<>();
		emails2.add(mailBanco);
		emails2.add(mailPaypal);
		spam = new Carpeta("spam",emails2);
		//Crear ClienteDelCorreo
		List<Carpeta> carpetas = new ArrayList<>();
		carpetas.add(familia);
		carpetas.add(spam);
		Cath = new ClienteDelCorreo(carpetas);
	}
	
	@Test
	public void recibirTest(){
		Email nuevoMail = new Email("Importante!","Pague YA!");
		Cath.recibir(nuevoMail);
		assertSame(Cath.buscar("YA!"),nuevoMail);
		Email nuevoMail2 = new Email("Visite nuestra pagina","www.mercadolibre.com");
		Cath.recibir(nuevoMail2);
		assertSame(Cath.buscar("mercadolibre"),nuevoMail2);
	}
	
	@Test
	public void moverTest(){
		Cath.mover(mailBanco, spam, familia);
		assertSame(Cath.getCarpeta("familia").buscarEmail("Banco"),mailBanco);
		assertNull(Cath.getCarpeta("spam").buscarEmail("Banco"));
	}
	
	public void buscarTest(){
		assertSame(Cath.buscar("Paypal"),mailPaypal);
		assertNull(Cath.buscar("No existe"));
		
	}
	
	@Test
	public void tamanioOcupadoTest(){
		assertEquals(Cath.espacioOcupado(),193); //familia=98 spam=95 total=193
	}

}
