package src.ass2.StrategyPattren;

import src.ass2.Events.Event;

public class SecurityEType extends EType {
    public SecurityEType() {
        super("SECURITY");
    }

    @Override
    public void run(Event e) {
        // duplicate security handling across code
        System.out.println("[SECURITY] extra analysis for " + e.getId());
        // directly send to security monitor (hard-coded)
        System.out.println("[SecurityMonitor] alert for " + e.getId());
    }
}
