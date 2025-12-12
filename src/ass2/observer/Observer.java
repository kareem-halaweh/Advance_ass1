package src.ass2.observer;



import src.ass2.Events.Event;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    private final List<Listener> listenerlist=new ArrayList<Listener>();
    public void subscribe(Listener l){
        listenerlist.add(l);
    }
    public void unSubscribe(Listener l){
        listenerlist.remove(l);
    }
    public void notifyListeners(Event e){
        for(Listener l:listenerlist){
            l.update(e);
        }
    }
}