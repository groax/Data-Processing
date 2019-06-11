package P3.java.Reiziger;

import java.util.ArrayList;

public interface ReizigerDao {
    public ArrayList<Reiziger> findAll();
    public ArrayList<Reiziger> findByGBdatum(String GBdatum);
    public Reiziger save(Reiziger reiziger);
    public Reiziger update(Reiziger reiziger);
    public Reiziger delete(Reiziger reiziger);
    public void closeConnection();
}