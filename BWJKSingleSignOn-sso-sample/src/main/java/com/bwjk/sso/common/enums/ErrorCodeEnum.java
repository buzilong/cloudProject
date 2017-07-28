package com.bwjk.sso.common.enums;

public enum ErrorCodeEnum {

	
	ERR_SYSTEM("E10000000","E","未知系统异常。"),
	ERR_SESSION_TIMEOUT("E10000001","E","会话超时。"),
	ERR_USERNAME_PWD_ERROR("E10000002","E","用户名密码错误"),
	ERR_INVAILD_REQUEST_BODY("E10000004","E","无效的请求体."),
	ERR_INVAILD_TOKEN("E10000003","E","无效的token."),
	ERR_PARAMETER_VALIDATE_FAILE("E10000005","V","无效的参数。");
	
	private String code;
	private String actionType;
	private String message;
	private ErrorCodeEnum(String code, String actionType, String message) {
		this.code = code;
		this.actionType = actionType;
		this.message=message;
	}
	
	public static ErrorCodeEnum valueIn(String orgs){
		for (ErrorCodeEnum enumz : ErrorCodeEnum.values()) {
			if (enumz.getCode().equals(orgs)) {
				return enumz;
			}
		}
		return null;
	}

	public String getCode() {
		return this.code;
	}
	public String getActionType(){
		return this.actionType;
	}

	public String getMessage() {
		return message;
	}
	
}

