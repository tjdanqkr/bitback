package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberModel {
    private String id;
    private String password ;
    private String name;
    private int age;


    public void setId(String id)
    {
        this.id = id;
    }
    public void setPassword(String password)    {
        this.password = password;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
}


