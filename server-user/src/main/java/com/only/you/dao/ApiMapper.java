package com.only.you.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.you.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiMapper extends BaseMapper<User> {

    String getTest();
}
