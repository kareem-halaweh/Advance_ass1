package src.ass2.Decorator;


import src.ass2.Events.Event;

public class EncryptDecoratorEvent extends EventDecorator {
    public EncryptDecoratorEvent(Event e) {
        super(e);
    }

    @Override
    public String process(String data) {
        data = "ENC(" + data + ")";
        return data;
    }

}