package src.ass1.templates;

import src.ass1.executer.executerStrategy.JobStrategy;
import src.ass1.job.Job;
import src.ass1.job.JobProtoType;

public class TemplateManager {
    private JobTemplateRegistry jobTemplateRegistry = new JobTemplateRegistry();

    public HeavyTemplate buildJobTemplate(String templateName, String config, JobStrategy jobStrategy) {
        var templateBody =  simulateHeavyLoad(jobStrategy.getName()+":"+templateName);
        HeavyTemplate t = new HeavyTemplate(jobStrategy.getName(), templateName, config, templateBody);
        System.out.println("Built template (heavy): " + templateName);
        return t;
    }


    private String simulateHeavyLoad(String msg) {
        System.out.println("Simulating heavy template creation for: " + msg);
        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return "Large template";
    }

    public JobProtoType acquireTemplate(String templateName, String config, JobStrategy jobStrategy) {

        String kye = (jobStrategy.getName()+","+templateName + "," + config)  ;
        if (jobTemplateRegistry.has(kye)) {
            JobProtoType p = jobTemplateRegistry.get(kye);
            return p;
        }
        JobProtoType newTemplate = buildJobTemplate(templateName, config, jobStrategy);
        jobTemplateRegistry.add(newTemplate,kye);

        return newTemplate;
    }


}
