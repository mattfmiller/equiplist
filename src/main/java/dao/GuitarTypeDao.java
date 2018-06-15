package dao;

import models.Guitar;
import models.GuitarType;

import java.util.List;

public interface GuitarTypeDao {
    //CREATE
    void add(GuitarType instrumentType);
    void addGuitarToGuitarType(Guitar guitar, GuitarType guitarType);

    //READ
    List<GuitarType> getAll();
    List<Guitar> getAllGuitarsByGuitarTypeId();
    GuitarType findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
}
