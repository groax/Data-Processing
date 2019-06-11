package P3.java.Reiziger;

import P3.java.OVChipkaart.OVChipkaart;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
    private int reizigerNummer;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date gbdatum;
    private ArrayList<OVChipkaart> kaarten = new ArrayList<OVChipkaart>();

    public Reiziger(String voorletters, String tussenvoegsel, String achternaam, int reizigerNummer, Date gbdatum) {
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.reizigerNummer = reizigerNummer;
        this.gbdatum = gbdatum;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public int getReizigerNummer() {
        return reizigerNummer;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public void setAchternaam(String naam) {
        this.achternaam = naam;
    }

    public void setTussenvoegsel(String naam) {
        this.tussenvoegsel = naam;
    }

    public void setReizigerNummer(int nummer) {
        this.reizigerNummer = nummer;
    }

    public Date getGBdatum() {
        return gbdatum;
    }

    public void setKaarten(ArrayList<OVChipkaart> kaarten) {
        this.kaarten = kaarten;
    }

    public void addKaart(OVChipkaart kaart) {
        this.kaarten.add(kaart);
    }

    public ArrayList<OVChipkaart> getKaarten() {
        return this.kaarten;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public String toString() {
        if (this.getTussenvoegsel() != null) {
            return this.getVoorletters() + " " + this.getTussenvoegsel() + " " + this.getAchternaam();
        }
        return this.getVoorletters() + " " + this.getAchternaam();
    }
}
