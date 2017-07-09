package xyz.zhtdemo.bbs.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.TardelogDao;
import xyz.zhtdemo.bbs.entity.TardelogEnt;
import xyz.zhtdemo.bbs.inter.TardelogService;
@Service("tardelogService")
public class TardelogServiceImpl implements TardelogService{

	@Resource
	TardelogDao td;
	
	public boolean insertTarde(TardelogEnt te) {
		return td.insertTarde(te)>0;
	}

	public List<TardelogEnt> getTardelogList(TardelogEnt te) {
		
		return td.getTardelogList(te);
	}

	public TardelogEnt getTardelog(TardelogEnt te) {
		
		return td.getTardelog(te);
	}

	public Map<Integer, TardelogEnt> getTardelogMap(TardelogEnt te) {
		Map<Integer, TardelogEnt> map=new Hashtable<Integer, TardelogEnt>();
		List<TardelogEnt> list=td.getTardelogList(te);
		for (TardelogEnt t : list) {
			map.put(t.getAid(), t);
		}
		
		return map;
	}

}
