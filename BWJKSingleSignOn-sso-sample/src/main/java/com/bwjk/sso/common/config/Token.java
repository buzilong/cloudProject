package com.bwjk.sso.common.config;

import org.springframework.beans.factory.annotation.Value;

public class Token {
	
	@Value("${token.secretkey")
	private String  tokenSecretKey;
	
}
