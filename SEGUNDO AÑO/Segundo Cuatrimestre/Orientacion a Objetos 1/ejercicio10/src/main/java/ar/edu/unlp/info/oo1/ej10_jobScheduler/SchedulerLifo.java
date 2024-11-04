package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class SchedulerLifo extends JobScheduler {

    public SchedulerLifo (){
        super();
    }

    @Override
    protected JobDescription selectNextJob() {
        return jobs.get(jobs.size() - 1);  // Selecciona el último trabajo
    }
}
