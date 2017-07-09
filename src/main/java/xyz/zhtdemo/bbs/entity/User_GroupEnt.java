package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class User_GroupEnt implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer gid;
	private String gname;
	private Integer integral_max;
	private Integer integral_mini;
	private Short allowvisit;
	private Integer access_rights;
	private String group_type;
	
	@Override
	public String toString() {
		return "User_GroupEnt [gid=" + gid + ", gname=" + gname + ", integral_max=" + integral_max + ", integral_mini="
				+ integral_mini + ", allowvisit=" + allowvisit + ", access_rights=" + access_rights + ", group_type="
				+ group_type + "]";
	}

	public User_GroupEnt(Integer gid, String gname, Integer integral_max, Integer integral_mini, Short allowvisit,
			Integer access_rights, String group_type) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.integral_max = integral_max;
		this.integral_mini = integral_mini;
		this.allowvisit = allowvisit;
		this.access_rights = access_rights;
		this.group_type = group_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
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
		User_GroupEnt other = (User_GroupEnt) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		return true;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getIntegral_max() {
		return integral_max;
	}

	public void setIntegral_max(Integer integral_max) {
		this.integral_max = integral_max;
	}

	public Integer getIntegral_mini() {
		return integral_mini;
	}

	public void setIntegral_mini(Integer integral_mini) {
		this.integral_mini = integral_mini;
	}

	public Short getAllowvisit() {
		return allowvisit;
	}

	public void setAllowvisit(Short allowvisit) {
		this.allowvisit = allowvisit;
	}

	public Integer getAccess_rights() {
		return access_rights;
	}

	public void setAccess_rights(Integer access_rights) {
		this.access_rights = access_rights;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public User_GroupEnt() {
		
	}
	
}
