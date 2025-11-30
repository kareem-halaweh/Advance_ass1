package src.ass1.executer;

import src.ass1.connections.ConnectionAquair;
import src.ass1.executer.executerStrategy.JobStrategy;
import src.ass1.job.Job;
import src.ass1.connections.Connection;


public class JobExecutor {

    private final ConnectionAquair ca;

    public JobExecutor(ConnectionAquair ca) {
        this.ca = ca;
    }

    public void executeJob(Job job) {
        System.out.printf("[NaiveExecutor] Starting job %s (%s) requested by %s%n",
                job.getName(), job.getType(),
                job.getRequestedBy() == null ? "unknown" : job.getRequestedBy().getName());
        Connection c = ca.acquire();
        JobStrategy strategy = JobStrategyFactory.getJobStrategy(job.getType());
        try {
            strategy.execute(job, c);
        } finally {
            ca.release(c);
            System.out.printf("[NaiveExecutor] Finished job %s%n", job.getName());
        }
    }
}





