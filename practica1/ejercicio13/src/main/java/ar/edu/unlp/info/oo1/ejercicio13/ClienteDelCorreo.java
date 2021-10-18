package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.ArrayList;
import java.util.List;

public class ClienteDelCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDelCorreo() {
		inbox=new Carpeta("inbox");
		this.carpetas=new ArrayList<>();
		this.carpetas.add(inbox);
	}
	
	public ClienteDelCorreo(List<Carpeta> carpetas) {
		inbox=new Carpeta("inbox");
		this.carpetas=carpetas;
		this.carpetas.add(inbox);
	}
	
	public void recibir(Email email){
		this.inbox.almacenarMail(email);
	}
	
	public Carpeta getCarpeta(String nombreCarpeta){
		for(Carpeta c:carpetas){
			if(c.getNombre() == nombreCarpeta){
				return c;
			}
		}
		return null;
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino){
		origen.eliminarMail(email);
		destino.almacenarMail(email);
	}
	
	//Usar lamda, usar map (obtengo una collecion y despues fijarme como
	//sacar los nulls para quedarme con el email indicado)
	public Email buscar(String texto){
		for(Carpeta c:carpetas){
			Email emailEncontrado=c.buscarEmail(texto);
			if(emailEncontrado!=null){
				return emailEncontrado;
			}
		}
		return null;
	}
	
	public double espacioOcupado(){
		return carpetas.stream().mapToDouble(Carpeta::tamanio).sum();
	}
}
