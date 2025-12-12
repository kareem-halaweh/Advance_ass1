package src.ass2.Events;

import src.ass2.Data.DataConnenter;
import src.ass2.observer.Dashboard;
import src.ass2.observer.Logger;
import src.ass2.observer.Observer;

public class EventProcessor {

    private final DataConnenter database;
    private final Observer notifier= new Observer();

    public EventProcessor(DataConnenter database, Dashboard dashboard, Logger logger) {
        this.database = database;
        notifier.subscribe(dashboard);
        notifier.subscribe(logger);
    }

    public void process(Event e) {
        if (e.getPayload() == null || e.getPayload().isEmpty()) {
            System.out.println("Invalid event");
            return;
        }

        notifier.notifyListeners(e);

        String data = e.getPayload();
        data = e.process(data);

        e.setId(System.currentTimeMillis() + "-" + Math.abs(data.hashCode()));
        database.save(e.getId(), data);

        e.runTypeEvents();
    }
}