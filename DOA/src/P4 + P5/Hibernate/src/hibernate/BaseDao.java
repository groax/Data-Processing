package hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface BaseDao<T> {
    List<T> findAll()  throws SQLException, ParseException;
    T save(T t) throws SQLException, ParseException;
    T update(T t) throws SQLException, ParseException;
    T delete(T t) throws SQLException, ParseException;
}
