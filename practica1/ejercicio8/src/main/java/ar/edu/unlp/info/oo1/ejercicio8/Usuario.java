package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio){
		this.nombre=nombre;
		this.domicilio=domicilio;
		facturas = new ArrayList<>();
		consumos = new ArrayList<>();
	}
	
	public void agregarMedicion(Consumo medicion){	
		this.consumos.add(medicion);
	}
	
	//Si no habia consumos returna 0
	//Si habia consumos devuelve la energiaActiva del ultimo
	public double ultimoConsumoActiva(){
		Consumo consumo = this.ultimoConsumo();
		if(consumo.equals(null)) return 0;
		else return consumo.getEnergiaActiva();
	}
	
	//Si saberUltimoConsumo retorna un objConsumo, devuelve el objeto
	//Si la lista estaba vacia, retorna null
	public Consumo ultimoConsumo(){
		return this.saberUltimoConsumo().orElse(null);
	}
	
	//Recorre la lista utilizando el max. El max sirve para devolver el mayor. Recibe una funcion
	//comparadora (en este caso usa el compareTo de las fechas)
	private Optional<Consumo> saberUltimoConsumo(){ //OPTIONAL = devuelve null o Consumo
		return this.consumos
			.stream()
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()));
	}
	
	
	//Crea la factura del usuario en base al ultimo consumo
	public Factura facturarEnBaseA(double precioKWh){
		Consumo ultimoConsumo = this.ultimoConsumo();
		double descuento=0;
		if(ultimoConsumo == null){
			return new Factura(0,0,this);
		}else{
			if(ultimoConsumo.factorDePotencia() > 0.8){
				descuento=10;
			}
			return new Factura(ultimoConsumo.costoEnBaseA(precioKWh),descuento,this);
		}
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}
	
}
