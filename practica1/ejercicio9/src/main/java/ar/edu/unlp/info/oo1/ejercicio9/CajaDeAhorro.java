package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta{

	public CajaDeAhorro(){
		super();
	}
	
	protected boolean puedeExtraer(double monto){
		double montoConAdicional=monto+(monto*2)/100;
		if(montoConAdicional <= super.getSaldo()){
			return true;
		}
		return false;
	}
	

}
