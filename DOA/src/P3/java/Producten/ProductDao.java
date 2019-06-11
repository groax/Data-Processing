package P3.java.Producten;

import P3.java.OVChipkaart.OVChipkaart;

import java.util.ArrayList;

public interface ProductDao
{
    public ArrayList<Product> findAll();
    public ArrayList<Product> findByOVChipkaartID(OVChipkaart kaart);
    public Product save(Product p);
    public Product update(Product p);
    public Product delete(Product p);
}
