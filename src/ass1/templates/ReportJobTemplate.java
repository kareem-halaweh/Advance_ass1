package src.ass1.templates;

import src.ass1.job.Job;
import src.ass1.job.JobProtoType;

public class ReportJobTemplate extends HeavyTemplate {


    public ReportJobTemplate(String type, String name, String config, String templateBody) {
        super("REPORT", name, config, templateBody);
    }
}
