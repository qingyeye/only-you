package com.only.you.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zzf
 * @return
 * @date 2020/1/13 15:12
 */
@Getter
@Setter
@Data
@TableName("task_log")
public class TaskLog implements Serializable {

    private static final long serialVersionUID = 3254190710110093709L;

    //id
    @TableId(type = IdType.AUTO)
    private Long taskId;

    //任务名称
    private String taskName;

    //任务分组
    private String taskGroup;

    //任务描述
    private String taskDesc;

    //任务执行类
    private String taskExecClass;

    //任务执行开始时间
    private String taskStartTime;

    //任务执行结束时间
    private String taskEndTime;

    //任务运行时间
    private String taskRunTime;

}
