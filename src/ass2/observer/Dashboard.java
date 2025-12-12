package src.ass2.observer;


import src.ass2.Events.Event;

public class Dashboard implements Listener {
    public void updateMetrics(Event e) {
        System.out.println(String.format("[Dashboard] metrics updated for %s, payload: %s", e.getId() , e.getPayload()));
    }

    @Override
    public void update(Event e) {
        this.updateMetrics(e);
    }


}