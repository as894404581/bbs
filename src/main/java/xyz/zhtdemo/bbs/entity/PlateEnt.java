package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;
/**
 * 论坛板块实体类
 * @author zheng
 *
 */
public class PlateEnt implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String GROUP="group";
	public static final String PLATE="plate";
	public static final String CHILD="child";
	private Integer id;
	private Integer pup;
	private String ptype;
	private String plate_name;
	private Long last_issue;
	private String img_url;
	private	Integer post_count;
	private Integer reply_count;
	private Short access_rights;
	
	

	public PlateEnt(Integer id, Integer pup, String ptype, String plate_name, Long last_issue, String img_url,
			Integer post_count, Integer reply_count, Short access_rights) {
		super();
		this.id = id;
		this.pup = pup;
		this.ptype = ptype;
		this.plate_name = plate_name;
		this.last_issue = last_issue;
		this.img_url = img_url;
		this.post_count = post_count;
		this.reply_count = reply_count;
		this.access_rights = access_rights;
	}



	@Override
	public String toString() {
		return "PlateEnt [id=" + id + ", pup=" + pup + ", ptype=" + ptype + ", plate_name=" + plate_name
				+ ", last_issue=" + last_issue + ", img_url=" + img_url + ", post_count=" + post_count
				+ ", reply_count=" + reply_count + ", access_rights=" + access_rights + "]";
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
		PlateEnt other = (PlateEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getPup() {
		return pup;
	}



	public void setPup(Integer pup) {
		this.pup = pup;
	}



	public String getPtype() {
		return ptype;
	}



	public void setPtype(String ptype) {
		this.ptype = ptype;
	}



	public String getPlate_name() {
		return plate_name;
	}



	public void setPlate_name(String plate_name) {
		this.plate_name = plate_name;
	}



	public Long getLast_issue() {
		return last_issue;
	}



	public void setLast_issue(Long last_issue) {
		this.last_issue = last_issue;
	}



	public String getImg_url() {
		return img_url;
	}



	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}



	public Integer getPost_count() {
		return post_count;
	}



	public void setPost_count(Integer post_count) {
		this.post_count = post_count;
	}



	public Integer getReply_count() {
		return reply_count;
	}



	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}



	public Short getAccess_rights() {
		return access_rights;
	}



	public void setAccess_rights(Short access_rights) {
		this.access_rights = access_rights;
	}



	public PlateEnt() {
		
	}
}

