package src.ass2.Events;

import src.ass2.StrategyPattren.EType;

public abstract class Event {
    private EType type; // "USER","SYSTEM","SECURITY"
    private String payload;
    private String metadata;
    private String id;

    public Event(EType type, String payload) {
        this.type = type; this.payload = payload;
    }

    public String getTypeName() {
        return type.getName();
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String process(String data);

    public void runTypeEvents(){
        type.run(this);
    }
}