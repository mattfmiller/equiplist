package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Note {
    private int id;
    private long createdAt;
    private String formattedCreatedAt;
    private String content;
    private int instrumentId;

    public Note(String content, int instrumentId) {
        this.content = content;
        this.instrumentId = instrumentId;
        this.createdAt = System.currentTimeMillis();
        setFormattedCreatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = System.currentTimeMillis();
    }

    public String getFormattedCreatedAt() {
        Date date = new Date(createdAt);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }

    public void setFormattedCreatedAt() {
        Date date = new Date(this.createdAt);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        this.formattedCreatedAt = sdf.format(date);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        Note note = (Note) o;
        return id == note.id &&
                createdAt == note.createdAt &&
                instrumentId == note.instrumentId &&
                Objects.equals(formattedCreatedAt, note.formattedCreatedAt) &&
                Objects.equals(content, note.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createdAt, formattedCreatedAt, content, instrumentId);
    }
}
