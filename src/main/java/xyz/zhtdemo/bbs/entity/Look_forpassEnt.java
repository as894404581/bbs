package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

/**
 * 找回密码实体类
 * @author zheng
 *
 */
public class Look_forpassEnt implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer users_id;
	private String email_check;
	private String email_url;
	public Look_forpassEnt(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUsers_id() {
		return users_id;
	}
	public void setUsers_id(Integer users_id) {
		this.users_id = users_id;
	}
	public String getEmail_check() {
		return email_check;
	}
	public void setEmail_check(String email_check) {
		this.email_check = email_check;
	}
	public String getEmail_url() {
		return email_url;
	}
	public void setEmail_url(String email_url) {
		this.email_url = email_url;
	}
	@Override
	public String toString() {
		return "Look_forpass [id=" + id + ", users_id=" + users_id + ", email_check=" + email_check + ", email_url="
				+ email_url + "]";
	}
	public Look_forpassEnt(Integer id, Integer users_id, String email_check, String email_url) {
		super();
		this.id = id;
		this.users_id = users_id;
		this.email_check = email_check;
		this.email_url = email_url;
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
		Look_forpassEnt other = (Look_forpassEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
