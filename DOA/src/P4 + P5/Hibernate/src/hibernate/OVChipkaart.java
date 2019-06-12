package hibernate;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OV_CHIPKAART")
public class OVChipkaart {

    @Id
    @Column(name="kaartnummer")
    private int kaartnummer;

    @Column(name = "geldigtot")
    private Date geldigtot;

    @Column(name = "klasse")
    private int klasse;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "reizigerid")
    private Reiziger reiziger;

    //private ArrayList<Product> producten = new ArrayList<Product>();

    public OVChipkaart() {

    }

    public OVChipkaart(int kaarnummer, Date geldigtot, int klasse, double saldo, Reiziger r) {
        this.kaartnummer = kaarnummer;
        this.geldigtot = geldigtot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = r;
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

    //public ArrayList<Product> getProducten() {
//        return this.producten;
//    }

 //   public void setProducten(ArrayList<Product> producten) {
//        this.producten = producten;
//    }
//    public void addProduct(Product product) {
//        if(!this.producten.contains(product)) {
//            this.producten.add(product);
//        }
//
//        return;
//    }


    public String toString() {
        String s = "";
        s+= kaartnummer + ": " + saldo + " van: " + reiziger.getReizigerNummer();
        return s;
    }
}
