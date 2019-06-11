package P3.java.OVChipkaart;

import P3.java.Producten.Product;
import P3.java.Reiziger.Reiziger;
import P3.java.Reiziger.ReizigerSQLiteDaolmpl;
import P3.recources.Helpers;
import P3.recources.SQLiteJDBCDriverConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OVChipkaartSQLiteDaoImpl extends SQLiteJDBCDriverConnection implements OVChipkaartDao {

    @Override
    public ArrayList<OVChipkaart> findAll() {
        ArrayList<OVChipkaart> ovChipkaarten = new ArrayList<OVChipkaart>();

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("select * from 'OV-Chipkaart'");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ReizigerSQLiteDaolmpl reiziger = new ReizigerSQLiteDaolmpl();

                OVChipkaart ov = new OVChipkaart(
                        rs.getInt("Kaartnummer"),
                        new Helpers().dateFromString(rs.getString("geldigTot"), "dd-MM-YY"),
                        rs.getInt("klasse"),
                        rs.getDouble("saldo"),
                        reiziger.findByID(rs.getInt("reizigerID"))
                );

                ovChipkaarten.add(ov);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovChipkaarten;
    }

    @Override
    public ArrayList<OVChipkaart> findByOvNumber(int Number) {

        return null;
//        ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();
//
//        try {
//            Connection conn = this.connect();
//            PreparedStatement pstm = conn.prepareStatement(" SELECT * FROM 'OV-Chipkaart' WHERE Kaartnummer = ?");
//            pstm.setInt(1, Number);
//            ResultSet rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                OVChipkaart ov = new OVChipkaart(
//                        rs.getInt("kaartnummer"),
//                        new Helpers().dateFromString(rs.getString("geldigtot"), "dd-MM-YY"),
//                        rs.getInt("klasse"),
//                        rs.getFloat("saldo"), ""
//                );
//                ovs.add(ov);
//            }
//
//            return ovs;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return ovs;
    }

    @Override
    public ArrayList<OVChipkaart> findByReiziger(Reiziger reiziger) {
        ArrayList<OVChipkaart> ovChipkaarten = new ArrayList<OVChipkaart>();

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM 'OV-CHIPKAART' WHERE reizigerid = ?");
            pstmt.setInt(1, reiziger.getReizigerNummer());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OVChipkaart ov = new OVChipkaart(
                        rs.getInt("kaartnummer"),
                        new Helpers().dateFromString(rs.getString("geldigtot"), "dd-MM-YY"),
                        rs.getInt("klasse"),
                        rs.getFloat("saldo"),
                        reiziger
                );
                ovChipkaarten.add(ov);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovChipkaarten;
    }

    @Override
    public OVChipkaart save(OVChipkaart ovChipkaart) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO 'OV-CHIPKAART' VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, ovChipkaart.getKaartnummer());
            pstmt.setString(2, ovChipkaart.getGeldigtot().toString());
            pstmt.setInt(3, ovChipkaart.getKlasse());
            pstmt.setDouble(4, ovChipkaart.getSaldo());
            pstmt.setInt(5, ovChipkaart.getReiziger().getReizigerNummer());

            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ovChipkaart;
    }

    @Override
    public OVChipkaart update(OVChipkaart ovChipkaart) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE 'OV-CHIPKAART' SET GELDIGTOT = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?");
            pstmt.setString(1, ovChipkaart.getGeldigtot().toString());
            pstmt.setInt(2, ovChipkaart.getKlasse());
            pstmt.setDouble(3, ovChipkaart.getSaldo());
            pstmt.setInt(4, ovChipkaart.getReiziger().getReizigerNummer());
            pstmt.setInt(5, ovChipkaart.getKaartnummer());

            ResultSet result = pstmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovChipkaart;
    }

    public ArrayList<Integer> getKaartnummersByProduct(Product p) {
        ArrayList<Integer> ovchipnummers = new ArrayList<Integer>();

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT OV_CHIPKAART.* FROM OV_CHIPKAART INNER JOIN OV_CHIPKAART_PRODUCT OCP on OV_CHIPKAART.KAARTNUMMER = OCP.KAARTNUMMER WHERE OCP.PRODUCTNUMMER = ?");

            pstmt.setInt(1, p.getProductnummer());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                ovchipnummers.add(rs.getInt("kaartnummer"));
            }

            return ovchipnummers;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovchipnummers;
    }

    @Override
    public OVChipkaart delete(OVChipkaart ovChipkaart) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM 'OV-CHIPKAART' WHERE kaartnummer = ?");

            ResultSet result = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovChipkaart;
    }
}
