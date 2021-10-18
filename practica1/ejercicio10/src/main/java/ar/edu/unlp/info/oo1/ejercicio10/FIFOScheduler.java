package ar.edu.unlp.info.oo1.ejercicio10;
import java.util.List;

public class FIFOScheduler extends JobScheduler{
	
	public Job next(List<Job> jobs){
		Job nextJob=null;
		nextJob = jobs.remove(0);
    	return nextJob;
	}

}
