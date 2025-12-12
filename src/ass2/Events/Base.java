package src.ass2.Events;


import src.ass2.StrategyPattren.EType;

public class Base extends Event {

    public Base(EType type, String payload) {
        super(type, payload);
    }

    @Override
    public String process(String data) {
        return data;
    }
}