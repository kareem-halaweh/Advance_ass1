package src.ass1.templates;

import src.ass1.executer.executerStrategy.JobStrategy;
import  src.ass1.job.Job;
import src.ass1.job.JobProtoType;

public class HeavyTemplate  implements JobProtoType {
    private final String type;
    private final String name;
    private final String config;
    private final String templateBody;

    private final Job job;

    public HeavyTemplate(String type, String name, String config, String templateBody) {
        this.type = type;
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;

        String id = templateBody + " _ " + type + "-" + System.currentTimeMillis();
        this.job = new Job(id, type, name, config);
    }

    // naive: creates a new Job from scratch (no clone/prototype)

    @Override
    public Job createJobInstance() {
        Job  jobCopy = job.clone();
        String id = templateBody + " _ " + type + "-" + System.currentTimeMillis();
        jobCopy.setId(id);
        return jobCopy;
    }



    @Override
    public String getName() {
        return this.name;
    }


}
