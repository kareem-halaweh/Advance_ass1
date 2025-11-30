package src.ass1.executer;

import src.ass1.connections.Connection;
import src.ass1.connections.ConnectionAquair;
import src.ass1.job.Job;

public class JobProxyExecuter {
    private final JobExecutor executor;
    private final ConnectionAquair ca;

    public JobProxyExecuter(JobExecutor executor, ConnectionAquair ca) {
        this.executor = executor;
        this.ca = ca;
    }
    public void executeJob(Job job){
        String j = job.getType();
        if (!job.getRequestedBy().hasPermission(j)){
            System.out.printf("[JobProxyExecuter] User '%s' is NOT authorized '%s'%n", job.getRequestedBy().getName(),job.getType());
            return;
        }
        System.out.printf("[JobProxyExecuter] User '%s' is authorized '%s start now'%n", job.getRequestedBy().getName(),job.getType());
        var start=System.currentTimeMillis();
        Connection c = ca.acquire();
        try {
            executor.executeJob(job);
        } finally {
            ca.release(c);
            var finish = System.currentTimeMillis();
            var Time = finish-start;
            System.out.printf("[JobProxyExecuter] Job %s finished in %d ms%n", job.getName(), Time);
        }
    }
}
