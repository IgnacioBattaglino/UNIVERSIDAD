package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class SchedulerFifo extends JobScheduler{

    public SchedulerFifo(){
        super();
    }

    @Override
    protected JobDescription selectNextJob() {
        return jobs.get(0);  // Selecciona el primer trabajo
    }     
}
