package dao;

import models.Amp;
import models.Instrument;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sql2oAmpDao implements AmpDao{

    private final Sql2o sql2o;
    public Sql2oAmpDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Amp amp) {
        String instrumentSql = "INSERT INTO instruments (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) VALUES (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(instrumentSql, true)
                    .bind(amp)
                    .executeUpdate()
                    .getKey();
            amp.setId(id);
            String ampSql = "INSERT INTO amps (id, instrument, type, power, cabinetWood, finish, grillCloth, width, depth, height, electronics, speakers, tubes, reverb, tremolo, externalSpeaker, handle, knobs, jewelLight, controlPanel, logo, tiltLegs, feet, controls, cover) VALUES (:id, :instrument,  :type, :power, :cabinetWood, :finish, :grillCloth, :width, :depth, :height, :electronics, :speakers, :tubes, :reverb, :tremolo, :externalSpeaker, :handle, :knobs, :jewelLight, :controlPanel, :logo, :tiltLegs, :feet, :controls, :cover)";
            con.createQuery(ampSql)
                    .bind(amp)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Amp> getAllAmps() {
        try(Connection con = sql2o.open()){
            List<Amp> allAmpsWithoutNull = con.createQuery("SELECT * FROM amps JOIN instruments ON amps.id = instruments.id")
                    .executeAndFetch(Amp.class);
            allAmpsWithoutNull.removeAll(Collections.singleton(null));
            return allAmpsWithoutNull;
        }
    }

    @Override
    public List<Amp> getAllAmpsInCollection() {
        try(Connection con = sql2o.open()){
            List<Amp> allAmpsWithoutNull = con.createQuery("SELECT * FROM amps JOIN instruments ON amps.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "false")
                    .executeAndFetch(Amp.class);
            allAmpsWithoutNull.removeAll(Collections.singleton(null));
            return allAmpsWithoutNull;
        }
    }

    @Override
    public List<Amp> getAllAmpsInWishlist() {
        try(Connection con = sql2o.open()){
            List<Amp> allAmpsWithoutNull = con.createQuery("SELECT * FROM amps JOIN instruments ON amps.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "true")
                    .executeAndFetch(Amp.class);
            allAmpsWithoutNull.removeAll(Collections.singleton(null));
            return allAmpsWithoutNull;
        }
    }

    @Override
    public void update(int id, Amp amp) {
        String instrumentSql = "UPDATE instruments SET (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) = (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold) WHERE id = :id";
        String ampSql = "UPDATE amps SET(instrument, type, power, cabinetWood, finish, grillCloth, width, depth, height, electronics, speakers, tubes, reverb, tremolo, externalSpeaker, handle, knobs, jewelLight, controlPanel, logo, tiltLegs, feet, controls, cover) = (:id, :instrument,  :type, :power, :cabinetWood, :finish, :grillCloth, :width, :depth, :height, :electronics, :speakers, :tubes, :reverb, :tremolo, :externalSpeaker, :handle, :knobs, :jewelLight, :controlPanel, :logo, :tiltLegs, :feet, :controls, :cover) WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(instrumentSql)
                    .addParameter("manufacturer", amp.getManufacturer())
                    .addParameter("model", amp.getModel())
                    .addParameter("country", amp.getCountry())
                    .addParameter("serialNumber", amp.getSerialNumber())
                    .addParameter("description", amp.getDescription())
                    .addParameter("year", amp.getYear())
                    .addParameter("weight", amp.getWeight())
                    .addParameter("imageUrl", amp.getImageUrl())
                    .addParameter("current", amp.getCurrent())
                    .addParameter("wishlist", amp.getWishlist())
                    .addParameter("paid", amp.getPaid())
                    .addParameter("sold", amp.getSold())
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(ampSql)
                    .addParameter("instrument", amp.getInstrument())
                    .addParameter("type", amp.getType())
                    .addParameter("power", amp.getPower())
                    .addParameter("cabinetWood", amp.getCabinetWood())
                    .addParameter("finish", amp.getFinish())
                    .addParameter("grillCloth", amp.getGrillCloth())
                    .addParameter("width", amp.getWidth())
                    .addParameter("depth", amp.getDepth())
                    .addParameter("height", amp.getHeight())
                    .addParameter("electronics", amp.getElectronics())
                    .addParameter("speakers", amp.getSpeakers())
                    .addParameter("tubes", amp.getTubes())
                    .addParameter("reverb", amp.getReverb())
                    .addParameter("tremolo", amp.getTremolo())
                    .addParameter("externalSpeaker", amp.getExternalSpeaker())
                    .addParameter("knobs", amp.getKnobs())
                    .addParameter("handle", amp.getHandle())
                    .addParameter("jewelLight", amp.getJewelLight())
                    .addParameter("controlPanel", amp.getControlPanel())
                    .addParameter("logo", amp.getLogo())
                    .addParameter("tiltLegs", amp.getTiltLegs())
                    .addParameter("feet", amp.getFeet())
                    .addParameter("controls", amp.getControls())
                    .addParameter("cover", amp.getCover())
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delteteById(int id) {
        String deleteInstrument = "DELETE from instruments WHERE id = :id";
        String deleteAmps = "DELETE from amps WHERE id = :ampId";
        try(Connection con = sql2o.open()){
            con.createQuery(deleteAmps)
                    .addParameter("ampId", id)
                    .executeUpdate();
            con.createQuery(deleteInstrument)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Amp> search(String query) {
        try(Connection con = sql2o.open()){
            List<Amp> searchedAmps = new ArrayList<>();
            List<Instrument> instrumentsByManufacturer = con.createQuery("SELECT * FROM instruments WHERE manufacturer LIKE :query")
                    .addParameter("query", "%"+ query +"%")
                    .executeAndFetch(Instrument.class);
            List<Amp> ampsByManufacturer = new ArrayList<>();
            for ( Instrument instrument: instrumentsByManufacturer) {
                int id = instrument.getId();
                List<Amp> ampsByInstrumentId = con.createQuery("SELECT * FROM amps JOIN instruments ON amps.id = instruments.id WHERE amps.id = :id")
                        .addParameter("id", id)
                        .executeAndFetch(Amp.class);
                for (Amp amp: ampsByInstrumentId) {
                    ampsByManufacturer.add(amp);
                }
            }
            for ( Amp amp : ampsByManufacturer ) {
                searchedAmps.add(amp);
            }
            List<Instrument> instrumentsByModel = con.createQuery("SELECT * FROM instruments WHERE model LIKE :query")
                    .addParameter("query", "%"+ query +"%")
                    .executeAndFetch(Instrument.class);
            List<Amp> ampsByModel = new ArrayList<>();
            for ( Instrument instrument: instrumentsByModel) {
                int id = instrument.getId();
                List<Amp> ampsByInstrumentId = con.createQuery("SELECT * FROM amps JOIN instruments ON amps.id = instruments.id WHERE amps.id = :id")
                        .addParameter("id", id)
                        .executeAndFetch(Amp.class);
                for (Amp amp: ampsByInstrumentId) {
                    ampsByModel.add(amp);
                }
            }
            for ( Amp amp : ampsByModel ) {
                searchedAmps.add(amp);
            }
            return searchedAmps;
        }

    }
}