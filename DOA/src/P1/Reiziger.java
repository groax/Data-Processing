package P1;

import java.sql.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;

    public Reiziger() {

    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGbdatum() {
        return this.gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }
}
