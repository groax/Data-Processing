package P3.java.Producten;


import P2.recources.SQLiteJDBCDriverConnection;
import P3.java.OVChipkaart.OVChipkaart;
import P3.java.OVChipkaart.OVChipkaartSQLiteDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductSQLiteDaoImpl extends SQLiteJDBCDriverConnection implements ProductDao {
    private OVChipkaartSQLiteDaoImpl ovchip;


    @Override
    public ArrayList<Product> findAll() {
        this.ovchip = new OVChipkaartSQLiteDaoImpl();
        ArrayList<Product> producten = new ArrayList<Product>();

        try {
            PreparedStatement prepStatement = this.connect().prepareStatement("SELECT * FROM PRODUCT");
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Product p = new Product(
                        result.getInt("productnummer"),
                        result.getString("productnaam"),
                        result.getString("beschrijving"),
                        result.getDouble("prijs")
                );

                p.setOvChipkaartnummers(ovchip.getKaartnummersByProduct(p));
                producten.add(p);
            }

            return producten;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return producten;
    }

    @Override
    public ArrayList<Product> findByOVChipkaartID(OVChipkaart kaart) {
        ArrayList<Product> producten = new ArrayList<Product>();
        this.ovchip = new OVChipkaartSQLiteDaoImpl();

        try {
            PreparedStatement prepStatement = this.connect().prepareStatement("SELECT P.* FROM OV_CHIPKAART_PRODUCT OCP INNER JOIN PRODUCT P on OCP.PRODUCTNUMMER = P.PRODUCTNUMMER WHERE ocp.kaartnummer = ?");
            prepStatement.setInt(1, kaart.getKaartnummer());
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Product p = new Product(result.getInt("productnummer"), result.getString("productnaam"), result.getString("beschrijving"), result.getDouble("prijs"));
                p.setOvChipkaartnummers(ovchip.getKaartnummersByProduct(p));
                producten.add(p);
            }

            return producten;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return producten;
    }

    @Override
    public Product save(Product p) {
        return null;
    }

    @Override
    public Product update(Product p) {
        return null;
    }

    @Override
    public Product delete(Product p) {
        return null;
    }


}
