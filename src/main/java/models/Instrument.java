package models;

import java.util.Objects;

public class Instrument {
    private int id;
    private String manufacturer;
    private String model;
    private String country;
    private String serialNumber;
    private String imageUrl;
    private int instrumentTypeId;
    private Boolean current;
    private Boolean wishlist;

    public Instrument(String manufacturer, String model, String country, String serialNumber, String imageUrl, int instrumentTypeId, Boolean current, Boolean wishlist) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.country = country;
        this.serialNumber = serialNumber;
        this.imageUrl = imageUrl;
        this.instrumentTypeId = instrumentTypeId;
        this.current = current;
        this.wishlist = wishlist;
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

    public int getInstrumentTypeId() {
        return instrumentTypeId;
    }

    public void setInstrumentTypeId(int instrumentTypeId) {
        this.instrumentTypeId = instrumentTypeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id == that.id &&
                instrumentTypeId == that.instrumentTypeId &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(model, that.model) &&
                Objects.equals(country, that.country) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(current, that.current) &&
                Objects.equals(wishlist, that.wishlist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, manufacturer, model, country, serialNumber, imageUrl, instrumentTypeId, current, wishlist);
    }
}
