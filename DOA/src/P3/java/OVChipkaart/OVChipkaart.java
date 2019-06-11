package P3.java.OVChipkaart;


import P3.java.Producten.Product;
import P3.java.Reiziger.Reiziger;

import java.sql.Date;
import java.util.ArrayList;

public class OVChipkaart {
    private int kaartnummer;
    private Date geldigtot;
    private int klasse;
    private double saldo;
    private Reiziger reiziger;
    private ArrayList<Product> producten = new ArrayList<Product>();

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

    public ArrayList<Product> getProducten() {
        return this.producten;
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
