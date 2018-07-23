package dao;

import models.Pedal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
            String pedalSql = "INSERT INTO pedals (id, type, power, trueBypass, width, depth, height, electronics, inputImpedance, outputImpedance, currentDraw, features, controls) VALUES (:id,  :type, :power, :trueBypass, :width, :depth, :height, :electronics, :inputImpedance, :outputImpedance, :currentDraw, :features, :controls)";
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
}