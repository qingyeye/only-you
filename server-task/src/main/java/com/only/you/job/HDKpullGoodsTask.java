package com.only.you.job;

import com.only.you.service.jobservice.HDKpullGoodsService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class HDKpullGoodsTask implements Job, Serializable {

    @Autowired
    private HDKpullGoodsService hDKpullGoodsService;

    private static final Logger log = LoggerFactory.getLogger(DTKpullGoodsTask.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("*********************开始执行HDK列表拉取商品**********************{}",new Date());

        this.hDKpullGoodsService.updateHdkPullGoods();

        log.info("*********************结束执行HDK列表拉取商品**********************{}",new Date());
    }

}
