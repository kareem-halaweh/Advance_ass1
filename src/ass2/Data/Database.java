package src.ass2.Data;


public class Database implements DataConnenter {
    public void save(String id, String data) {
        System.out.println("[DB] Saved " + id + ":" + data);
    }
}