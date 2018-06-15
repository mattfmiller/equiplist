package dao;

import models.Instrument;

import java.util.List;

public interface InstrumentDao {
    //READ
    List<Instrument> getAll();
    Instrument findById(int id);
    List<Instrument> getAllInstrumentsByInstrumentTypeId();


}
