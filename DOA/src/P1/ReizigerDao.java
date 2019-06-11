package P1;

import java.util.List;

public abstract interface ReizigerDao {
    public List<Reiziger> findAll();

    public List<Reiziger> findByGBdatum(String GBdatum);

    public Reiziger save(Reiziger reiziger);

    public Reiziger update(Reiziger reiziger);

    public Reiziger delete(Reiziger reiziger);
}
