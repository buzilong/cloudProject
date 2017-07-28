package com.bwjk.sso.model.response;

import com.bwjk.common.basedto.BaseReponseDTO;

public class VerifyTokenResponseDTO extends BaseReponseDTO{

	private String userId;
	
	private boolean  valid;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
