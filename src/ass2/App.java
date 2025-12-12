package src.ass2;


import src.ass2.Data.Database;
import src.ass2.Decorator.CompressDecoratorEvent;
import src.ass2.Decorator.EncryptDecoratorEvent;
import src.ass2.Events.Base;
import src.ass2.Events.Event;
import src.ass2.Events.EventProcessor;
import src.ass2.observer.Dashboard;
import src.ass2.observer.Logger;
import src.ass2.Decorator.AddMetadataDecoratorEvent;
import src.ass2.StrategyPattren.SecurityEType;
import src.ass2.StrategyPattren.UserEType;

public class App {

    public static void main(String[] args) {
        EventProcessor eventProcessor = new EventProcessor(new Database(), new Dashboard(), new Logger());

        Event e1 = new Base(new UserEType(), "user-click");
        e1.setMetadata("u=42");
        Event m1 = new EncryptDecoratorEvent(e1);
        Event m2 = new AddMetadataDecoratorEvent(m1);

        eventProcessor.process(m2);

        Event e2 = new Base(new SecurityEType(), "failed-login");
        Event m3 = new CompressDecoratorEvent(e2);
        eventProcessor.process(m3);
    }
}