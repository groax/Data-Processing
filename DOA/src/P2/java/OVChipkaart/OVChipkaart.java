package P2.java.OVChipkaart;


import P2.java.Reiziger.Reiziger;

import java.sql.Date;

public class OVChipkaart {
    private int kaartnummer;
    private Date geldigtot;
    private int klasse;
    private double saldo;
    private Reiziger reiziger;

    public OVChipkaart(int kaarnummer, Date geldigtot, int klasse, double saldo, Reiziger reiziger) {
        this.kaartnummer = kaarnummer;
        this.geldigtot = geldigtot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public Date getGeldigtot() {
        return geldigtot;
    }

    public int getKlasse() {
        return klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setSaldo(double nieuwsaldo) {
        this.saldo = nieuwsaldo;
    }

    public String toString() {
        String s = "";
        s+= kaartnummer + ": " + saldo + " van: " + reiziger.getReizigerNummer();
        return s;
    }
}
