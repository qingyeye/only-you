package com.only.you.service;


import com.only.you.entity.QuartzEntity;
import java.util.List;


public interface IJobService {
	
    List<QuartzEntity> listQuartzEntity(QuartzEntity quartz, Integer pageNo, Integer pageSize);
    
    Long countEntity(QuartzEntity quartz);
}
