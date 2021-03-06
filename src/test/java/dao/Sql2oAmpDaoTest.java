package dao;

import models.Amp;
import models.Instrument;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oAmpDaoTest {
    private static Connection conn;
    private static Sql2oAmpDao ampDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/equiplist_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        ampDao = new Sql2oAmpDao(sql2o);
        conn = sql2o.open();
    }

    public Amp setupNewAmp() {
        Amp amp = new Amp ("Gibson", "Les Paul Custom", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        ampDao.add(amp);
        return amp;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        ampDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

//    @Test
//    public void addAmpSetsId_1() {
//        Amp testAmp = setupNewAmp();
//        assertEquals(1, testAmp.getId());
//    }

    @Test
    public void addAmpSetsWishlist_false() {
        Amp testAmp = setupNewAmp();
        assertEquals(false, testAmp.getWishlist());
    }

    @Test
    public void addAmpSetsManufacturer_gibson() {
        Amp testAmp = setupNewAmp();
        assertEquals("Gibson", testAmp.getManufacturer());
    }

    @Test
    public void addAmpSetsColor_ebony() {
        Amp testAmp = setupNewAmp();
        assertEquals("Pine", testAmp.getCabinetWood());
    }

    @Test
    public void getAllAmps_2() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = setupNewAmp();
        assertEquals(2, ampDao.getAllAmps().size());
    }

    @Test
    public void getAllAmpsInCollection_1() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = new Amp ("Fender", "Bassman", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        testAmp2.setWishlist(true);
        ampDao.add(testAmp2);
        assertEquals(1, ampDao.getAllAmpsInCollection().size());
    }

    @Test
    public void getAllAmpsInWishlist_1() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = new Amp ("Fender", "Bassman", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        testAmp2.setWishlist(true);
        ampDao.add(testAmp2);
        assertEquals(1, ampDao.getAllAmpsInWishlist().size());
    }

    @Test
    public void updateAmp_1() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = new Amp ("Fender", "Bassman", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, true, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        ampDao.update(testAmp.getId(), testAmp2);
        assertEquals(1, ampDao.getAllAmpsInWishlist().size());
    }

    @Test
    public void deleteAmp_1() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = new Amp ("Fender", "Bassman", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        ampDao.add(testAmp2);
        ampDao.deleteById(testAmp.getId());
        assertEquals(1, ampDao.getAllAmpsInCollection().size());
    }

    @Test
    public void search_1() {
        Amp testAmp = setupNewAmp();
        Amp testAmp2 = new Amp ("Fender", "Bassman", "USA", "xxx", "old",1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6, 4 12AX7", "None", "None", "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", "Fender Medium Tilt Legs", "rubber", "volume, treble, bass", "N/A");
        ampDao.add(testAmp2);
        assertEquals(1, ampDao.search("Fender").size());
    }
}