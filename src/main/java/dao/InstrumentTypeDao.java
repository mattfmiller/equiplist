package dao;

import models.Instrument;
import models.InstrumentType;

import java.util.List;

public interface InstrumentTypeDao {

    //CREATE
    void add(InstrumentType instrumentType);

    //READ
    List<InstrumentType> getAll();
    InstrumentType findById(int id);
//    List<Instrument> getAllInstrumentsByInstrumentTypeId();

//    //UPDATE
//    void update(int id, String name);
//
//    //DELETE
//    void deleteById(int id);
}
