package com.springbootdatabase.dao;

import com.springbootdatabase.model.DataModel;
import com.springbootdatabase.model.Jsonreturn;

import java.util.HashMap;
import java.util.List;

public interface DataDao {
    //HashMap<String,Jsonreturn> getSang(DataModel dataModel);
    List<Jsonreturn> getSang(DataModel dataModel);
    List<Jsonreturn> getSung(DataModel dataModel);
    List<Jsonreturn> getPeople(DataModel dataModel);
    List<Jsonreturn> getPur(DataModel dataModel);

}
