package src.ass2.Decorator;

import src.ass2.Events.Event;


public abstract class EventDecorator extends Event {
    protected final Event e;
    public EventDecorator(Event e) {
        this.e = e;
        super(e.getType(),e.getPayload());
    }

    @Override
    public abstract String process(String data);
}