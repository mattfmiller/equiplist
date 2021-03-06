package dao;

import models.Amp;

import java.util.List;

public interface AmpDao {
    //CREATE
    void add(Amp amp);

    //    //READ
    List<Amp> getAllAmps();

    List<Amp> getAllAmpsInCollection();

    List<Amp> getAllAmpsInWishlist();

    List<Amp> search(String query);

    //UPDATE
    void update(int id, Amp amp);

    //DELETE
    void deleteById(int id);

    void clearAll();
}
