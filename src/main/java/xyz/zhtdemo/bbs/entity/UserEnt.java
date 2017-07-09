package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

/**
 * 用户信息
 * @author zheng
 *
 */
public class UserEnt implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private String email;
	private Integer id;
	private String portrait;
	private Integer gid;
	private Integer agid;
	private User_CountEnt uie;
	
	public UserEnt(String user, String password, String email, Integer id, String portrait, Integer gid, Integer agid,
			User_CountEnt uie) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.id = id;
		this.portrait = portrait;
		this.gid = gid;
		this.agid = agid;
		this.uie = uie;
	}

	@Override
	public String toString() {
		return "UserEnt [user=" + user + ", password=" + password + ", email=" + email + ", id=" + id + ", portrait="
				+ portrait + ", gid=" + gid + ", agid=" + agid + ", uie=" + uie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserEnt other = (UserEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getAgid() {
		return agid;
	}

	public void setAgid(Integer agid) {
		this.agid = agid;
	}

	public User_CountEnt getUie() {
		return uie;
	}

	public void setUie(User_CountEnt uie) {
		this.uie = uie;
	}

	public UserEnt() {
		
	}
	
}
