package models;

import java.util.Objects;

public class Guitar extends Instrument {
    private double weight;
    private String bodyWood;
    private String finish;
    private String color;
    private String binding;
    private String neckWood;
    private String neckType;
    private String neckProfile;
    private String fretboardWood;
    private double fretboardRadius;
    private int frets;
    private String fretMaterial;
    private String inlays;
    private String nutMaterial;
    private double nutWidth;
    private double scaleLength;
    private String neckPickup;
    private String middlePickup;
    private String bridgePickup;
    private String volumePots;
    private String tonePots;
    private String capacitor;
    private String tuners;
    private String tunerButtons;
    private String bridge;
    private String tailpiece;
    private String guitarSwitch;
    private String knobs;
    private String pickguard;
    private String controls;
    private String guitarCase;

    public Guitar(String manufacturer, String model, String country, String serialNumber, String imageUrl, Boolean current, Boolean wishlist, double weight, String bodyWood, String finish, String color, String binding, String neckWood, String neckType, String neckProfile, String fretboardWood, Double fretboardRadius, int frets, String fretMaterial, String inlays, String nutMaterial, double nutWidth, double scaleLength, String neckPickup, String middlePickup, String bridgePickup, String volumePots, String tonePots, String capacitor, String tuners, String tunerButtons, String bridge, String tailpiece, String guitarSwitch, String knobs, String pickguard, String controls, String guitarCase) {
        super(manufacturer, model, country, serialNumber, imageUrl, current, wishlist);
        this.weight = weight;
        this.bodyWood = bodyWood;
        this.finish = finish;
        this.color = color;
        this.binding = binding;
        this.neckWood = neckWood;
        this.neckType = neckType;
        this.neckProfile = neckProfile;
        this.fretboardWood = fretboardWood;
        this.fretboardRadius = fretboardRadius;
        this.frets = frets;
        this.fretMaterial = fretMaterial;
        this.inlays = inlays;
        this.nutMaterial = nutMaterial;
        this.nutWidth = nutWidth;
        this.scaleLength = scaleLength;
        this.neckPickup = neckPickup;
        this.middlePickup = middlePickup;
        this.bridgePickup = bridgePickup;
        this.volumePots = volumePots;
        this.tonePots = tonePots;
        this.capacitor = capacitor;
        this.tuners = tuners;
        this.tunerButtons = tunerButtons;
        this.bridge = bridge;
        this.tailpiece = tailpiece;
        this.guitarSwitch = guitarSwitch;
        this.knobs = knobs;
        this.pickguard = pickguard;
        this.controls = controls;
        this.guitarCase = guitarCase;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBodyWood() {
        return bodyWood;
    }

    public void setBodyWood(String bodyWood) {
        this.bodyWood = bodyWood;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNeckWood() {
        return neckWood;
    }

    public void setNeckWood(String neckWood) {
        this.neckWood = neckWood;
    }

    public String getNeckType() {
        return neckType;
    }

    public void setNeckType(String neckType) {
        this.neckType = neckType;
    }

    public String getNeckProfile() {
        return neckProfile;
    }

    public void setNeckProfile(String neckProfile) {
        this.neckProfile = neckProfile;
    }

    public String getFretboardWood() {
        return fretboardWood;
    }

    public void setFretboardWood(String fretboardWood) {
        this.fretboardWood = fretboardWood;
    }

    public Double getFretboardRadius() {
        return fretboardRadius;
    }

    public void setFretboardRadius(Double fretboardRadius) {
        this.fretboardRadius = fretboardRadius;
    }

    public int getFrets() {
        return frets;
    }

    public void setFrets(int frets) {
        this.frets = frets;
    }

    public String getFretMaterial() {
        return fretMaterial;
    }

    public void setFretMaterial(String fretMaterial) {
        this.fretMaterial = fretMaterial;
    }

    public String getInlays() {
        return inlays;
    }

    public void setInlays(String inlays) {
        this.inlays = inlays;
    }

    public String getNutMaterial() {
        return nutMaterial;
    }

    public void setNutMaterial(String nutMaterial) {
        this.nutMaterial = nutMaterial;
    }

    public double getNutWidth() {
        return nutWidth;
    }

    public void setNutWidth(double nutWidth) {
        this.nutWidth = nutWidth;
    }

    public double getScaleLength() {
        return scaleLength;
    }

    public void setScaleLength(double scaleLength) {
        this.scaleLength = scaleLength;
    }

    public String getNeckPickup() {
        return neckPickup;
    }

    public void setNeckPickup(String neckPickup) {
        this.neckPickup = neckPickup;
    }

    public String getMiddlePickup() {
        return middlePickup;
    }

    public void setMiddlePickup(String middlePickup) {
        this.middlePickup = middlePickup;
    }

    public String getBridgePickup() {
        return bridgePickup;
    }

    public void setBridgePickup(String bridgePickup) {
        this.bridgePickup = bridgePickup;
    }

    public String getVolumePots() {
        return volumePots;
    }

    public void setVolumePots(String volumePots) {
        this.volumePots = volumePots;
    }

    public String getTonePots() {
        return tonePots;
    }

    public void setTonePots(String tonePots) {
        this.tonePots = tonePots;
    }

    public String getCapacitor() {
        return capacitor;
    }

    public void setCapacitor(String capacitor) {
        this.capacitor = capacitor;
    }

    public String getTuners() {
        return tuners;
    }

    public void setTuners(String tuners) {
        this.tuners = tuners;
    }

    public String getTunerButtons() {
        return tunerButtons;
    }

    public void setTunerButtons(String tunerButtons) {
        this.tunerButtons = tunerButtons;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getTailpiece() {
        return tailpiece;
    }

    public void setTailpiece(String tailpiece) {
        this.tailpiece = tailpiece;
    }

    public String getGuitarSwitch() {
        return guitarSwitch;
    }

    public void setGuitarSwitch(String guitarSwitch) {
        this.guitarSwitch = guitarSwitch;
    }

    public String getKnobs() {
        return knobs;
    }

    public void setKnobs(String knobs) {
        this.knobs = knobs;
    }

    public String getPickguard() {
        return pickguard;
    }

    public void setPickguard(String pickguard) {
        this.pickguard = pickguard;
    }

    public String getControls() {
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public String getGuitarCase() {
        return guitarCase;
    }

    public void setGuitarCase(String guitarCase) {
        this.guitarCase = guitarCase;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guitar guitar = (Guitar) o;
        return Double.compare(guitar.weight, weight) == 0 &&
                frets == guitar.frets &&
                Double.compare(guitar.nutWidth, nutWidth) == 0 &&
                Double.compare(guitar.scaleLength, scaleLength) == 0 &&
                Objects.equals(bodyWood, guitar.bodyWood) &&
                Objects.equals(finish, guitar.finish) &&
                Objects.equals(color, guitar.color) &&
                Objects.equals(binding, guitar.binding) &&
                Objects.equals(neckWood, guitar.neckWood) &&
                Objects.equals(neckType, guitar.neckType) &&
                Objects.equals(neckProfile, guitar.neckProfile) &&
                Objects.equals(fretboardWood, guitar.fretboardWood) &&
                Objects.equals(fretboardRadius, guitar.fretboardRadius) &&
                Objects.equals(fretMaterial, guitar.fretMaterial) &&
                Objects.equals(inlays, guitar.inlays) &&
                Objects.equals(nutMaterial, guitar.nutMaterial) &&
                Objects.equals(neckPickup, guitar.neckPickup) &&
                Objects.equals(middlePickup, guitar.middlePickup) &&
                Objects.equals(bridgePickup, guitar.bridgePickup) &&
                Objects.equals(volumePots, guitar.volumePots) &&
                Objects.equals(tonePots, guitar.tonePots) &&
                Objects.equals(capacitor, guitar.capacitor) &&
                Objects.equals(tuners, guitar.tuners) &&
                Objects.equals(tunerButtons, guitar.tunerButtons) &&
                Objects.equals(bridge, guitar.bridge) &&
                Objects.equals(tailpiece, guitar.tailpiece) &&
                Objects.equals(guitarSwitch, guitar.guitarSwitch) &&
                Objects.equals(knobs, guitar.knobs) &&
                Objects.equals(pickguard, guitar.pickguard) &&
                Objects.equals(controls, guitar.controls) &&
                Objects.equals(guitarCase, guitar.guitarCase);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), weight, bodyWood, finish, color, binding, neckWood, neckType, neckProfile, fretboardWood, fretboardRadius, frets, fretMaterial, inlays, nutMaterial, nutWidth, scaleLength, neckPickup, middlePickup, bridgePickup, volumePots, tonePots, capacitor, tuners, tunerButtons, bridge, tailpiece, guitarSwitch, knobs, pickguard, controls, guitarCase);
    }
}
