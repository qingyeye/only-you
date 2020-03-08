package com.only.you.entity.jobentity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
@TableName("app_user")
public class User implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("age")
    private String age;
    @JsonProperty("user_name")
    private String userName;
}
