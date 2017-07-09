package xyz.zhtdemo.bbs.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.dao.Index_Head_PliotDao;
import xyz.zhtdemo.bbs.entity.Index_Head_PliotEnt;
import xyz.zhtdemo.bbs.inter.Index_Head_PliotService;

@Component
public class Index_Head_PliotServiceImpl implements Index_Head_PliotService{
	@Resource
	Index_Head_PliotDao ihpd;
	
	public List<Index_Head_PliotEnt> getIndex_Head_Pliot() {
		
		return ihpd.getIndex_Head_PliotDao();
	}
	
}
