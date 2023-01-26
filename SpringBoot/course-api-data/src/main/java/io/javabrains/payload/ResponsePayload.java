package io.javabrains.payload;

public class ResponsePayload {
	
	public boolean success;
	public String message;
	public Object payload;
	
	public ResponsePayload(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public ResponsePayload(boolean success, String message, Object payload) {
		super();
		this.success = success;
		this.message = message;
		this.payload = payload;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}	
}
