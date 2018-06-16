package dao;

import models.Instrument;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oInstrumentDao implements InstrumentDao {
    private final Sql2o sql2o;
    public Sql2oInstrumentDao(Sql2o sql2o) { this.sql2o = sql2o; }

//    @Override
//    public List<Instrument> getAll() {
//        return null;
//    }
//
//    @Override
//    public Instrument findById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Instrument> getAllInstrumentsByInstrumentTypeId() {
//        return null;
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
}
