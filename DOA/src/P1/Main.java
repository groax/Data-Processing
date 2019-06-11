package P1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaompl reizigerDao = new ReizigerOracleDaompl();

        Reiziger reiziger = new Reiziger();
        reiziger.setNaam("Rick");

        Date date = Date.valueOf("1991-03-12");
        reiziger.setGbdatum(date);

        reizigerDao.save(reiziger);

        System.out.println(reiziger.getNaam());
        System.out.println(reiziger.getGbdatum());

//        List<Reiziger> lijst = reizigerDao.findByGBdatum("1991-03-12");

//        System.out.println(lijst);

    }
}
