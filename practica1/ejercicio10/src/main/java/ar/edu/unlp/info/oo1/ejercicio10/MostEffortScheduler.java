package ar.edu.unlp.info.oo1.ejercicio10;
import java.util.List;

public class MostEffortScheduler extends JobScheduler{

	public Job next(List<Job> jobs){
	     Job nextJob = jobs.stream()
	     			.max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
	     			.orElse(null);
			    return nextJob;
	}

}
