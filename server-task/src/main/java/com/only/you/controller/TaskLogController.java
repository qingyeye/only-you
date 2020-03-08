package com.only.you.controller;

import com.github.pagehelper.PageInfo;
import com.only.you.response.ServerResponse;
import com.only.you.service.TaskLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xierq
 * @return
 * @date 2020/3/4 15:26
 */
@RestController
@RequestMapping("/task/log")
public class TaskLogController {

    private static final Logger log = LoggerFactory.getLogger(TaskLogController.class);
    @Autowired
    private TaskLogService taskLogService;
    @RequestMapping(value = "taskLogList", method = RequestMethod.POST)
    public ServerResponse<PageInfo> getTaskLog(String taskName, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return taskLogService.getTaskLog(taskName,pageNum,pageSize);
    }
}
