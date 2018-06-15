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

    public InstrumentType setupNewInstrumentType2() {
        InstrumentType instrumentType2 = new InstrumentType("Amp");
        instrumentTypeDao.add(instrumentType2);
        return instrumentType2;
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
    public void getAll_2() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        InstrumentType testInstrumentType2 = setupNewInstrumentType2();
        assertEquals(2, instrumentTypeDao.getAll().size());
    }

    @Test
    public void findById() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        InstrumentType testInstrumentType2 = setupNewInstrumentType2();
        assertEquals(testInstrumentType.getName(), instrumentTypeDao.findById(testInstrumentType.getId()).getName());
    }

//    @Test
//    public void update() {
//    }
//
//    @Test
//    public void deleteById() {
//    }
}