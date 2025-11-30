package src.ass1.job;

import src.ass1.executer.executerStrategy.JobStrategy;
import src.ass1.model.User;


public class Job implements Cloneable {
    private String id;
    private String type;
    private String name;
    private String config;
    private User requestedBy;

    public Job(String id, String type, String name, String config) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.config = config;
    }

    private Job(Job original) {
        this.id = original.id + "-" + System.currentTimeMillis();
        this.type = original.type;
        this.name = original.name;
        this.config = original.config;
        this.requestedBy = original.requestedBy;
    }

    @Override
    public Job clone() {
        return new Job(this);
    }


    public String getId() { return id; }
    public String getType() { return type; }
    public String getName() { return name; }
    public String getConfig() { return config; }
    public User getRequestedBy() { return requestedBy; }

    public void setId(String id) { this.id = id; }
    public void setRequestedBy(User user) { this.requestedBy = user; }
}

