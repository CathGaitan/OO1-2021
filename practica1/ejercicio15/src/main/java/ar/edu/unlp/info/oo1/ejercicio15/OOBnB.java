package ar.edu.unlp.info.oo1.ejercicio15;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unlp.info.oo1.ejercicio14.*;

public class OOBnB {
	private List<Usuario> usuarios;
	
	public OOBnB() {
		this.usuarios=new ArrayList<>();
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, int DNI){
		Usuario usuario = new Usuario(nombre,direccion,DNI);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioNoche,Usuario propietario, Cancelacion cancelacion){
		Propiedad propiedad = new Propiedad(nombre,descripcion,direccion,precioNoche,propietario,cancelacion);
		propietario.agregarPropiedad(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo){
		List<Propiedad> disponibles = new ArrayList<>();
		this.usuarios.stream()
			.forEach(u -> disponibles.addAll(u.propiedadesDisponibles(periodo)));
		return disponibles;
	}
	
	public Reserva hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino){
		if(propiedad.estaDisponible(periodo)){
			Reserva reserva = new Reserva(propiedad,periodo);
			propiedad.agregarReserva(reserva);
			return reserva;
		}else{
			return null;
		}
	}
	
	public double precioReserva(Reserva reserva){
		return reserva.calcularPrecioReserva();
	}
	
	//si la fecha en la que se hace la cancelacion es anterior
	//devuelve el reembolso correspondiente a la politica
	//si la fecha es posterior, devuelve -1
	public double eliminarReserva(LocalDate fecha,Reserva reserva){
		if(reserva.estaDespues(fecha)){
			return reserva.eliminarReserva(fecha,reserva);
		}
		return -1;
	}
	
	public List<Reserva> obtenerReservas(Usuario usuario){
		return usuario.obtenerReservas();
	}
	
	public double calcularIngresos(Usuario usuario, DateLapse periodo){
		return usuario.calcularIngresos(periodo);
	}
	

}
