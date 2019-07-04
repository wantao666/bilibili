package com.sdju.bilibili.controller;

import com.sdju.bilibili.service.BilibiliService;
import com.sdju.bilibili.vo.Bilibili;
import com.sdju.bilibili.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BilibiliController {
    @Autowired
    private BilibiliService bilibiliService;
    //开盘价格
    @RequestMapping("/")
    public String  open(){
        List<Bilibili> bilibiliList=bilibiliService.selectAll();
        return "open";
    }
    //收盘价格
    @RequestMapping("/close")
    public String  close(){
        List<Bilibili> bilibiliList=bilibiliService.selectAll();
        return "close";
    }
    //每日开收盘对比价格
    @RequestMapping("/open_close")
    public String  open_close(){
        List<Bilibili> bilibiliList=bilibiliService.selectAll();
        return "open_close";
    }
    //盈亏对比
    @RequestMapping("/open_close_rate")
    public String  open_close_rate(){
        List<Bilibili> bilibiliList=bilibiliService.selectAll();
        return "open_close_rate";
    }
    @RequestMapping("/data")
    @ResponseBody
    public Message data(){
        int victory=0;
        int defeat=0;
        int normal=0;
        List<Bilibili> bilibiliList=bilibiliService.selectAll();
        for (Bilibili bilibili:bilibiliList){
            if (Double.valueOf(bilibili.getClose())>Double.valueOf(bilibili.getOpen())){
                   victory++;
            }
            if (Double.valueOf(bilibili.getClose())<Double.valueOf(bilibili.getOpen())){
                defeat++;
            }
            if (Double.valueOf(bilibili.getClose())==Double.valueOf(bilibili.getOpen())){
                normal++;
            }
        }
        return new Message().success().add("bilibiliList",bilibiliList).add("victory",victory)
                .add("defeat",defeat).add("normal",normal);
    }
}
