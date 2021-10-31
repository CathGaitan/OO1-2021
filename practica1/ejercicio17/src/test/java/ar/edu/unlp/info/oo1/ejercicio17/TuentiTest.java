package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;
import static org.junit.jupiter.api.Assertions.*;

public class TuentiTest {
	private Tuenti tuenti;
	private ClienteFisico Cath;
	private ClienteJuridico Nintendo;
	private LocalDateTime cumpleanios, hallowen, navidad;
	private DateLapse periodo1,periodoSinCumpleanios;
	private Factura factura1,factura2,factura3;
	
	
	@BeforeEach
	public void setUp(){
		tuenti=new Tuenti();
		for(int i=1;i<10;i++) tuenti.agregarNumero(i);
		Cath=tuenti.agregarClienteFisico("Cath","Tolosa",123456);
		Nintendo=tuenti.agregarClienteJuridico("Nintendo","Japon",666666,"Empresa");
		//inicializar fechas
		cumpleanios=LocalDateTime.of(2021,8,14,15,0); // 14.08.2021 a las 15:00 -> diurno
		hallowen=LocalDateTime.of(2021,10,31,20,0); // 31.10.2021 a las 20:00 -> nocturno
		navidad=LocalDateTime.of(2021,12,31,23,0); // 31.12.2021 a las 23:00 -> nocturno
		periodo1=new DateLapse(LocalDate.of(2019,1,1),LocalDate.of(2023,1,1));
		periodoSinCumpleanios=new DateLapse(LocalDate.of(2021,10,20),LocalDate.of(2022,2,20));
		
		
	}
	
	@Test
	public void FacturarLlamadasTest(){
		tuenti.registrarLlamadaLocal(hallowen,25,1,20);
		Factura factura1 = tuenti.facturarLlamadas(Cath,periodo1); //llama Cath, duracion=25minutos
		assertEquals(22.5,factura1.getMontoTotal());
		
		tuenti.registrarLlamadaInterurbana(navidad,12,1,35,150); //llama Cath, duracion=12minutos, distancia=150km
		Factura factura2 = tuenti.facturarLlamadas(Cath, periodo1);
		assertEquals(54,factura2.getMontoTotal());
		
		tuenti.registrarLlamadaInternacional(cumpleanios,8,1,55,"Argentina","Japon");//llama Cath, duracion=8 minutos, horario= diurno
		Factura factura3 = tuenti.facturarLlamadas(Cath, periodo1);
		assertEquals(82.8,factura3.getMontoTotal());
		
		Factura factura4 = tuenti.facturarLlamadas(Cath,periodoSinCumpleanios);
		assertEquals(54,factura4.getMontoTotal());
		
		Factura factura5 = tuenti.facturarLlamadas(Nintendo, periodo1);
		assertEquals(0,factura5.getMontoTotal());
		
		tuenti.registrarLlamadaInterurbana(navidad,65,2,41,600);
		Factura factura6 = tuenti.facturarLlamadas(Nintendo, periodo1);
		assertEquals(200,factura6.getMontoTotal());
	}

}
