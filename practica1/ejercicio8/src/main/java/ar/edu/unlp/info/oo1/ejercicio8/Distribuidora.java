package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usurios = new ArrayList<>();
	
	public Distribuidora(double KWh){
		this.precioKWh=KWh;
	}
	
	public double getPrecioKW(){
		return this.precioKWh;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usurios;
	}
	
	public void agregarUsuario(Usuario usuario){
		this.usurios.add(usuario);
	}
	
	public double consumoTotalActiva(){
		return this.usurios.stream().mapToDouble(u -> u.ultimoConsumoActiva()).sum();
	}
	
	public List<Factura> facturar(){
		List<Factura> totalFacturas = new ArrayList<Factura>();
		this.usurios.stream().forEach(u -> totalFacturas.add(u.facturarEnBaseA(this.getPrecioKW())));
		return totalFacturas;
	}
}
