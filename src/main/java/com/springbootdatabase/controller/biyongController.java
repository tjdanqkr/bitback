package com.springbootdatabase.controller;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;
import com.springbootdatabase.model.predictyear;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

@RestController
public class biyongController {
    @Autowired
    private BiyongService biyongService;

    @ResponseBody//
    @RequestMapping(value="/api/biyong1",method= RequestMethod.POST)
    public List<Map<String,String>> biyong1(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("utf-8");

        Biyong biyong1 = new Biyong();
        biyong1.setId(post.get("id").toString());

        hap biyong = biyongService.happrintbiyong(biyong1);

        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/yearchui";
        map.put("dong",post.get("dong").toString());//request로 날아오는것에서 원하는 정보 빼줌
        HttpEntity<?> entity = new HttpEntity<>(map);
        ResponseEntity<predictyear[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, predictyear[].class);
        System.out.println(responseEntity.getBody());

        predictyear[] a=responseEntity.getBody();

        System.out.println(a.length);
        System.out.println(biyong.getHap());
        System.out.println(biyong.getDanga());
        Map<String,HashMap> outmap= new HashMap<String,HashMap>(); //map안에 제네릭 다 써줄 필요없음.
        List<Map<String,String>> list = new ArrayList<>();

        for(int i =0; i<a.length; i++){
            HashMap<String,String> inmap= new HashMap<String,String>();
            inmap.put("m2019",a[i].getM2019예측());
            inmap.put("m2020",a[i].getM2020예측());
            inmap.put("hap",biyong.getHap());
            inmap.put("danga",biyong.getDanga());
            inmap.put("gil",a[i].get상권_코드_명()); //길이름의 맵
            list.add(inmap);
        }
       // biyongService.deletebiyong(biyong1);
        return list;
    }

    @RequestMapping(value="/api/biyong",method=RequestMethod.POST) //insert
    public String biyong(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("utf-8");
        Biyong biyong1 = new Biyong();
        biyong1.setId(post.get("id").toString());
        biyong1.setG(Integer.parseInt(post.get("g").toString()));
        biyong1.setB(Integer.parseInt(post.get("b").toString()));
        biyong1.setD(Integer.parseInt(post.get("d").toString()));
        biyong1.setI(Integer.parseInt(post.get("i").toString()));
        biyong1.setBuild(Integer.parseInt(post.get("build").toString()));
        biyong1.setInte(Integer.parseInt(post.get("inte").toString()));
        biyong1.setSul(Integer.parseInt(post.get("sul").toString()));
        biyong1.setGa(Integer.parseInt(post.get("ga").toString()));
        biyong1.setGita(Integer.parseInt(post.get("gita").toString()));
        biyong1.setChong(Integer.parseInt(post.get("chong").toString()));
        biyong1.setYear(Integer.parseInt(post.get("year").toString()));
        biyong1.setMenth(Integer.parseInt(post.get("menth").toString()));
        biyong1.setIngun(Integer.parseInt(post.get("ingun").toString()));
        biyong1.setZeryo(Integer.parseInt(post.get("zeryo").toString()));
        biyong1.setGita2(Integer.parseInt(post.get("gita2").toString()));
        biyong1.setDanga(Integer.parseInt(post.get("danga").toString()));

        biyongService.insertbiyong(biyong1);
        return "입력완료";
    }
}
