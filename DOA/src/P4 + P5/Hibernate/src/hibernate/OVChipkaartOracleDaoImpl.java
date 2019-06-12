package hibernate;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {

    @Override
    public List<OVChipkaart> findAll() throws SQLException, ParseException {
        Session s = this.getConnection();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<OVChipkaart> q = cb.createQuery(OVChipkaart.class);
        Root<OVChipkaart> c = q.from(OVChipkaart.class);

        q.select(c);

        TypedQuery<OVChipkaart> query = s.createQuery(q);

        List<OVChipkaart> results = query.getResultList();

        return results;
    }

    @Override
    public OVChipkaart save(OVChipkaart ovChipkaart) throws SQLException, ParseException {
        Session s = this.getConnection();
        s.beginTransaction();
        s.save(ovChipkaart);
        s.getTransaction().commit();
        return ovChipkaart;
    }

    @Override
    public OVChipkaart update(OVChipkaart ovChipkaart) throws SQLException, ParseException {
        Session s = this.getConnection();
        s.beginTransaction();
        s.update(ovChipkaart);
        s.getTransaction().commit();
        return ovChipkaart;
    }

    @Override
    public OVChipkaart delete(OVChipkaart ovChipkaart) throws SQLException, ParseException {
        Session s = this.getConnection();
        s.beginTransaction();
        s.delete(ovChipkaart);
        s.getTransaction().commit();
        return ovChipkaart;
    }
}
