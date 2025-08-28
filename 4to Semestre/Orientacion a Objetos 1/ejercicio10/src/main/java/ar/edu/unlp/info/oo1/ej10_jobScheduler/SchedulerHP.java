package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class SchedulerHP extends JobScheduler{
    public SchedulerHP (){
        super();
    }

    @Override
    protected JobDescription selectNextJob() {
        return jobs.stream()
                   .max((j1, j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                   .orElse(null);  // Selecciona el trabajo con más prioridad
    }
}
