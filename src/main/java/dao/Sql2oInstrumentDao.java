package dao;

import models.Instrument;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oInstrumentDao implements InstrumentDao {
    private final Sql2o sql2o;
    public Sql2oInstrumentDao(Sql2o sql2o) { this.sql2o = sql2o; }
}
