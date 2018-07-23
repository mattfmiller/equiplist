package dao;

import models.Guitar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Collections;

public class Sql2oGuitarDao implements GuitarDao{

    private final Sql2o sql2o;
    public Sql2oGuitarDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Guitar guitar) {
        String instrumentSql = "INSERT INTO instruments (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) VALUES (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(instrumentSql, true)
                    .bind(guitar)
                    .executeUpdate()
                    .getKey();
            guitar.setId(id);
            String guitarSql = "INSERT INTO guitars (id, bodyWood, finish, color, binding, neckWood, neckType, neckProfile, fretboardWood, fretboardRadius, frets, fretMaterial, inlays, nutMaterial, nutWidth, scaleLength, neckPickup, middlePickup, bridgePickup, volumePots, tonePots, capacitor, tuners, tunerButtons, bridge, tailpiece, guitarSwitch, knobs, pickguard, controls, guitarCase) VALUES (:id, :bodyWood,  :finish, :color, :binding, :neckWood, :neckType, :neckProfile, :fretboardWood, :fretboardRadius, :frets, :fretMaterial, :inlays, :nutMaterial, :nutWidth, :scaleLength, :neckPickup, :middlePickup, :bridgePickup, :volumePots, :tonePots, :capacitor, :tuners, :tunerButtons, :bridge, :tailpiece, :guitarSwitch, :knobs, :pickguard, :controls, :guitarCase)";
            con.createQuery(guitarSql)
                    .bind(guitar)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Guitar> getAllGuitars() {
        try(Connection con = sql2o.open()){
            List<Guitar> allGuitarsWithoutNull = con.createQuery("SELECT * FROM guitars JOIN instruments ON guitars.id = instruments.id")
                    .executeAndFetch(Guitar.class);
            allGuitarsWithoutNull.removeAll(Collections.singleton(null));
            return allGuitarsWithoutNull;
        }
    }

    @Override
    public List<Guitar> getAllGuitarsInCollection() {
        try(Connection con = sql2o.open()){
            List<Guitar> allGuitarsWithoutNull = con.createQuery("SELECT * FROM guitars JOIN instruments ON guitars.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "false")
                    .executeAndFetch(Guitar.class);
            allGuitarsWithoutNull.removeAll(Collections.singleton(null));
            return allGuitarsWithoutNull;
        }
    }

    @Override
    public List<Guitar> getAllGuitarsInWishlist() {
        try(Connection con = sql2o.open()){
            List<Guitar> allGuitarsWithoutNull = con.createQuery("SELECT * FROM guitars JOIN instruments ON guitars.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "true")
                    .executeAndFetch(Guitar.class);
            allGuitarsWithoutNull.removeAll(Collections.singleton(null));
            return allGuitarsWithoutNull;
        }
    }

    @Override
    public void update(int id, Guitar guitar) {
        String instrumentSql = "UPDATE instruments SET (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) = (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold) WHERE id = :id";
        String guitarSql = "UPDATE guitars SET(bodyWood, finish, color, binding, neckWood, neckType, neckProfile, fretboardWood, fretboardRadius, frets, fretMaterial, inlays, nutMaterial, nutWidth, scaleLength, neckPickup, middlePickup, bridgePickup, volumePots, tonePots, capacitor, tuners, tunerButtons, bridge, tailpiece, guitarSwitch, knobs, pickguard, controls, guitarCase) = (:bodyWood,  :finish, :color, :binding, :neckWood, :neckType, :neckProfile, :fretboardWood, :fretboardRadius, :frets, :fretMaterial, :inlays, :nutMaterial, :nutWidth, :scaleLength, :neckPickup, :middlePickup, :bridgePickup, :volumePots, :tonePots, :capacitor, :tuners, :tunerButtons, :bridge, :tailpiece, :guitarSwitch, :knobs, :pickguard, :controls, :guitarCase) WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(instrumentSql)
                    .addParameter("manufacturer", guitar.getManufacturer())
                    .addParameter("model", guitar.getModel())
                    .addParameter("country", guitar.getCountry())
                    .addParameter("serialNumber", guitar.getSerialNumber())
                    .addParameter("description", guitar.getDescription())
                    .addParameter("year", guitar.getYear())
                    .addParameter("weight", guitar.getWeight())
                    .addParameter("imageUrl", guitar.getImageUrl())
                    .addParameter("current", guitar.getCurrent())
                    .addParameter("wishlist", guitar.getWishlist())
                    .addParameter("paid", guitar.getPaid())
                    .addParameter("sold", guitar.getSold())
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(guitarSql)
                    .addParameter("bodyWood", guitar.getBodyWood())
                    .addParameter("finish", guitar.getFinish())
                    .addParameter("color", guitar.getColor())
                    .addParameter("binding", guitar.getBinding())
                    .addParameter("neckWood", guitar.getNeckWood())
                    .addParameter("neckType", guitar.getNeckType())
                    .addParameter("neckProfile", guitar.getNeckProfile())
                    .addParameter("fretboardWood", guitar.getFretboardWood())
                    .addParameter("fretboardRadius", guitar.getFretboardRadius())
                    .addParameter("frets", guitar.getFrets())
                    .addParameter("fretMaterial", guitar.getFretMaterial())
                    .addParameter("inlays", guitar.getInlays())
                    .addParameter("nutMaterial", guitar.getNutMaterial())
                    .addParameter("nutWidth", guitar.getNutWidth())
                    .addParameter("scaleLength", guitar.getScaleLength())
                    .addParameter("neckPickup", guitar.getNeckPickup())
                    .addParameter("middlePickup", guitar.getMiddlePickup())
                    .addParameter("bridgePickup", guitar.getBridgePickup())
                    .addParameter("volumePots", guitar.getVolumePots())
                    .addParameter("tonePots", guitar.getTonePots())
                    .addParameter("capacitor", guitar.getCapacitor())
                    .addParameter("tuners", guitar.getTuners())
                    .addParameter("tunerButtons", guitar.getTunerButtons())
                    .addParameter("bridge", guitar.getBridge())
                    .addParameter("tailpiece", guitar.getTailpiece())
                    .addParameter("guitarSwitch", guitar.getGuitarSwitch())
                    .addParameter("knobs", guitar.getKnobs())
                    .addParameter("pickguard", guitar.getPickguard())
                    .addParameter("controls", guitar.getControls())
                    .addParameter("guitarCase", guitar.getGuitarCase())
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delteteById(int id) {
        String deleteInstrument = "DELETE from instruments WHERE id = :id";
        String deleteGuitars = "DELETE from guitars WHERE id = :guitarId";
        try(Connection con = sql2o.open()){
            con.createQuery(deleteGuitars)
                    .addParameter("guitarId", id)
                    .executeUpdate();
            con.createQuery(deleteInstrument)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
