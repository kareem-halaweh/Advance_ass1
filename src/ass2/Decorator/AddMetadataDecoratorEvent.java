package src.ass2.Decorator;


import src.ass2.Events.Event;

public class AddMetadataDecoratorEvent extends EventDecorator {

    public AddMetadataDecoratorEvent(Event e) {
        super(e);
    }

    @Override
    public String process(String data) {
        data = e.process(data);
        data = "META(" + e.getMetadata() + ")::" + data;
        return data;
    }
}