package ar.edu.unlp.info.oo1.ejercicio17;
import ar.edu.unlp.info.oo1.ejercicio14.*;

public class ClienteJuridico extends Cliente {
	private int CUIT;
	private String tipoDePersonaJuridica;
	
	public ClienteJuridico(String nombre, String direccion, int CUIT, String tipoPersona,Integer numero) {
		super(nombre,direccion,numero);
		this.CUIT=CUIT;
		this.tipoDePersonaJuridica=tipoPersona;
	}

	public double facturarLlamadas(DateLapse periodo){
		return super.facturarLlamadas(periodo);
	}
	
}
