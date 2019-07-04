package com.sdju.bilibili.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Bilibili {
    private String id;
    private String b_date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String adj_close;
    private String volume;
}
