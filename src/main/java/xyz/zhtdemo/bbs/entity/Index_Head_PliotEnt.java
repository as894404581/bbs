package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class Index_Head_PliotEnt  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pliot_name;
	private String pliot_url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPliot_name() {
		return pliot_name;
	}
	public void setPliot_name(String pliot_name) {
		this.pliot_name = pliot_name;
	}
	public String getPliot_url() {
		return pliot_url;
	}
	public void setPliot_url(String pliot_url) {
		this.pliot_url = pliot_url;
	}
	public Index_Head_PliotEnt(Integer id, String pliot_name, String pliot_url) {
		super();
		this.id = id;
		this.pliot_name = pliot_name;
		this.pliot_url = pliot_url;
	}
	@Override
	public String toString() {
		return "Index_Head_PliotEnt [id=" + id + ", pliot_name=" + pliot_name + ", pliot_url=" + pliot_url + "]";
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
		Index_Head_PliotEnt other = (Index_Head_PliotEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Index_Head_PliotEnt() {
		
	}
}
