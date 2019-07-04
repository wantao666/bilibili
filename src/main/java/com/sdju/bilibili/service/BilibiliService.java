package com.sdju.bilibili.service;

import com.sdju.bilibili.vo.Bilibili;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface BilibiliService {
    @Select("select * from bilibili_action order by b_date desc")
     List<Bilibili> selectAll();
}
