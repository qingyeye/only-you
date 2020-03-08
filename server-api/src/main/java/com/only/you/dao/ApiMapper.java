package com.only.you.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiMapper {

    void getTest(@Param("id") String id);
}
