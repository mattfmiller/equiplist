package models;

import java.util.Objects;

public class Instrument {
    private int id;
    private String manufacturer;
    private String model;
    private String country;
    private String serialNumber;
    private String description;
    private int year;
    private double weight;
    private String imageUrl;
    private Boolean current;
    private Boolean wishlist;
    private double paid;
    private double sold;

    public Instrument(String manufacturer, String model, String country, String serialNumber, String description, int year, double weight, String imageUrl, Boolean current, Boolean wishlist, double paid, double sold) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.country = country;
        this.serialNumber = serialNumber;
        this.description = description;
        this.year = year;
        this.weight = weight;
        this.imageUrl = imageUrl;
        this.current = current;
        this.wishlist = wishlist;
        this.paid = paid;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Boolean getWishlist() {
        return wishlist;
    }

    public void setWishlist(Boolean wishlist) {
        this.wishlist = wishlist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id == that.id &&
                year == that.year &&
                Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.paid, paid) == 0 &&
                Double.compare(that.sold, sold) == 0 &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(model, that.model) &&
                Objects.equals(country, that.country) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(current, that.current) &&
                Objects.equals(wishlist, that.wishlist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold);
    }
}
