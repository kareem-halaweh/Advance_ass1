package src.ass1.templates;

import src.ass1.job.Job;
import src.ass1.job.JobProtoType;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry  {

    private static final Map<String, JobProtoType> reg = new HashMap<>();


    public void add(JobProtoType prototype ,String kye) {
        if (prototype == null) return;
        reg.put(kye, prototype);
        System.out.println("[Registry] Registered template: " + kye);
    }

    public JobProtoType get(String kye) {
        if (kye == null) return null;
        return reg.get(kye.toUpperCase());
    }

    public boolean has(String kye) {
        if (kye == null) return false;
        return reg.containsKey(kye.toUpperCase());
    }

}
