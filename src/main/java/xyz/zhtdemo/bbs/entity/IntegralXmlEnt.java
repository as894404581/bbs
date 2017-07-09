package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class IntegralXmlEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Double exchangeRate;
	private Boolean exchangeEnableOut;
	private Boolean exchangeEnableIn;
	private Boolean enable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Boolean getExchangeEnableOut() {
		return exchangeEnableOut;
	}
	public void setExchangeEnableOut(Boolean exchangeEnableOut) {
		this.exchangeEnableOut = exchangeEnableOut;
	}
	public Boolean getExchangeEnableIn() {
		return exchangeEnableIn;
	}
	public void setExchangeEnableIn(Boolean exchangeEnableIn) {
		this.exchangeEnableIn = exchangeEnableIn;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		IntegralXmlEnt other = (IntegralXmlEnt) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public IntegralXmlEnt(String name, Double exchangeRate, Boolean exchangeEnableOut, Boolean exchangeEnableIn,
			Boolean enable) {
		super();
		this.name = name;
		this.exchangeRate = exchangeRate;
		this.exchangeEnableOut = exchangeEnableOut;
		this.exchangeEnableIn = exchangeEnableIn;
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "IntegralXmlEnt [name=" + name + ", exchangeRate=" + exchangeRate + ", exchangeEnableOut="
				+ exchangeEnableOut + ", exchangeEnableIn=" + exchangeEnableIn + ", enable=" + enable + "]";
	}
	public IntegralXmlEnt() {
		
	}
}
