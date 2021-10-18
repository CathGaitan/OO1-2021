package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente(){
		super();
		this.descubierto=0;
	}
	
	public double getDescubierto(){
		return descubierto;
	}
	
	public void setDescubierto(double descubierto){
		this.descubierto=descubierto;
	}
	
	protected boolean puedeExtraer(double monto){
		double saldoRestante = this.getSaldo()-monto;
		if(saldoRestante < 0){
			if((saldoRestante*-1) < this.descubierto){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	
}
