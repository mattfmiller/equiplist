package dao;

import models.InstrumentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oInstrumentTypeDaoTest {
    private Connection conn;
    private Sql2oInstrumentTypeDao instrumentTypeDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        instrumentTypeDao = new Sql2oInstrumentTypeDao(sql2o);
        conn = sql2o.open();
    }

    public InstrumentType setupNewInstrumentType() {
        InstrumentType instrumentType = new InstrumentType("Guitar");
        instrumentTypeDao.add(instrumentType);
        return instrumentType;
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingInstrumentTypeSetsId() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        assertEquals(1, testInstrumentType.getId());
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}