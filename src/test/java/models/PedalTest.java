package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PedalTest {

    public Pedal setupNewPedal() {
        return new Pedal ("Wampler", "Tumnus", "USA", "xxx", 2017, 1.4, "www.test.url", true, false, 135.00, 0.00,"Overdrive", "9-18V", 1.4, 1.1, 3.0, "PCB", false, 1000000, 100, "10-25 mA", "Volume, Treble, Gain", "Buffer");
    }

    @Test
    public void newPedalInstantiatesCorrectly() {
        Pedal testPedal = setupNewPedal();
        assertTrue(testPedal instanceof Pedal);
    }

    @Test
    public void setType() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setType("Fuzz");
        assertEquals("Fuzz", testPedal.getType());
    }

    @Test
    public void setPower() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setPower("9V");
        assertEquals("9V", testPedal.getPower());
    }

    @Test
    public void setWidth() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setWidth(2);
        assertEquals(2, testPedal.getWidth(), 0.01);
    }

    @Test
    public void setDepth() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setDepth(3);
        assertEquals(3, testPedal.getDepth(), 0.01);
    }

    @Test
    public void setHeight() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setHeight(4);
        assertEquals(4, testPedal.getHeight(), 0.01);
    }

    @Test
    public void setElectronics() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setElectronics("Handwired");
        assertEquals("Handwired", testPedal.getElectronics());
    }

    @Test
    public void setTrueBypass() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setTrueBypass(true);
        assertEquals(true, testPedal.getTrueBypass());
    }

    @Test
    public void setInputImpedance() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setInputImpedance(100);
        assertEquals(100, testPedal.getInputImpedance());
    }

    @Test
    public void setOutputImpedance() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setOutputImpedance(1000);
        assertEquals(1000, testPedal.getOutputImpedance());
    }

    @Test
    public void setCurrentDraw() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setCurrentDraw("<10 mA");
        assertEquals("<10 mA", testPedal.getCurrentDraw());
    }

    @Test
    public void setControls() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setControls("Volume, Fuzz");
        assertEquals("Volume, Fuzz", testPedal.getControls());
    }

    @Test
    public void setFeatures() throws Exception {
        Pedal testPedal = setupNewPedal();
        testPedal.setFeatures("Germanium Transistors");
        assertEquals("Germanium Transistors", testPedal.getFeatures());
    }

}