package com.Demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("user")
public class User implements Serializable {
    private int id;

    private String name;
    private String address;
    private String phone;
}
