package src.ass2.observer;


import src.ass2.Events.Event;

public class Logger implements Listener {
    public void log(Event event) {
        System.out.println("[LOG] Processed event " + event.getId() + " type " + event.getTypeName());
    }

    @Override
    public void update(Event e) {
        this.log(e);
    }


}