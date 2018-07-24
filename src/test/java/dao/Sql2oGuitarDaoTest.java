package dao;

import models.Guitar;
import models.Instrument;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oGuitarDaoTest {
    private static Connection conn;
    private static Sql2oGuitarDao guitarDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/equiplist_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        guitarDao = new Sql2oGuitarDao(sql2o);
        conn = sql2o.open();
    }

    public Guitar setupNewGuitar() {
        Guitar guitar = new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "Old", 1998, 10.9, "www.test.url", true, false, 1500, 0, "electic guitar", "Mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        guitarDao.add(guitar);
        return guitar;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        guitarDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

//    @Test
//    public void addGuitarSetsId_1() {
//        Guitar testGuitar = setupNewGuitar();
//        assertEquals(1, testGuitar.getId());
//    }

    @Test
    public void addGuitarSetsWishlist_false() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(false, testGuitar.getWishlist());
    }

    @Test
    public void addGuitarSetsManufacturer_gibson() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Gibson", testGuitar.getManufacturer());
    }

    @Test
    public void addGuitarSetsColor_ebony() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Ebony", testGuitar.getColor());
    }

    @Test
    public void getAllGuitars_2() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = setupNewGuitar();
        assertEquals(2, guitarDao.getAllGuitars().size());
    }

    @Test
    public void getAllGuitarsInCollection_1() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "New",1998, 10.9, "www.test.url", true, false, 1500, 0, "electric guitar", "mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        testGuitar2.setWishlist(true);
        guitarDao.add(testGuitar2);
        assertEquals(1, guitarDao.getAllGuitarsInCollection().size());
    }

    @Test
    public void getAllGuitarsInWishlist_1() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "New",1998, 10.9, "www.test.url", true, false, 1500, 0, "electric guitar", "mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        testGuitar2.setWishlist(true);
        guitarDao.add(testGuitar2);
        assertEquals(1, guitarDao.getAllGuitarsInWishlist().size());
    }

    @Test
    public void updateGuitar_1() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "New",1998, 10.9, "www.test.url", true, true, 1500, 0, "electric guitar", "mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        guitarDao.update(testGuitar.getId(), testGuitar2);
        assertEquals(1, guitarDao.getAllGuitarsInWishlist().size());
    }

    @Test
    public void deleteGuitar_1() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "New",1998, 10.9, "www.test.url", true, false, 1500, 0, "electric guitar", "mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        guitarDao.add(testGuitar2);
        guitarDao.deleteById(testGuitar.getId());
        assertEquals(1, guitarDao.getAllGuitarsInCollection().size());
    }

    @Test
    public void search_1() {
        Guitar testGuitar = setupNewGuitar();
        Guitar testGuitar2 = new Guitar ("Fender", "Jaguar", "USA", "xxx", "New",1998, 10.9, "www.test.url", true, false, 1500, 0, "electric guitar", "mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
        guitarDao.add(testGuitar2);
        assertEquals(1, guitarDao.search("Fender").size());
    }
}