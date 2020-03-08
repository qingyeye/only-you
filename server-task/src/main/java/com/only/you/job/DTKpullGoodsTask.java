package com.only.you.job;

import com.only.you.service.jobservice.DTKpullGoodsService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class DTKpullGoodsTask implements Job, Serializable {

    private static final Logger log = LoggerFactory.getLogger(DTKpullGoodsTask.class);

    @Autowired
    private DTKpullGoodsService dTKpullGoodsService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("*********************开始执行DTK列表拉取商品**********************{}",new Date());

        dTKpullGoodsService.insertDTKGoods();

        log.info("*********************结束执行DTK列表拉取商品**********************{}",new Date());
    }
}
