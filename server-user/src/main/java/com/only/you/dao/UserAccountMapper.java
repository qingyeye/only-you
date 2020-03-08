package com.only.you.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.you.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountMapper extends BaseMapper<User> {

    int insertUserReturnId(User user);

    User getUserByUserId(User user);
}
