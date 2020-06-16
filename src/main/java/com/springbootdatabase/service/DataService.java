package com.springbootdatabase.service;

import com.springbootdatabase.model.DataModel;
import com.springbootdatabase.model.Jsonreturn;
import com.springbootdatabase.model.MemberModel;

import java.util.HashMap;
import java.util.List;

public interface DataService {
   HashMap<String,List<Jsonreturn>> findData(DataModel data);
}
