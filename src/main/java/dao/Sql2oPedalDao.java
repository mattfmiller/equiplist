package dao;

import models.Instrument;
import models.Pedal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sql2oPedalDao implements PedalDao{

    private final Sql2o sql2o;
    public Sql2oPedalDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Pedal pedal) {
        String instrumentSql = "INSERT INTO instruments (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) VALUES (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(instrumentSql, true)
                    .bind(pedal)
                    .executeUpdate()
                    .getKey();
            pedal.setId(id);
            String pedalSql = "INSERT INTO pedals (id, type, power, trueBypass, width, depth, height, electronics, inputImpedance, outputImpedance, currentDraw, features, controls) VALUES (:id, :type, :power, :trueBypass, :width, :depth, :height, :electronics, :inputImpedance, :outputImpedance, :currentDraw, :features, :controls)";
            con.createQuery(pedalSql)
                    .bind(pedal)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Pedal> getAllPedals() {
        try(Connection con = sql2o.open()){
            List<Pedal> allPedalsWithoutNull = con.createQuery("SELECT * FROM pedals JOIN instruments ON pedals.id = instruments.id")
                    .executeAndFetch(Pedal.class);
            allPedalsWithoutNull.removeAll(Collections.singleton(null));
            return allPedalsWithoutNull;
        }
    }

    @Override
    public List<Pedal> getAllPedalsInCollection() {
        try(Connection con = sql2o.open()){
            List<Pedal> allPedalsWithoutNull = con.createQuery("SELECT * FROM pedals JOIN instruments ON pedals.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "false")
                    .executeAndFetch(Pedal.class);
            allPedalsWithoutNull.removeAll(Collections.singleton(null));
            return allPedalsWithoutNull;
        }
    }

    @Override
    public List<Pedal> getAllPedalsInWishlist() {
        try(Connection con = sql2o.open()){
            List<Pedal> allPedalsWithoutNull = con.createQuery("SELECT * FROM pedals JOIN instruments ON pedals.id = instruments.id WHERE wishlist = :collectionBoolean")
                    .addParameter("collectionBoolean", "true")
                    .executeAndFetch(Pedal.class);
            allPedalsWithoutNull.removeAll(Collections.singleton(null));
            return allPedalsWithoutNull;
        }
    }

    @Override
    public void update(int id, Pedal pedal) {
        String instrumentSql = "UPDATE instruments SET (manufacturer, model, country, serialNumber, description, year, weight, imageUrl, current, wishlist, paid, sold) = (:manufacturer, :model, :country, :serialNumber, :description, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold) WHERE id = :id";
        String pedalSql = "UPDATE pedals SET(type, power, trueBypass, width, depth, height, electronics, inputImpedance, outputImpedance, currentDraw, features, controls) = (:type, :power, :trueBypass, :width, :depth, :height, :electronics, :inputImpedance, :outputImpedance, :currentDraw, :features, :controls) WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(instrumentSql)
                    .addParameter("manufacturer", pedal.getManufacturer())
                    .addParameter("model", pedal.getModel())
                    .addParameter("country", pedal.getCountry())
                    .addParameter("serialNumber", pedal.getSerialNumber())
                    .addParameter("description", pedal.getDescription())
                    .addParameter("year", pedal.getYear())
                    .addParameter("weight", pedal.getWeight())
                    .addParameter("imageUrl", pedal.getImageUrl())
                    .addParameter("current", pedal.getCurrent())
                    .addParameter("wishlist", pedal.getWishlist())
                    .addParameter("paid", pedal.getPaid())
                    .addParameter("sold", pedal.getSold())
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(pedalSql)
                    .addParameter("type", pedal.getType())
                    .addParameter("power", pedal.getPower())
                    .addParameter("trueBypass", pedal.getTrueBypass())
                    .addParameter("inputImpedance", pedal.getInputImpedance())
                    .addParameter("outputImpedance", pedal.getOutputImpedance())
                    .addParameter("currentDraw", pedal.getCurrentDraw())
                    .addParameter("width", pedal.getWidth())
                    .addParameter("depth", pedal.getDepth())
                    .addParameter("height", pedal.getHeight())
                    .addParameter("electronics", pedal.getElectronics())
                    .addParameter("features", pedal.getFeatures())
                    .addParameter("controls", pedal.getControls())
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String deleteInstrument = "DELETE from instruments WHERE id = :id";
        String deletePedals = "DELETE from pedals WHERE id = :pedalId";
        try(Connection con = sql2o.open()){
            con.createQuery(deletePedals)
                    .addParameter("pedalId", id)
                    .executeUpdate();
            con.createQuery(deleteInstrument)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Pedal> search(String query) {
        try(Connection con = sql2o.open()){
            List<Pedal> searchedPedals = new ArrayList<>();
            List<Instrument> instrumentsByManufacturer = con.createQuery("SELECT * FROM instruments WHERE manufacturer LIKE :query")
                    .addParameter("query", "%"+ query +"%")
                    .executeAndFetch(Instrument.class);
            List<Pedal> pedalsByManufacturer = new ArrayList<>();
            for ( Instrument instrument: instrumentsByManufacturer) {
                int id = instrument.getId();
                List<Pedal> pedalsByInstrumentId = con.createQuery("SELECT * FROM pedals JOIN instruments ON pedals.id = instruments.id WHERE pedals.id = :id")
                        .addParameter("id", id)
                        .executeAndFetch(Pedal.class);
                for (Pedal pedal: pedalsByInstrumentId) {
                    pedalsByManufacturer.add(pedal);
                }
            }
            for ( Pedal pedal : pedalsByManufacturer ) {
                searchedPedals.add(pedal);
            }
            List<Instrument> instrumentsByModel = con.createQuery("SELECT * FROM instruments WHERE model LIKE :query")
                    .addParameter("query", "%"+ query +"%")
                    .executeAndFetch(Instrument.class);
            List<Pedal> pedalsByModel = new ArrayList<>();
            for ( Instrument instrument: instrumentsByModel) {
                int id = instrument.getId();
                List<Pedal> pedalsByInstrumentId = con.createQuery("SELECT * FROM pedals JOIN instruments ON pedals.id = instruments.id WHERE pedals.id = :id")
                        .addParameter("id", id)
                        .executeAndFetch(Pedal.class);
                for (Pedal pedal: pedalsByInstrumentId) {
                    pedalsByModel.add(pedal);
                }
            }
            for ( Pedal pedal : pedalsByModel ) {
                searchedPedals.add(pedal);
            }
            return searchedPedals;
        }

    }
}