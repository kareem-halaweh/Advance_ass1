package src.ass2.StrategyPattren;


import src.ass2.Events.Event;

public class UserEType extends EType {
    public UserEType() {
        super("USER");
    }

    @Override
    public void run(Event e) {
        System.out.println("[USER] user-specific step for " + e.getId());
    }
}