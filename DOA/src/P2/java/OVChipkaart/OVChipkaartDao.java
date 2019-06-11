package P2.java.OVChipkaart;


import P2.java.Reiziger.Reiziger;

import java.util.ArrayList;

public interface OVChipkaartDao {
    public ArrayList<OVChipkaart> findAll();
    public ArrayList<OVChipkaart> findByReiziger(Reiziger r);
    public OVChipkaart save(OVChipkaart ov);
    public OVChipkaart update(OVChipkaart ov);
    public OVChipkaart delete(OVChipkaart ov);
    public ArrayList<OVChipkaart> findByOvNumber(int Number);
}
