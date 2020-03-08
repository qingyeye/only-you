package com.only.you.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.only.you.dao.TaskLogMapper;
import com.only.you.entity.TaskLog;
import com.only.you.response.ServerResponse;
import com.only.you.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @return
 * @author zzf
 * @date 2020/1/13 15:12
 */
@Service
public class TaskLogServiceImpl implements TaskLogService {

    @Autowired
    private TaskLogMapper taskLogMapper;
    /**
     * 查询所有日志
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getTaskLog(String taskName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TaskLog> taskLog = taskLogMapper.getTaskLog(taskName);
        if (taskLog.size()>0 && taskLog!=null){
            return ServerResponse.createBySuccess("查询成功",new PageInfo(taskLog));
        }
        return ServerResponse.createByErrorMessage("查询失败");
    }

    /**
     * 添加日志
     * @param taskLog
     * @return
     */
    @Override
    public ServerResponse insertTaskLog(TaskLog taskLog) {
        int i = taskLogMapper.insertTaskLog(taskLog);
        if (i>0){
            return ServerResponse.createBySuccessCodeMessage(200,"添加数据成功");
        }
        return ServerResponse.createByErrorMessage("添加数据失败");
    }

    /**
     * 修改日志
     * @param taskLog
     * @return
     */
    @Override
    public ServerResponse updateTaskLog(TaskLog taskLog,Long taskId) {
        int i = taskLogMapper.updateTaskLog(taskLog,taskId);
        if (i>0){
            return ServerResponse.createBySuccessCodeMessage(200,"修改数据成功");
        }
        return ServerResponse.createByErrorMessage("修改数据失败");
    }


}
