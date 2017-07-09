package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class SearchEnt implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer vid;
	private Integer fid;
	private String title;
	private Long issue_time;
	private String action;
	private Integer see_count;
	
	public SearchEnt(Integer vid, Integer fid, String title, Long issue_time, String action, Integer see_count) {
		super();
		this.vid = vid;
		this.fid = fid;
		this.title = title;
		this.issue_time = issue_time;
		this.action = action;
		this.see_count = see_count;
	}

	@Override
	public String toString() {
		return "SearchEnt [vid=" + vid + ", fid=" + fid + ", title=" + title + ", issue_time=" + issue_time
				+ ", action=" + action + ", see_count=" + see_count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vid == null) ? 0 : vid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchEnt other = (SearchEnt) obj;
		if (vid == null) {
			if (other.vid != null)
				return false;
		} else if (!vid.equals(other.vid))
			return false;
		return true;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getIssue_time() {
		return issue_time;
	}

	public void setIssue_time(Long issue_time) {
		this.issue_time = issue_time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getSee_count() {
		return see_count;
	}

	public void setSee_count(Integer see_count) {
		this.see_count = see_count;
	}

	public SearchEnt() {
		
	}
	
}
