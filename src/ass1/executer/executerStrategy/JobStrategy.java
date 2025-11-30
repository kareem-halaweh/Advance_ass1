package src.ass1.executer.executerStrategy;

import src.ass1.job.Job;
import src.ass1.connections.Connection;

public interface JobStrategy {
    void execute(Job job, Connection connection);
    String getName();
}
