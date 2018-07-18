package models;

import java.util.Objects;

public class Amp extends Instrument {
    private String instrument;
    private String type;
    private int power;
    private String cabinetWood;
    private String finish;
    private String grillCloth;
    private int width;
    private int depth;
    private int height;
    private String electronics;
    private String speakers;
    private String powerTubes;
    private String preAmpTubes;
    private String rectifierTube;
    private Boolean reverb;
    private Boolean tremolo;
    private String externalSpeaker;
    private String handle;
    private String knobs;
    private String jewelLight;
    private String controlPanel;
    private String logo;
    private String tiltLegs;
    private String feet;
    private String controls;
    private String cover;

    public Amp(String manufacturer, String model, String country, String serialNumber, int year, Double weight, String imageUrl, Boolean current, Boolean wishlist, double paid, double sold, String instrument, String type, int power, String cabinetWood, String finish, String grillCloth, private int width, int depth, int height, String electronics, String speakers, String powerTubes, String preAmpTubes, String rectifierTube, Boolean reverb, Boolean tremolo, String externalSpeaker, String handle, String knobs, String jewelLight, String controlPanel, String logo, String tiltLegs, String feet, String controls, String cover) {
        super(manufacturer, model, country, serialNumber, year, weight, imageUrl, current, wishlist, paid, sold);
        this.instrument = instrument;
        this.type = type;
        this.power = power;
        this.cabinetWood = cabinetWood;
        this.finish = finish;
        this.grillCloth = grillCloth;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.electronics = electronics;
        this.speakers = speakers;
        this.powerTubes = powerTubes;
        this.preAmpTubes = preAmpTubes;
        this.rectifierTube = rectifierTube;
        this.reverb = reverb;
        this.tremolo = tremolo;
        this.externalSpeaker = externalSpeaker;
        this.handle = handle;
        this.knobs = knobs;
        this.jewelLight = jewelLight;
        this.controlPanel = controlPanel;
        this.logo = logo;
        this.tiltLegs = tiltLegs;
        this.feet = feet;
        this.controls = controls;
        this.cover = cover;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getCabinetWood() {
        return cabinetWood;
    }

    public void setCabinetWood(String cabinetWood) {
        this.cabinetWood = cabinetWood;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getGrillCloth() {
        return grillCloth;
    }

    public void setGrillCloth(String grillCloth) {
        this.grillCloth = grillCloth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getPowerTubes() {
        return powerTubes;
    }

    public void setPowerTubes(String powerTubes) {
        this.powerTubes = powerTubes;
    }

    public String getPreAmpTubes() {
        return preAmpTubes;
    }

    public void setPreAmpTubes(String preAmpTubes) {
        this.preAmpTubes = preAmpTubes;
    }

    public String getRectifierTube() {
        return rectifierTube;
    }

    public void setRectifierTube(String rectifierTube) {
        this.rectifierTube = rectifierTube;
    }

    public Boolean getReverb() {
        return reverb;
    }

    public void setReverb(Boolean reverb) {
        this.reverb = reverb;
    }

    public Boolean getTremolo() {
        return tremolo;
    }

    public void setTremolo(Boolean tremolo) {
        this.tremolo = tremolo;
    }

    public String getExternalSpeaker() {
        return externalSpeaker;
    }

    public void setExternalSpeaker(String externalSpeaker) {
        this.externalSpeaker = externalSpeaker;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getKnobs() {
        return knobs;
    }

    public void setKnobs(String knobs) {
        this.knobs = knobs;
    }

    public String getJewelLight() {
        return jewelLight;
    }

    public void setJewelLight(String jewelLight) {
        this.jewelLight = jewelLight;
    }

    public String getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(String controlPanel) {
        this.controlPanel = controlPanel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTiltLegs() {
        return tiltLegs;
    }

    public void setTiltLegs(String tiltLegs) {
        this.tiltLegs = tiltLegs;
    }

    public String getFeet() {
        return feet;
    }

    public void setFeet(String feet) {
        this.feet = feet;
    }

    public String getControls() {
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
