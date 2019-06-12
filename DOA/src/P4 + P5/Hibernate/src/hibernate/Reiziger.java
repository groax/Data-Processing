package hibernate;



import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reiziger")
public class Reiziger {
    @Id
    @Column(name = "reizigerid")
    private int reizigerNummer;

    @Column(name = "voorletters")
    private String voornaam;

    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;

    @Column(name = "achternaam")
    private String achternaam;

    @Column(name = "gebortedatum")
    private Date gbdatum;

    public List<OVChipkaart> getKaarten() {
        return kaarten;
    }

    public void setKaarten(List<OVChipkaart> kaarten) {
        this.kaarten = kaarten;
    }

    @OneToMany(mappedBy = "reiziger", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<OVChipkaart> kaarten;


    public Reiziger() {

    }


    public Reiziger(String voornaam, String tussenvoegsel, String achternaam, int reizigerNummer, Date gbdatum) {
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.reizigerNummer = reizigerNummer;
        this.gbdatum = gbdatum;
    }

    public String getVoornaam() {
        return voornaam;
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

    public void setVoornaam(String naam) {
        this.voornaam = naam;
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

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }


    public String toString() {
        return this.voornaam;
    }
}
