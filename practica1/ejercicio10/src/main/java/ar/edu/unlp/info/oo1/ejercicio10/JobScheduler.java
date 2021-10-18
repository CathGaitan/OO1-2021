package ar.edu.unlp.info.oo1.ejercicio10;
import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    private List<Job> jobs;
    private Strategy strategy;
   
    public JobScheduler () {
    	this.jobs = new ArrayList<>();
    }
    
    public void schedule(Job job) {
    	this.jobs.add(job);
    }

    public void unschedule(Job job) {
    	if (job != null) {
    	   this.jobs.remove(job);
    	}
    }
    
    public List<Job> getJobs(){
    	return jobs;
    }
    
    public Job next(){
    	Job oldJob = strategy.next(jobs);
    	unschedule(oldJob);
    	return oldJob;
    }
    
}

