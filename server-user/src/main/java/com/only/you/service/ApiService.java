package com.only.you.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.you.entity.User;

public interface ApiService extends IService<User> {

    String test();
}
