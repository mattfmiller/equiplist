package dao;

import models.Pedal;

import java.util.List;

public interface PedalDao {
    //CREATE
    void add(Pedal pedal);

    //READ
    List<Pedal> getAllPedals();
    List<Pedal> getAllPedalsInCollection();
    List<Pedal> getAllPedalsInWishlist();
    List<Pedal> search(String query);

    //UPDATE
    void update(int id, Pedal pedal);

    //DELETE
    void delteteById(int id);
}