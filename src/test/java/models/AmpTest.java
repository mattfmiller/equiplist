package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class AmpTest {

    public Amp setupNewAmp() {
        return new Amp ("Gibson", "Les Paul Custom", "USA", "xxx", 1999, 45.8, "www.test.url", true, false, 600.00, 0.00,"Guitar", "Head and Cab", 40, "Pine", "Blonde Tolex", "Ox Blood", 12, 13, 14, "Handwired", "2 Weber 10 inch", "2 6V6", "4 12AX7", "N/A", false, false, "N/A", "Dog Bone", "White Cupcake", "Blue", " blackface fender bassman", "Fender with tail", true, "rubber", "volume, treble, bass", "N/A");
    }

    @Test
    public void newGuitarInstantiatesCorrectly() {
        Amp testAmp = setupNewAmp();
        assertTrue(testAmp instanceof Amp);
    }

    @Test
    public void setInstrument() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setInstrument("Bass");
        assertEquals("Bass", testAmp.getInstrument());
    }

    @Test
    public void setType() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setType("Combo");
        assertEquals("Combo", testAmp.getType());
    }

    @Test
    public void setPower() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setPower(45);
        assertEquals(45, testAmp.getPower());
    }

    @Test
    public void setCabinetWood() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setCabinetWood("Birch");
        assertEquals("Birch", testAmp.getCabinetWood());
    }

    @Test
    public void setFinish() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setFinish("Tweed");
        assertEquals("Tweed", testAmp.getFinish());
    }

    @Test
    public void setGrillCloth() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setGrillCloth("Wheat");
        assertEquals("Wheat", testAmp.getGrillCloth());
    }

    @Test
    public void setWidth() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setWidth(13);
        assertEquals(13, testAmp.getWidth());
    }

    @Test
    public void setDepth() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setDepth(14);
        assertEquals(14, testAmp.getDepth());
    }

    @Test
    public void setHeight() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setHeight(15);
        assertEquals(15, testAmp.getHeight());
    }

    @Test
    public void setElectronics() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setElectronics("PCB");
        assertEquals("PCB", testAmp.getElectronics());
    }

    @Test
    public void setSpeakers() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setSpeakers("3 Jensen 10 inch ALNICO");
        assertEquals("3 Jensen 10 inch ALNICO", testAmp.getSpeakers());
    }

    @Test
    public void setPowerTubes() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setPowerTubes("2 6L6");
        assertEquals("2 6L6", testAmp.getPowerTubes());
    }

    @Test
    public void setPreAmpTubes() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setPreAmpTubes("4 12AT7");
        assertEquals("4 12AT7", testAmp.getPreAmpTubes());
    }

    @Test
    public void setRectifierTube() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setRectifierTube("5U4");
        assertEquals("5U4", testAmp.getRectifierTube());
    }

    @Test
    public void setReverb() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setReverb(true);
        assertEquals(true, testAmp.getReverb());
    }

    @Test
    public void setTremolo() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setTremolo(true);
        assertEquals(true, testAmp.getTremolo());
    }

    @Test
    public void setExternalSpeaker() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setExternalSpeaker("external speaker jack mutes internal speaker");
        assertEquals("external speaker jack mutes internal speaker", testAmp.getExternalSpeaker());
    }

    @Test
    public void setHandle() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setHandle("Leather");
        assertEquals("Leather", testAmp.getHandle());
    }

    @Test
    public void setKnobs() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setKnobs("Chicken Head");
        assertEquals("Chicken Head", testAmp.getKnobs());
    }

    @Test
    public void setJewelLight() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setJewelLight("Red");
        assertEquals("Red", testAmp.getJewelLight());
    }

    @Test
    public void setControlPanel() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setControlPanel("Chrome");
        assertEquals("Chrome", testAmp.getControlPanel());
    }

    @Test
    public void setLogo() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setLogo("Narrow Panel Fender Logo");
        assertEquals("Narrow Panel Fender Logo", testAmp.getLogo());
    }

    @Test
    public void setTiltLegs() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setTiltLegs(false);
        assertEquals(false, testAmp.getTiltLegs());
    }

    @Test
    public void setFeet() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setFeet("Metal");
        assertEquals("Metal", testAmp.getFeet());
    }

    @Test
    public void setControls() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setControls("Microphone and Instrument Volume, Treble, Mid, Bass");
        assertEquals("Microphone and Instrument Volume, Treble, Mid, Bass", testAmp.getControls());
    }

    @Test
    public void setCover() throws Exception {
        Amp testAmp = setupNewAmp();
        testAmp.setCover("Brown fender cover");
        assertEquals("Brown fender cover", testAmp.getCover());
    }
}