package P2.java.Reiziger;

import P2.java.OVChipkaart.OVChipkaartSQLiteDaoImpl;
import P2.recources.Helpers;
import P2.recources.SQLiteJDBCDriverConnection;

import java.sql.*;
import java.util.ArrayList;

public class ReizigerSQLiteDaolmpl extends SQLiteJDBCDriverConnection implements ReizigerDao {
    private OVChipkaartSQLiteDaoImpl ovChip;
//    private Connection conn;

    public ReizigerSQLiteDaolmpl() {
        this.ovChip = new OVChipkaartSQLiteDaoImpl();
    }

    @Override
    public ArrayList<Reiziger> findAll() {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Reiziger")) {

            // loop through the result set
            resultReiziger(reizigers, rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reizigers;
    }

    @Override
    public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIZIGER WHERE GEBOORTEDATUM = ?");
            pstmt.setString(1, GBdatum);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            resultReiziger(reizigers, rs);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reizigers;
    }

    public Reiziger findByID(int reizigerID) {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIZIGER WHERE reizigerID = ?");
            pstmt.setInt(1, reizigerID);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            Reiziger reiziger = new Reiziger(
                    rs.getString("voorletters"),
                    rs.getString("tussenvoegsel"),
                    rs.getString("achternaam"),
                    rs.getInt("reizigerID"),
                    new Helpers().dateFromString(rs.getString("geboortedatum"), "dd-MM-YY")
            );

            reiziger.setKaarten(this.ovChip.findByReiziger(reiziger));

            return reiziger;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO REIZIGER (REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM, GEBOORTEDATUM) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, reiziger.getReizigerNummer());
            pstmt.setString(2, reiziger.getVoorletters());
            pstmt.setString(3, reiziger.getTussenvoegsel());
            pstmt.setString(4, reiziger.getAchternaam());
            pstmt.setString(5, reiziger.getGBdatum().toString());
            int rs = pstmt.executeUpdate();

            if (rs == 1) {
                System.out.println("Saved.");
            } else {
                System.out.println("Not saved.");
            }

            reiziger.getKaarten().forEach(k -> this.ovChip.save(k));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE REIZIGER SET VOORLETTERS = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ?, GEBOORTEDATUM = ? WHERE REIZIGERID = ?");
            pstmt.setString(1, reiziger.getVoorletters());
            pstmt.setString(2, reiziger.getTussenvoegsel());
            pstmt.setString(3, reiziger.getAchternaam());
            pstmt.setString(4, reiziger.getGBdatum().toString());
            pstmt.setInt(5, reiziger.getReizigerNummer());
            int rs = pstmt.executeUpdate();

            if (rs == 1) {
                System.out.println("Updated.");
            } else {
                System.out.println("Not updated.");
            }

            reiziger.getKaarten().forEach(k -> this.ovChip.update(k));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }

    @Override
    public Reiziger delete(Reiziger reiziger) {
        try {
            Connection conn = this.connect();
            PreparedStatement pstsm = conn.prepareStatement("DELETE FROM REIZIGER WHERE REIZIGERID = ?");
            pstsm.setInt(1, reiziger.getReizigerNummer());
            int rs = pstsm.executeUpdate();

            if (rs == 1) {
                System.out.println("Deleted.");
            } else {
                System.out.println("Not deleted.");
            }

            reiziger.getKaarten().forEach(k -> this.ovChip.delete(k));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }

    @Override
    public void closeConnection() {
        Connection conn = this.connect();

        try {
            if (conn != null) {
                conn.close();
                System.out.println("\nBye!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void resultReiziger(ArrayList<Reiziger> reizigers, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Reiziger reiziger = new Reiziger(
                    rs.getString("voorletters"),
                    rs.getString("tussenvoegsel"),
                    rs.getString("achternaam"),
                    rs.getInt("reizigerID"),
                    new Helpers().dateFromString(rs.getString("geboortedatum"), "dd-MM-yy")
            );

            reiziger.setKaarten(this.ovChip.findByReiziger(reiziger));
            reizigers.add(reiziger);
        }
    }
}
