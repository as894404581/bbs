package xyz.zhtdemo.bbs.inter;

import java.util.Map;

import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;

public interface UpdateSacheDataService {
	public Map<Integer, PlateEnt> getMapPlateEnt();
	public Map<Integer, UserEnt> getUserList();
	
}
