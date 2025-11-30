package src.ass1.executer.executerStrategy;

import src.ass1.connections.Connection;
import src.ass1.job.Job;

public class ReportJobStrategy implements JobStrategy
{

    public String name = "ReportType";

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[ReportJob] Generating report (" + job.getName() + ") using config: " + job.getConfig());
        connection.executeQuery("SELECT * FROM report_source WHERE report = '" + job.getName() + "'");
        connection.executeQuery("INSERT INTO generated_reports (job_id, path) VALUES ('" + job.getId() + "', '/reports/" + job.getId() + ".pdf')");

    }

    @Override
    public String getName() {
        return this.name;
    }
}

