package com.only.you.service;

import com.github.pagehelper.PageInfo;
import com.only.you.entity.TaskLog;
import com.only.you.response.ServerResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @author zzf
 * @return
 * @date 2020/1/13 15:11
 */
public interface TaskLogService {

    /**
     * 查询所有日志
     *
     * @return
     */
    ServerResponse<PageInfo> getTaskLog(@Param("taskName") String taskName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 添加日志
     *
     * @param taskLog
     * @return
     */
        ServerResponse insertTaskLog(@Param("taskLog") TaskLog taskLog);

    /**
     * 修改日志
     *
     * @param taskLog
     * @return
     */
    ServerResponse updateTaskLog(@Param("taskLog") TaskLog taskLog, Long taskId);
}
