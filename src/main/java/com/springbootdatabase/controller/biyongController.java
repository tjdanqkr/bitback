package com.springbootdatabase.controller;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class biyongController {
    @Autowired
    private BiyongService biyongService;

    @ResponseBody//select
    @RequestMapping(value="/api/biyong1",method= RequestMethod.POST)
    public Map biyong1(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("utf-8");
        Biyong biyong1 = new Biyong();
        biyong1.setId(post.get("id").toString());

        Biyong biyong = biyongService.printbiyong(biyong1);
        biyongService.deletebiyong(biyong1);
        return null;
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
