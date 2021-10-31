package ar.edu.unlp.info.oo1.ejercicio17;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unlp.info.oo1.ejercicio14.*;

public class Tuenti {
	private List<Integer> numerosDisponibles;
	private List<Cliente> clientes;
	
	public Tuenti() {
		this.numerosDisponibles= new ArrayList<>();
		this.clientes=new ArrayList<>();
	}
	
	public void agregarNumero(int numero){
		this.numerosDisponibles.add(numero);
	}
	
	public ClienteFisico agregarClienteFisico(String nombre, String direccion, int DNI){
		Integer numero = this.numerosDisponibles.remove(0);
		ClienteFisico clienteF = new ClienteFisico(nombre,direccion,DNI,numero);
		this.clientes.add(clienteF);
		return clienteF;
	}
	
	public ClienteJuridico agregarClienteJuridico(String nombre, String direccion, int CUIT, String tipoPersona){
		Integer numero = this.numerosDisponibles.remove(0);
		ClienteJuridico clienteJ = new ClienteJuridico(nombre,direccion,CUIT,tipoPersona,numero);
		this.clientes.add(clienteJ);
		return clienteJ;
	}
	
	private Cliente encontrarCliente(Integer numero){
		return this.clientes.stream().filter(c -> c.getNumero().equals(numero)).findFirst().orElse(null);
	}
	
	public Llamada registrarLlamadaLocal(LocalDateTime fecha, double duracion, int numeroQueLlama, int numeroQueRecibe){
		Llamada local = new LlamadaLocal(fecha,duracion,numeroQueLlama,numeroQueRecibe);
		Cliente cliente = this.encontrarCliente(numeroQueLlama);
		cliente.agregarLlamada(local);
		return local;
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fecha, double duracion, int numeroQueLlama, int numeroQueRecibe, double distancia){
		LlamadaInterurbana interurbana = new LlamadaInterurbana(fecha,duracion,numeroQueLlama,numeroQueRecibe,distancia);
		Cliente cliente = this.encontrarCliente(numeroQueLlama);
		cliente.agregarLlamada(interurbana);
		return interurbana;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fecha, double duracion, int numeroQueLlama, int numeroQueRecibe, String paisOrigen, String paisDestino){
		LlamadaInternacional internacional = new LlamadaInternacional(fecha,duracion,numeroQueLlama,numeroQueRecibe,paisOrigen,paisDestino);
		Cliente cliente = this.encontrarCliente(numeroQueLlama);
		cliente.agregarLlamada(internacional);
		return internacional;
	}
	
	public Factura facturarLlamadas(Cliente cliente,DateLapse periodo){
		Factura factura = new Factura(cliente,periodo,LocalDate.now(),cliente.facturarLlamadas(periodo));
		return factura;
	}
	
}
