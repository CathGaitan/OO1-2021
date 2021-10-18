package ar.edu.unlp.info.oo1.ejercicio6;
import java.util.ArrayList;
import java.util.List;

public class FarolaMal {
	private boolean estado;
	private List<FarolaMal> farolas;
	
	public FarolaMal(){
		this.estado=false;
		farolas= new ArrayList<>();
	}
	
	private void addNeighbor(FarolaMal otraFarola){
		this.farolas.add(otraFarola);
	}
	
	public void pairWithNeighbor(FarolaMal otraFarola){
		this.farolas.add(otraFarola);
		otraFarola.addNeighbor(this);
	}

	//si se modifican los elementos de la copia, no se altera el original
	//pero si se alteran los objetos si, ya que la lista contiene la direccion
	//de donde esta ubicado cada objeto
	public List<FarolaMal> getNeighbors(){
		List<FarolaMal> farolasCopia = List.copyOf(this.farolas); 
		return farolasCopia;
	}
	
	public boolean isOn(){
		return estado;
	}
	
	public void turnOn(){
		this.turn(true);
	}
	
	public void turnOff(){
		this.turn(false);
	}
	
	private void setEstado(boolean estado){
		this.estado=estado;
	}
	
	private void changeState(boolean nuevoEstado, FarolaMal farola){
		if(nuevoEstado != farola.isOn()){
			farola.setEstado(nuevoEstado);
		}
	}
	
	private void turn(boolean nuevoEstado){
		if(nuevoEstado != this.isOn()){
			this.changeState(nuevoEstado, this);
			this.farolas.stream().forEach(farola -> farola.changeState(nuevoEstado, farola));
		}
	}
	
}