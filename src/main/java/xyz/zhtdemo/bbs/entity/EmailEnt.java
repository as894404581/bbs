package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

/**
 * 邮箱信息实体类
 * @author zheng
 *
 */
public class EmailEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String email;
	private String email_check;
	private String email_url;
	
	
	public EmailEnt(Integer uid, String email, String email_check, String email_url) {
		super();
		this.uid = uid;
		this.email = email;
		this.email_check = email_check;
		this.email_url = email_url;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		EmailEnt other = (EmailEnt) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EmailEnt [uid=" + uid + ", email=" + email + ", email_check=" + email_check + ", email_url=" + email_url
				+ "]";
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public EmailEnt() {
		
	}
	
}
