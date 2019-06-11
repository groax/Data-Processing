package P3.java.Producten;

import java.util.ArrayList;

public class Product
{
    private int productnummer;
    private String productNaam;
    private String beschrijving;
    private double prijs;
    private ArrayList<Integer> ov;

    public Product(int productnummer, String productNaam, String beschrijving, double prijs) {
        this.productnummer = productnummer;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.ov = new ArrayList<Integer>();
    }

    public void setOvChipkaartnummers(ArrayList<Integer> list) {
        this.ov = list;
    }

    public int getProductnummer() {
        return productnummer;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setProductnummer(int productnummer) {
        this.productnummer = productnummer;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString() {
        return this.productnummer + ": " + this.productNaam + ": " + this.beschrijving + " alle ovchipkaarten verbonden: " + this.ov;
    }
}
