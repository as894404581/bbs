package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

import xyz.zhtdemo.bbs.enums.T_typeEnum;
import xyz.zhtdemo.bbs.enums.TradeTypeEnum;
/**
 * 交易日志
 * @author zheng
 *
 */
public  class TardelogEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private Integer uid;
	private Integer pid;
	private Integer aid;
	private Integer rid;
	private Integer price;
	private T_typeEnum t_type;
	private Long trade_time;
	private TradeTypeEnum trade_type;


	public TardelogEnt(Integer tid, Integer uid, Integer pid, Integer aid, Integer rid, Integer price,
			T_typeEnum t_type, Long trade_time, TradeTypeEnum trade_type) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.pid = pid;
		this.aid = aid;
		this.rid = rid;
		this.price = price;
		this.t_type = t_type;
		this.trade_time = trade_time;
		this.trade_type = trade_type;
	}


	@Override
	public String toString() {
		return "TardelogEnt [tid=" + tid + ", uid=" + uid + ", pid=" + pid + ", aid=" + aid + ", rid=" + rid
				+ ", price=" + price + ", t_type=" + t_type + ", trade_time=" + trade_time + ", trade_type="
				+ trade_type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		TardelogEnt other = (TardelogEnt) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}


	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public Integer getAid() {
		return aid;
	}


	public void setAid(Integer aid) {
		this.aid = aid;
	}


	public Integer getRid() {
		return rid;
	}


	public void setRid(Integer rid) {
		this.rid = rid;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public T_typeEnum getT_type() {
		return t_type;
	}


	public void setT_type(T_typeEnum t_type) {
		this.t_type = t_type;
	}


	public Long getTrade_time() {
		return trade_time;
	}


	public void setTrade_time(Long trade_time) {
		this.trade_time = trade_time;
	}


	public TradeTypeEnum getTrade_type() {
		return trade_type;
	}


	public void setTrade_type(TradeTypeEnum trade_type) {
		this.trade_type = trade_type;
	}


	public TardelogEnt() {
		
	}
}
