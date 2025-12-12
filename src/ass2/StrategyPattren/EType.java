package src.ass2.StrategyPattren;

import src.ass2.Events.Event;

public abstract class EType {
    String name;
    protected EType(String name){this.name=name;}
    public abstract void run(Event e);
    public String getName(){return name;}
}