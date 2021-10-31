package ar.edu.unlp.info.oo1.ejercicio17;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

public class ClienteFisico extends Cliente{
	private int DNI;
	
	public ClienteFisico(String nombre, String direccion, int DNI, Integer numero) {
		super(nombre,direccion,numero);
		this.DNI=DNI;
	}
	
	public double facturarLlamadas(DateLapse periodo){
		double monto=super.facturarLlamadas(periodo);
		return (monto-(monto*0.1));
	}
	

}
