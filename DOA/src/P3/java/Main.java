package P3.java;

import P3.java.OVChipkaart.OVChipkaartSQLiteDaoImpl;
import P3.java.Reiziger.Reiziger;
import P3.java.Reiziger.ReizigerSQLiteDaolmpl;
import P3.recources.Helpers;
import P3.recources.SQLiteJDBCDriverConnection;

public class Main extends SQLiteJDBCDriverConnection
{
    public static void main(String[] args)
    {
        ReizigerSQLiteDaolmpl reizigers = new ReizigerSQLiteDaolmpl();
        OVChipkaartSQLiteDaoImpl ovchipkaarten = new OVChipkaartSQLiteDaoImpl();

        ovchipkaarten.findAll().forEach(ov -> {
//            System.out.println(ov);
//            System.out.println(ov.getReiziger());

//            ov.get

//
            ov.getProducten().forEach(p -> {
                System.out.println(p);
            });
        });

    }
}
