package dao;

import models.Pedal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.*;

public class Sql2oPedalDaoTest {
    private Connection conn;
    private Sql2oPedalDao pedalDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        pedalDao = new Sql2oPedalDao(sql2o);
        conn = sql2o.open();
    }

    public Pedal setupNewPedal() {
        Pedal pedal = new Pedal ("Wampler", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        pedalDao.add(pedal);
        return pedal;
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addPedalSetsId_1() {
        Pedal testPedal = setupNewPedal();
        assertEquals(1, testPedal.getId());
    }

    @Test
    public void addPedalSetsWishlist_false() {
        Pedal testPedal = setupNewPedal();
        assertEquals(false, testPedal.getWishlist());
    }

    @Test
    public void addPedalSetsManufacturer_gibson() {
        Pedal testPedal = setupNewPedal();
        assertEquals("Wampler", testPedal.getManufacturer());
    }

    @Test
    public void addPedalSetsType_Overdrive() {
        Pedal testPedal = setupNewPedal();
        assertEquals("Overdrive", testPedal.getType());
    }

    @Test
    public void getAllPedals_2() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = setupNewPedal();
        assertEquals(2, pedalDao.getAllPedals().size());
    }

    @Test
    public void getAllPedalsInCollection_1() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = new Pedal ("Wampler", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        testPedal2.setWishlist(true);
        pedalDao.add(testPedal2);
        assertEquals(1, pedalDao.getAllPedalsInCollection().size());
    }

    @Test
    public void getAllPedalsInWishlist_1() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = new Pedal ("Wampler", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        testPedal2.setWishlist(true);
        pedalDao.add(testPedal2);
        assertEquals(1, pedalDao.getAllPedalsInWishlist().size());
    }

    @Test
    public void updatePedal_1() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = new Pedal ("Wampler", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, true, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        pedalDao.update(testPedal.getId(), testPedal2);
        assertEquals(1, pedalDao.getAllPedalsInWishlist().size());
    }

    @Test
    public void deletePedal_1() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = new Pedal ("Wampler", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        pedalDao.add(testPedal2);
        pedalDao.delteteById(testPedal.getId());
        assertEquals(1, pedalDao.getAllPedalsInCollection().size());
    }

    @Test
    public void search_1() {
        Pedal testPedal = setupNewPedal();
        Pedal testPedal2 = new Pedal ("Fender", "Tumnus", "USA", "xxx", "old",2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
        pedalDao.add(testPedal2);
        assertEquals(1, pedalDao.search("Fender").size());
    }
}