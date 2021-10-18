package ar.edu.unlp.info.oo1.ejercicio14;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse2 {
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse2(LocalDate from, int sizeInDays) {
		this.from=from;
		this.sizeInDays=sizeInDays;
	}

	public LocalDate getFrom(){
		return this.from;
	}
	
	public LocalDate getTo(){
		LocalDate to = this.from.plusDays(this.sizeInDays());
		return to;
	}
	
	private void fromTo(LocalDate from, LocalDate to){
		this.from=from;
		this.sizeInDays=(int) this.from.until(to,ChronoUnit.DAYS);  
	}
	
	public int sizeInDays(){
		return this.sizeInDays;  
	}
	
	public boolean includesDate(LocalDate other){
		LocalDate to=this.from.plusDays(this.sizeInDays());
		if((other.isAfter(this.from)) &&
				(other.isBefore(this.from.plusDays(this.sizeInDays()))) ||
				(other.compareTo(this.from)==0) ||
				(other.compareTo(to)==0)) return true;
		return false;
	}
}
