package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class Attachment_UnusedEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	public final static String TYPE_IMG="img";
	public final static String TYPE_DOCUMENT="document";
	private Integer aid;
	private Integer uid;
	private Long upload_time;
	private String attachment_formerly;
	private Long attachment_size;
	private String attachment_url;
	private String a_type;
	private Integer access_rights;
	private Integer price;


	public Attachment_UnusedEnt(Integer aid, Integer uid, Long upload_time, String attachment_formerly,
			Long attachment_size, String attachment_url, String a_type, Integer access_rights, Integer price) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.upload_time = upload_time;
		this.attachment_formerly = attachment_formerly;
		this.attachment_size = attachment_size;
		this.attachment_url = attachment_url;
		this.a_type = a_type;
		this.access_rights = access_rights;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Attachment_UnusedEnt [aid=" + aid + ", uid=" + uid + ", upload_time=" + upload_time
				+ ", attachment_formerly=" + attachment_formerly + ", attachment_size=" + attachment_size
				+ ", attachment_url=" + attachment_url + ", a_type=" + a_type + ", access_rights=" + access_rights
				+ ", price=" + price + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
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
		Attachment_UnusedEnt other = (Attachment_UnusedEnt) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		return true;
	}


	public Integer getAid() {
		return aid;
	}


	public void setAid(Integer aid) {
		this.aid = aid;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public Long getUpload_time() {
		return upload_time;
	}


	public void setUpload_time(Long upload_time) {
		this.upload_time = upload_time;
	}


	public String getAttachment_formerly() {
		return attachment_formerly;
	}


	public void setAttachment_formerly(String attachment_formerly) {
		this.attachment_formerly = attachment_formerly;
	}


	public Long getAttachment_size() {
		return attachment_size;
	}


	public void setAttachment_size(Long attachment_size) {
		this.attachment_size = attachment_size;
	}


	public String getAttachment_url() {
		return attachment_url;
	}


	public void setAttachment_url(String attachment_url) {
		this.attachment_url = attachment_url;
	}


	public String getA_type() {
		return a_type;
	}


	public void setA_type(String a_type) {
		this.a_type = a_type;
	}


	public Integer getAccess_rights() {
		return access_rights;
	}


	public void setAccess_rights(Integer access_rights) {
		this.access_rights = access_rights;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Attachment_UnusedEnt() {
		
	}
	
}
