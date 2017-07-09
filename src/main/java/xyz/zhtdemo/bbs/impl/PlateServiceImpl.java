package xyz.zhtdemo.bbs.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.PlateDao;
import xyz.zhtdemo.bbs.dao.PostDao;
import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.SearchEnt;
import xyz.zhtdemo.bbs.error.URLException;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.util.SacheData;

@Service("plateService")
public  class PlateServiceImpl implements PlateService {

	@Resource
	private PostDao p;
	@Resource
	private PlateDao h;

	public PlateEnt getForumInfo(int fid) throws URLException{
		PlateEnt pe=SacheData.PlateMap.get(fid);
		if(pe==null){
			throw new URLException("访问路径不存在");
		}
		return pe;
	}

	public List<PostEnt> getPost(int fid, int page1) {
		return p.getPostList(fid, page1);
	}
	
	public List<SearchEnt> search(String name,int page1){
		return p.search("%"+name+"%",page1);
	}
	public int updatePlateLast_issue(int fid,Long last_issue) {
		PlateEnt pe=new PlateEnt();
		pe.setId(fid);
		pe.setLast_issue(last_issue);
		return h.updatePlateById(pe);
	}

	public int post_countUp(int fid) {
		PlateEnt pe=new PlateEnt();
		pe.setId(fid);
		pe.setPost_count(SacheData.PlateMap.get(fid).getPost_count()+1);
		return h.updatePlateById(pe);
	}

	public int reply_countUp(int fid) {
		PlateEnt pe=new PlateEnt();
		pe.setId(fid);
		pe.setReply_count(SacheData.PlateMap.get(fid).getReply_count()+1);
		return h.updatePlateById(pe);
	}

	public Map<PlateEnt, List<PlateEnt>> getIndexPlateMap() {
		Map<PlateEnt, List<PlateEnt>> map=new HashMap<PlateEnt, List<PlateEnt>>();
		for (Integer i : SacheData.PlateMap.keySet()) {
			if(SacheData.PlateMap.get(i).getPtype().equals(PlateEnt.GROUP)){
				map.put(SacheData.PlateMap.get(i),new ArrayList<PlateEnt>());
			}
		}
		for (Integer i : SacheData.PlateMap.keySet()) {
			if(SacheData.PlateMap.get(i).getPtype().equals(PlateEnt.PLATE)){
				for (PlateEnt is : map.keySet()) {
					if(is.getPtype().equals(PlateEnt.GROUP) && SacheData.PlateMap.get(i).getPup()==is.getId()){
						map.get(is).add(SacheData.PlateMap.get(i));
					}
				}
				
			}
		}
		return map;
	}

}
