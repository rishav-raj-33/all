package com.glowTemp.com.exception;

public class ErrorResponse {
	
	private String meassage;
	private boolean success;
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ErrorResponse(String meassage, boolean success) {
		super();
		this.meassage = meassage;
		this.success = success;
	}
	public ErrorResponse() {
		
	}

}
