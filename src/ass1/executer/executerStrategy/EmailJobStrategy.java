package src.ass1.executer.executerStrategy;


import src.ass1.connections.Connection;
import src.ass1.job.Job;



public  class EmailJobStrategy  implements JobStrategy {

    public String name = "EmailType";
    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[EmailJob] Preparing to send email using config: " + job.getConfig());
        connection.executeQuery("INSERT INTO email_sent (job, status) VALUES ('" + job.getId() + "', 'SENT')");
    }

    @Override
    public String getName() {
        return this.name;
    }
}

