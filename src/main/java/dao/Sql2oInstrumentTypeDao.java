package dao;

import models.InstrumentType;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oInstrumentTypeDao implements InstrumentTypeDao{
    private final Sql2o sql2o;
    public Sql2oInstrumentTypeDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(InstrumentType instrumentType) {
        String sql = "INSERT INTO instrumentTypes (name) VALUES (:name)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(instrumentType)
                    .executeUpdate()
                    .getKey();
            instrumentType.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<InstrumentType> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM instrumentTypes")
                    .executeAndFetch(InstrumentType.class);
        }
    }

    @Override
    public InstrumentType findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void deleteById(int id) {

    }
}
