package com.springbootdatabase.service;

import com.springbootdatabase.model.Jsonreturn;
import com.springbootdatabase.model.Upjong;

import java.util.HashMap;
import java.util.List;

public interface UpjongService {

    HashMap<String, List<Upjong>> printUpjong(Upjong upjong);
}
