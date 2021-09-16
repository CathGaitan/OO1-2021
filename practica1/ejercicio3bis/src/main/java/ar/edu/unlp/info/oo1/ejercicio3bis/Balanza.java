package ar.edu.unlp.info.oo1.ejercicio3bis;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos = new ArrayList<Producto>();
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public void ponerEnCero(){
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto){
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket(){
		return new Ticket(LocalDate.now(),this.getCantidadDeProductos(),this.getPesoTotal(),this.getPrecioTotal());
	}


	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	//SOLUCIONES TRADICIONALES
	public double getPesoTotal() {
		double totalPeso=0;
		for(Producto producto:productos){
			totalPeso+=producto.getPeso();
		}
		return totalPeso;
	}
	
	public double getPrecioTotal(){
		double totalPrecio=0;
		for(Producto producto:productos){
			totalPrecio+=producto.getPrecio();
		}
		return totalPrecio;
	}
	
	//SOLUCIONES LAMDA
	public double getPesoTotalLamda(){
		return this.productos.stream().mapToDouble(Producto::getPeso).sum();
	}
	
	public double getPrecioTotalLamda(){
		return this.productos.stream().mapToDouble(Producto::getPrecio).sum();
	}
	
}	
