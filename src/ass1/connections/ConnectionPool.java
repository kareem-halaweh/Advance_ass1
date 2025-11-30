package src.ass1.connections;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements ConnectionAquair {
    private int Counter = 0;
    private static final int MAX = 10; // allowed max, but not enforced as pool reuse
    private static final List<Connection> pool=new ArrayList<>(MAX);

    public void createConnection() {
        if (pool.size() < MAX) {
            Counter++;
            pool.add(new Connection("PoolConn-"+Counter));

        }
    }

    @Override
    public Connection acquire() {
        synchronized (ConnectionPool.class) {
            if (pool.isEmpty()) {
                this.createConnection();
            }
            Connection conn = pool.remove(0);
            System.out.println("[Pool] Acquired " + conn.getId());
            return conn;
        }
    }
    @Override
    public void release(Connection c) {
        if (c == null) return;

        synchronized (ConnectionPool.class) {
            if (pool.size() < MAX) {
                pool.add(c);
                System.out.println("[Pool] Released " + c.getId());
            } else {
                System.out.println("[Pool] Pool Full " + c.getId() );
            }
        }
    }
}