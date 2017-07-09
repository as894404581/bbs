package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class SettingEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "SettingEnt [key=" + key + ", value=" + value + "]";
	}
	public SettingEnt(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		SettingEnt other = (SettingEnt) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	public SettingEnt() {
		
	}
	
	
}
