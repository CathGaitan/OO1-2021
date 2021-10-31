package ar.edu.unlp.info.oo1.ejercicio17;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

public class LlamadasTest {
	private Tuenti tuenti;
	private LocalDateTime cumpleanios, hallowen, navidad;
	private DateLapse periodo1,periodoSinCumpleanios;
	private ClienteFisico Cath;
	private ClienteJuridico Nintendo;
	
	@BeforeEach
	public void setUp(){
		tuenti=new Tuenti();
		//inicializando clientes
		for(int i=1;i<10;i++) tuenti.agregarNumero(i);
		Cath=tuenti.agregarClienteFisico("Cath","Tolosa",123456);
		Nintendo=tuenti.agregarClienteJuridico("Nintendo","Japon",666666,"Empresa");
		//inicializando fechas
		cumpleanios=LocalDateTime.of(2021,8,14,15,0); // 14.08.2021 a las 15:00 -> diurno
		hallowen=LocalDateTime.of(2021,10,31,20,0); // 31.10.2021 a las 20:00 -> nocturno
		navidad=LocalDateTime.of(2021,12,31,23,0); // 31.12.2021 a las 23:00 -> nocturno
		periodo1=new DateLapse(LocalDate.of(2019,1,1),LocalDate.of(2023,1,1));
		periodoSinCumpleanios=new DateLapse(LocalDate.of(2021,10,20),LocalDate.of(2022,2,20));
	}
	
	
	@Test
	public void calcularCostoTest(){
		Llamada llamadaLocal=tuenti.registrarLlamadaLocal(hallowen,25,1,20); //duracion=25minutos
		assertEquals(25,llamadaLocal.calcularCosto());
		
		Llamada llamadaInterurbana=tuenti.registrarLlamadaInterurbana(navidad,12,1,35,150); //duracion=12minutos, distancia=150km
		assertEquals(35,llamadaInterurbana.calcularCosto());
		
		Llamada llamadaInternacional=tuenti.registrarLlamadaInternacional(cumpleanios,6,1,42,"Argentina","Japon"); //duracion=6minutos, diurno
		assertEquals(24,llamadaInternacional.calcularCosto());
		
		//las 8 y las 20 cuentan como horario diurno
		Llamada llamadaInternacional2=tuenti.registrarLlamadaInternacional(hallowen,6,1,42,"Argentina","Japon"); //duracion=6minutos, diurno
		assertEquals(24,llamadaInternacional2.calcularCosto());
		
		Llamada llamadaInternacional3=tuenti.registrarLlamadaInternacional(navidad,6,1,42,"Argentina","Japon"); //duracion=6minutos, nocturno
		assertEquals(18,llamadaInternacional3.calcularCosto());
	}

}
