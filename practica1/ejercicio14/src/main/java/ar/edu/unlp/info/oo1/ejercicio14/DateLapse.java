package ar.edu.unlp.info.oo1.ejercicio14;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from=from;
		this.to=to;
	}

	public LocalDate getFrom(){
		return this.from;
	}
	
	public LocalDate getTo(){
		return this.to;
	}
	
	private void fromTo(LocalDate from, LocalDate to){
		this.from=from;
		this.to=to;
	}
	
	public int sizeInDays(){
		return (int) this.from.until(this.to,ChronoUnit.DAYS);  
	}
	
	public boolean includesDate(LocalDate other){
		if((other.isAfter(this.from)) &&
				(other.isBefore(this.from.plusDays(this.sizeInDays()))) ||
				(other.compareTo(this.from)==0) ||
				(other.compareTo(this.to)==0)) return true;
		return false;
	}
}
