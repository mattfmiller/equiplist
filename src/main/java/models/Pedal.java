package models;

import java.util.Objects;

public class Pedal extends Instrument {
    private String type;
    private String power;
    private double width;
    private double depth;
    private double height;
    private String electronics;
    private Boolean trueBypass;
    private int inputImpedance;
    private int outputImpedance;
    private String currentDraw;
    private String controls;
    private String features;

    public Pedal(String manufacturer, String model, String country, String serialNumber, int year, Double weight, String imageUrl, Boolean current, Boolean wishlist, double paid, double sold,  String type, String power, double width, double depth, double height, String electronics, Boolean trueBypass, int inputImpedance, int outputImpedance, String currentDraw, String controls, String features) {
        super(manufacturer, model, country, serialNumber, year, weight, imageUrl, current, wishlist, paid, sold);
        this.type = type;
        this.power = power;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.electronics = electronics;
        this.trueBypass = trueBypass;
        this.inputImpedance = inputImpedance;
        this.outputImpedance = outputImpedance;
        this.currentDraw = currentDraw;
        this.controls = controls;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    public Boolean getTrueBypass() {
        return trueBypass;
    }

    public void setTrueBypass(Boolean trueBypass) {
        this.trueBypass = trueBypass;
    }

    public int getInputImpedance() {
        return inputImpedance;
    }

    public void setInputImpedance(int inputImpedance) {
        this.inputImpedance = inputImpedance;
    }

    public int getOutputImpedance() {
        return outputImpedance;
    }

    public void setOutputImpedance(int outputImpedance) {
        this.outputImpedance = outputImpedance;
    }

    public String getCurrentDraw() {
        return currentDraw;
    }

    public void setCurrentDraw(String currentDraw) {
        this.currentDraw = currentDraw;
    }

    public String getControls() {
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pedal pedal = (Pedal) o;
        return Double.compare(pedal.width, width) == 0 &&
                Double.compare(pedal.depth, depth) == 0 &&
                Double.compare(pedal.height, height) == 0 &&
                inputImpedance == pedal.inputImpedance &&
                outputImpedance == pedal.outputImpedance &&
                Objects.equals(type, pedal.type) &&
                Objects.equals(power, pedal.power) &&
                Objects.equals(electronics, pedal.electronics) &&
                Objects.equals(trueBypass, pedal.trueBypass) &&
                Objects.equals(currentDraw, pedal.currentDraw) &&
                Objects.equals(controls, pedal.controls) &&
                Objects.equals(features, pedal.features);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type, power, width, depth, height, electronics, trueBypass, inputImpedance, outputImpedance, currentDraw, controls, features);
    }
}
