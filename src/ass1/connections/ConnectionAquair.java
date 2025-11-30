package src.ass1.connections;

public interface ConnectionAquair {
    Connection acquire();
    void release(Connection c);
}
