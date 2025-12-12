package src.ass2.Decorator;


import src.ass2.Events.Event;

public class CompressDecoratorEvent extends EventDecorator {
    public CompressDecoratorEvent(Event e) {
        super(e);
    }
    @Override
    public String process(String data) {
        data = "CMP(" + data + ")";
        return data;
    }
}