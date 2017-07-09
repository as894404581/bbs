package xyz.zhtdemo.bbs.dao;

import java.util.List;

import xyz.zhtdemo.bbs.entity.TardelogEnt;

public interface TardelogDao {
	public int insertTarde(TardelogEnt te);
	public List<TardelogEnt> getTardelogList(TardelogEnt te);
	public TardelogEnt getTardelog(TardelogEnt te);
}
