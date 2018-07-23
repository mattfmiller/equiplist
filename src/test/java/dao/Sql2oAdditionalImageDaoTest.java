package dao;

import models.AdditionalImage;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oAdditionalImageDaoTest {

    private static Sql2oAdditionalImageDao additionalImageDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        additionalImageDao = new Sql2oAdditionalImageDao(sql2o);
        conn = sql2o.open();
    }

    public AdditionalImage setupNewAdditionalImage(){
        return new AdditionalImage("Upgraded Sleeve", 1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        additionalImageDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void add_addingAdditionalImageSetsId() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        int originalIdOfAdditionalImage = testAdditionalImage.getId();
        additionalImageDao.add(testAdditionalImage);
        assertNotEquals(originalIdOfAdditionalImage, testAdditionalImage.getId());
    }

    @Test
    public void getAllByInstrumentId() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        AdditionalImage testAdditionalImage2 = new AdditionalImage("Cool dude", 2);
        AdditionalImage testAdditionalImage3 = new AdditionalImage("whatever", 1);
        additionalImageDao.add(testAdditionalImage);
        additionalImageDao.add(testAdditionalImage2);
        additionalImageDao.add(testAdditionalImage3);
        assertEquals(2, additionalImageDao.getAllByInstrumentId(1).size());
    }

    @Test
    public void findById() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        AdditionalImage testAdditionalImage2 = new AdditionalImage("Cool dude", 2);
        AdditionalImage testAdditionalImage3 = new AdditionalImage("whatever", 1);
        additionalImageDao.add(testAdditionalImage);
        additionalImageDao.add(testAdditionalImage2);
        additionalImageDao.add(testAdditionalImage3);
        assertEquals("Cool dude", additionalImageDao.findById(2).getUrl());
    }

    @Test
    public void update() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        additionalImageDao.add(testAdditionalImage);
        AdditionalImage testAdditionalImage2 = new AdditionalImage("cool man", 1);
        additionalImageDao.update(1, testAdditionalImage2);
        List<AdditionalImage> foundAdditionalImages = additionalImageDao.getAllByInstrumentId(1);
        assertEquals("cool man", foundAdditionalImages.get(0).getUrl());
    }

    @Test
    public void deleteById() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        additionalImageDao.add(testAdditionalImage);
        additionalImageDao.deleteById(testAdditionalImage.getId());
        assertEquals(0, additionalImageDao.getAllByInstrumentId(1).size());
    }

    @Test
    public void clearAllAdditionalImagesByInstrumentId() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        additionalImageDao.add(testAdditionalImage);
        additionalImageDao.clearAllAdditionalImagesByInstrumentId(testAdditionalImage.getInstrumentId());
        assertEquals(0, additionalImageDao.getAllByInstrumentId(1).size());
    }

    @Test
    public void clearAll() throws Exception {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        AdditionalImage testAdditionalImage2 = new AdditionalImage("Cool dude", 1);
        AdditionalImage testAdditionalImage3 = new AdditionalImage("whatever", 1);
        additionalImageDao.add(testAdditionalImage);
        additionalImageDao.add(testAdditionalImage2);
        additionalImageDao.add(testAdditionalImage3);
        additionalImageDao.clearAll();
        List<AdditionalImage> allAdditionalImages = additionalImageDao.getAllByInstrumentId(1);
        assertEquals(0, allAdditionalImages.size());
    }

}