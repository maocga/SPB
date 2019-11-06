package com.skk.spb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    private  Integer cid;
    private String cname;
    private String color;
    private Double price;

}
