package com.zanyun.common.base;



import java.util.Map;

public class ReturnMessage {

	private String msgValue;
	private String msgText;
	private String msgPrompt;
	private Map<String, Object> msgReturnMap;

	public ReturnMessage() {
		super();
	}

	public ReturnMessage(String msgValue, String msgText) {
		super();
		this.msgValue = msgValue;
		this.msgText = msgText;
	}

	public ReturnMessage(String msgValue, String msgText, String msgPrompt) {
		super();
		this.msgValue = msgValue;
		this.msgText = msgText;
		this.msgPrompt = msgPrompt;
	}

	public ReturnMessage(String msgValue, String msgText, String msgPrompt,
			Map<String, Object> msgReturnMap) {
		super();
		this.msgValue = msgValue;
		this.msgText = msgText;
		this.msgPrompt = msgPrompt;
		this.msgReturnMap = msgReturnMap;
	}

	public String getMsgValue() {
		return msgValue;
	}

	public void setMsgValue(String msgValue) {
		this.msgValue = msgValue;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public String getMsgPrompt() {
		return msgPrompt;
	}

	public void setMsgPrompt(String msgPrompt) {
		this.msgPrompt = msgPrompt;
	}

	public Map<String, Object> getMsgReturnMap() {
		return msgReturnMap;
	}

	public void setMsgReturnMap(Map<String, Object> msgReturnMap) {
		this.msgReturnMap = msgReturnMap;
	}

}
