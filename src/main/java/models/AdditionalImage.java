package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AdditionalImage {
    private int id;
    private String url;
    private int instrumentId;

    public AdditionalImage(String url, int instrumentId) {
        this.url = url;
        this.instrumentId = instrumentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalImage that = (AdditionalImage) o;
        return id == that.id &&
                instrumentId == that.instrumentId &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, url, instrumentId);
    }
}