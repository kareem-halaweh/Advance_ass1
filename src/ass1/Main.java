package src.ass1;

import src.ass1.connections.ConnectionPool;
import src.ass1.executer.JobExecutor;
import src.ass1.executer.JobProxyExecuter;
import src.ass1.executer.executerStrategy.EmailJobStrategy;
import src.ass1.executer.executerStrategy.ReportJobStrategy;
import src.ass1.job.Job;
import src.ass1.model.User;
import src.ass1.templates.TemplateManager;


import java.util.Arrays;

  public class Main {
    public static void main(String[] args){
        System.out.println("=== TMPS Naive Starter App ===");
        ConnectionPool connManager = new ConnectionPool();
        TemplateManager templateManager = new TemplateManager();

        JobExecutor executor = new JobExecutor(connManager);
        JobProxyExecuter proxyExecuter = new JobProxyExecuter(executor,connManager);

        User user = new User("user", Arrays.asList("DATA", "REPORT")); // incomplete permissions
        User user1 = new User("user1", Arrays.asList("DATA","EMAIL")); // incomplete permissions

        // Demo: create a report job from template and execute
        System.out.println("\n--- Create Report Job from template (naive build) ---");

        Job reportJob = templateManager.acquireTemplate("MonthlyReport", "format=PDF;brand=TaskMaster", new ReportJobStrategy()).createJobInstance();
        reportJob.setRequestedBy(user);

        System.out.println("\n--- Execute job (naive executor) ---");
        proxyExecuter.executeJob(reportJob);

        System.out.println("\n--- Create Report Job from template (naive build) ---");


        Job reportJob2 = templateManager.acquireTemplate("Monthly email Report", "format=PDF;all=true",new EmailJobStrategy()).createJobInstance();
        reportJob2.setRequestedBy(user);

        System.out.println("\n--- Create Report Job from template (naive build) ---");


        Job reportJob3 = templateManager.acquireTemplate("Monthly email Report", "format=PDF;all=true",new EmailJobStrategy()).createJobInstance();
        reportJob3.setRequestedBy(user1);

        System.out.println("\n--- Execute job (naive executor) ---");
        proxyExecuter.executeJob(reportJob2);
        System.out.println("\n--- Execute job (naive executor) ---");
        proxyExecuter.executeJob(reportJob3);
    }
}
