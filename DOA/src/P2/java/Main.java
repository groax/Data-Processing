package P2.java;

import P2.java.OVChipkaart.OVChipkaartSQLiteDaoImpl;
import P2.java.Reiziger.Reiziger;
import P2.java.Reiziger.ReizigerSQLiteDaolmpl;
import P2.recources.Helpers;
import P2.recources.SQLiteJDBCDriverConnection;

public class Main extends SQLiteJDBCDriverConnection {
    public static void main(String[] args) {
        ReizigerSQLiteDaolmpl reizigers = new ReizigerSQLiteDaolmpl();
        OVChipkaartSQLiteDaoImpl ovchipkaarten = new OVChipkaartSQLiteDaoImpl();

        reizigers.findAll();
        reizigers.findByGBdatum("17-09-02");

        System.out.println(reizigers.findAll().get(2).getKaarten());

        Reiziger rick = new Reiziger("R", "", "Holtman", 6, new Helpers().dateFromString("12-03-19", "dd-MM-YY"));
        reizigers.save(rick);

        Reiziger mark = new Reiziger("M", "", "Selet", 6, new Helpers().dateFromString("12-03-19", "dd-MM-YY"));
        reizigers.update(mark);
        reizigers.delete(mark);


        ovchipkaarten.findAll().forEach(ov -> {
            System.out.println(
                    ov.getKaartnummer() + " | " + ov.getReiziger()
            );
        });

        Reiziger reiziger = reizigers.findByID(2);
        System.out.println(reiziger + ":");

        reiziger.getKaarten().forEach(ov -> {
            System.out.println(
                    ov.getKaartnummer()
            );
        });

        reizigers.closeConnection();
    }
}
