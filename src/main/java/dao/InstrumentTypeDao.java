package dao;

import models.Instrument;
import models.InstrumentType;

import java.util.List;

public interface InstrumentTypeDao {

    //CREATE
    void add(InstrumentType instrumentType);

    //READ
    List<InstrumentType> getAll();
//    List<Instrument> getAllInstrumentsByInstrumentTypeId();
    InstrumentType findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
}
