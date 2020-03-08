package com.only.you.service.impl;




import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.only.you.dao.QuartzEntityMapper;
import com.only.you.entity.QuartzEntity;
import com.only.you.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImpl implements IJobService {

	@Autowired
	private QuartzEntityMapper quartzEntityMapper;

	@Override
	public List<QuartzEntity> listQuartzEntity(QuartzEntity quartz,
											   Integer pageNo, Integer pageSize) {
		Page<QuartzEntity> page = new Page<QuartzEntity>(pageNo,pageSize);
//		Page<QuartzEntity> page1 = quartzEntityMapper.listQuartzEntity(page, quartz.getJobName());
//		return page1.getRecords();

		return quartzEntityMapper.listQuartzEntity(quartz.getJobName());
	}

	@Override
	public Long countEntity(QuartzEntity quartz) {
		return quartzEntityMapper.countEntity();
	}
}
