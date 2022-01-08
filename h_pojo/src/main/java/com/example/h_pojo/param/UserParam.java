package com.example.h_pojo.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserParam implements Serializable {

    private String name;
    private String passWord;
}
