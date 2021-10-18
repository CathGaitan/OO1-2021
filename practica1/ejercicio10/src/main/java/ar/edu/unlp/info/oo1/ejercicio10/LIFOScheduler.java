package ar.edu.unlp.info.oo1.ejercicio10;
import java.util.List;

public class LIFOScheduler extends JobScheduler{

	public Job next(List<Job> jobs){
		Job nextJob=null;
		nextJob = jobs.remove(jobs.size()-1);
    	return nextJob;
	}
}
