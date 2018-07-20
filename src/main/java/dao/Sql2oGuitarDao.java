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
        String instrumentSql = "INSERT INTO instruments (manufacturer, model, country, serialNumber, year, weight, imageUrl, current, wishlist, paid, sold) VALUES (:manufacturer, :model, :country, :serialNumber, :year, :weight, :imageUrl, :current, :wishlist, :paid, :sold)";
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
}
