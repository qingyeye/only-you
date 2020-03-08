package com.only.you.dao;

import com.only.you.entity.TaskLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzf
 * @return
 * @date 2020/1/13 15:12
 */
@Repository
public interface TaskLogMapper {

    /**
     * 查询所有日志
     *
     * @return
     */
    List<TaskLog> getTaskLog(@Param("taskName") String taskName);

    /**
     * 添加日志
     *
     * @param taskLog
     * @return
     */
    int insertTaskLog(@Param("taskLog") TaskLog taskLog);

    /**
     * 修改日志
     *
     * @param taskLog
     * @return
     */
    int updateTaskLog(@Param("taskLog") TaskLog taskLog, @Param("taskId") Long taskId);
}
