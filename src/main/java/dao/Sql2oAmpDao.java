package dao;

import models.Amp;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
            String ampSql = "INSERT INTO amps (id, instrument, type, power, cabinetWood, finish, grillCloth, width, depth, height, electronics, speakers, tubes, reverb, tremolo, externalSpeaker, knobs, jewelLight, controlPanel, logo, tiltLegs, feet, controls, cover) VALUES (:id, :instrument,  :type, :power, :cabinetWood, :finish, :grillCloth, :width, :depth, :height, :electronics, :speakers, :tubes, :reverb, :tremolo, :externalSpeaker, :knobs, :jewelLight, :controlPanel, :logo, :tiltLegs, :feet, :controls, :cover)";
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
}