package com.only.you.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.you.entity.QuartzEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiao_XX on 2018/1/30.
 *
 */
@Repository
public interface QuartzEntityMapper extends BaseMapper<QuartzEntity> {


//    @Select("SELECT job.JOB_NAME as jobName,job.JOB_GROUP as jobGroup,job.DESCRIPTION as description,job.JOB_CLASS_NAME as jobClassName,\n" +
//            "\t\tcron.CRON_EXPRESSION as cronExpression,tri.TRIGGER_NAME as triggerName,tri.TRIGGER_STATE as triggerState,\n" +
//            "\t\tjob.JOB_NAME as oldJobName,job.JOB_GROUP as oldJobGroup\n" +
//            "\t\tFROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME\n" +
//            "\t\tLEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME\n" +
//            "\t\tWHERE tri.TRIGGER_TYPE = 'CRON'   AND job.JOB_NAME =  ${jobname}")
    List<QuartzEntity> listQuartzEntity(@Param("jobname") String jobname);


    /**
     * 查询对象列表，返回List<Map<key,value>>
     * @return  List<T>
     * @Date	2018年3月15日
     * 更新日志
     * 2018年3月15日  张志朋  首次创建
     *
     */
    @Select("SELECT COUNT(*)" +
            "FROM QRTZ_JOB_DETAILS AS job LEFT JOIN QRTZ_TRIGGERS AS tri ON job.JOB_NAME = tri.JOB_NAME  \n" +
            "LEFT JOIN QRTZ_CRON_TRIGGERS AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME \n" +
            "WHERE tri.TRIGGER_TYPE = 'CRON'")
    long countEntity();
}
