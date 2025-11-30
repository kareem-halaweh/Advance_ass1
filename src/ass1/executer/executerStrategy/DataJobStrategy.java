package src.ass1.executer.executerStrategy;

import src.ass1.connections.Connection;
import src.ass1.job.Job;



public class DataJobStrategy  implements JobStrategy {

public String name = "DataType";

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[DataJob] Reading & transforming data using config: " + job.getConfig());
        connection.executeQuery("SELECT * FROM source_table WHERE job_id = '" + job.getId() + "'");
        connection.executeQuery("INSERT INTO processed_results (job_id) VALUES ('" + job.getId() + "')");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
