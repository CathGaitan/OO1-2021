package ar.edu.unlp.info.oo1.ejercicio10;
import java.util.List;

public class HighestPriorityScheduler implements Strategy{

	public Job next(List<Job> jobs){
		Job nextJob = jobs.stream()
				.max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
				.orElse(null);
        	return nextJob;
	}

}
