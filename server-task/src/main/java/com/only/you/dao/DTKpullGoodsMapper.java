package com.only.you.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.you.entity.jobentity.DTKResponse;
import com.only.you.entity.jobentity.DtkGoods;
import com.only.you.entity.jobentity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface DTKpullGoodsMapper extends BaseMapper<DtkGoods> {
}
