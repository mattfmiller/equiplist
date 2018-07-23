package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTest {

    public Instrument setupNewInstrument() {
        return new Instrument ("Gibson", "Les Paul Custom", "USA", "xxx", "Limited take on classic model", 1999, 10.9,  "www.test.url", true, false, 1500, 0);
    }

    @Test
    public void newInstrumentInstantiatesCorrectly() {
        Instrument testInstrument = setupNewInstrument();
        assertTrue(testInstrument instanceof Instrument);
    }

    @Test
    public void setId_1() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setId(1);
        assertEquals(1, testInstrument.getId());
    }

    @Test
    public void getManufacturer_gibson() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Gibson", testInstrument.getManufacturer());
    }

    @Test
    public void setManufacturer_fender() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setManufacturer("Fender");
        assertEquals("Fender", testInstrument.getManufacturer());
    }

    @Test
    public void getModel_lesPaulCustom() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Les Paul Custom", testInstrument.getModel());
    }

    @Test
    public void setModel_jazzmaster() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setModel("Jazzmaster");
        assertEquals("Jazzmaster", testInstrument.getModel());
    }

    @Test
    public void getCountry_usa() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("USA", testInstrument.getCountry());
    }

    @Test
    public void setCountry_japan() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCountry("Japan");
        assertEquals("Japan", testInstrument.getCountry());
    }

    @Test
    public void getSerialNumber_xxx() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("xxx", testInstrument.getSerialNumber());
    }

    @Test
    public void setSerialNumber_zzz() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setSerialNumber("zzz");
        assertEquals("zzz", testInstrument.getSerialNumber());
    }


    @Test
    public void setYear_1998() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setYear(1998);
        assertEquals(1998, testInstrument.getYear());
    }

    @Test
    public void setWeight_108() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setWeight(10.80);
        assertEquals(10.80, testInstrument.getWeight(), 0.01);
    }

    @Test
    public void getImageUrl_url() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("www.test.url", testInstrument.getImageUrl());
    }

    @Test
    public void setImageUrl_jpg() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setImageUrl("www.test.jpg");
        assertEquals("www.test.jpg", testInstrument.getImageUrl());
    }

    @Test
    public void getCurrent_true() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(true, testInstrument.getCurrent());
    }

    @Test
    public void setCurrent_false() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCurrent(false);
        assertEquals(false, testInstrument.getCurrent());
    }


    @Test
    public void getWishlist_false() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(false, testInstrument.getWishlist());
    }

    @Test
    public void setWishlist_true() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setWishlist(true);
        assertEquals(true, testInstrument.getWishlist());
    }

    @Test
    public void setPaid_1400() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setPaid(1400);
        assertEquals(1400, testInstrument.getPaid(), 0.01);
    }

    @Test
    public void setSold_1200() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setSold(1200);
        assertEquals(1200, testInstrument.getSold(), 0.01);
    }

    @Test
    public void setDescription() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setDescription("Old");
        assertEquals("Old", testInstrument.getDescription());
    }

}