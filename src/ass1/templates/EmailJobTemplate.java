package src.ass1.templates;

import src.ass1.job.Job;
import src.ass1.job.JobProtoType;

public class EmailJobTemplate extends HeavyTemplate {


    public EmailJobTemplate(String type, String name, String config, String templateBody) {
        super("EMAIL", name, config, templateBody);
    }
}
