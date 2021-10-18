package ar.edu.unlp.info.oo1.ejercicio11;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	private Inversor inversor1,inversor2;
	private InversionEnAcciones nintendo,sony;
	private PlazoFijo plazoFijo1;
	
	@BeforeEach
	public void setUp(){
		nintendo=new InversionEnAcciones("Nintendo",34,700);
		sony=new InversionEnAcciones("Sony",10,400);
		plazoFijo1=new PlazoFijo(LocalDate.now().minusDays(10),1000,5);
		List<Inversion> inversionesLleno = new ArrayList<>();
		inversionesLleno.add(nintendo);
		inversionesLleno.add(plazoFijo1);
		inversionesLleno.add(sony);
		inversor1 = new Inversor("Cath",inversionesLleno);
		List<Inversion> inversionesVacio = new ArrayList<>();
		inversor2 = new Inversor("Maciel",inversionesVacio);
	}
	
	@Test
	public void valorActual(){
		assertEquals(28300,inversor1.valorActual());
		assertEquals(0,inversor2.valorActual());
	}

}
