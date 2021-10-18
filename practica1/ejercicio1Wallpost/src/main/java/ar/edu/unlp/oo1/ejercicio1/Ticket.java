package ar.edu.unlp.oo1.ejercicio1;

import java.util.List;

public class Ticket {
	private List<Item> items;
	private int contadorDeItems;
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public void addItem(Item item){
		this.items.add(item);
		this.contadorDeItems++;
	}

}
