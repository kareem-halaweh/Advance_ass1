package src.ass2.StrategyPattren;

import src.ass2.Events.Event;

public class SystemEType extends EType {
    public SystemEType() {
        super("SYSTEM");
    }

    @Override
    public void run(Event e) {
        System.out.println("[SYSTEM] system audit log " + e.getId());
    }
}