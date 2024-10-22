package ar.edu.unlp.info.oo1.ej10_jobScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
    protected List<JobDescription> jobs;

    protected JobScheduler () {
        this.jobs = new ArrayList<>();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    // Método plantilla que contiene la lógica común
    public JobDescription next() {
        JobDescription nextJob = this.selectNextJob();  // Parte variable
        this.unschedule(nextJob);                       // Lógica común
        return nextJob;
    }

    // Método abstracto que implementan las subclases con la parte que varía
    protected abstract JobDescription selectNextJob();
}
