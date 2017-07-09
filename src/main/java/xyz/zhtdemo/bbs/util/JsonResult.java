package xyz.zhtdemo.bbs.util;

import java.io.Serializable;

/**
 * 用于封装Ajax调用后的JSON返回值 其中正确返回值: {state:0,data:返回数据,message:错误信息} 错误返回值
 * {state:1,data:null,message:错误信息}
 * 
 * @author zheng
 *
 */
public class JsonResult implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	/** 返回是否成功的状态,0表示成功,1或其他值表示失败 */
	private int state;
	/**错误代码*/
	private int errorCode;
	/** 成功时返回JSON数据 */
	private Object data;
	/** 错误时返回的数据 */
	private String message;
	
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + ", errorCode="+errorCode+"]";
	}

	public int getState() {
		return state;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JsonResult(int state,int errorCode, Object data, String message) {
		super();
		this.state = state;
		this.errorCode=errorCode;
		this.data = data;
		this.message = message;
	}

	public JsonResult() {

	}

	public JsonResult(Throwable e,int errorCode) {
		state = ERROR;
		this.errorCode=errorCode;
		data=null;
		message=e.getMessage();
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
		message="";
	}
	public JsonResult(Object... data){
		state=SUCCESS;
		this.data=data;
		message="";
	}

}
