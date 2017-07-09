package xyz.zhtdemo.bbs.inter;

import java.util.List;
import java.util.Map;

import xyz.zhtdemo.bbs.entity.TardelogEnt;

public interface TardelogService {
	public boolean insertTarde(TardelogEnt te);
	public List<TardelogEnt> getTardelogList(TardelogEnt te);
	public TardelogEnt getTardelog(TardelogEnt te);
	public Map<Integer, TardelogEnt> getTardelogMap(TardelogEnt te);
}
