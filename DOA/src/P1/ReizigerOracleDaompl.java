package P1;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class ReizigerOracleDaompl implements ReizigerDao {
    private ArrayList<Reiziger> Reizigers = new ArrayList<Reiziger>();

    @Override
    public List<Reiziger> findAll() {
        return this.Reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum) {
        Date gbDate = Date.valueOf(GBdatum);
        for (Reiziger reiziger : Reizigers) {
            if (reiziger.getGbdatum().equals(gbDate)) {
                Reizigers.add(reiziger);
            }
        }
        return Reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        Reizigers.add(reiziger);

        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        if(Reizigers.contains(reiziger)) {
            int index = Reizigers.indexOf(reiziger);
            Reizigers.set(index, reiziger);
        }

        return null;
    }

    @Override
    public Reiziger delete(Reiziger reiziger) {
        Reizigers.remove(reiziger);

        return null;
    }
}
