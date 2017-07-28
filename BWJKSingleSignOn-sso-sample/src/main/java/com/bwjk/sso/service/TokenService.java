package com.bwjk.sso.service;

import com.bwjk.common.exception.BusinessException;


public interface TokenService {

	/**
	 * Get encoded token 
	 * @param userId
	 * @return
	 * @throws BusinessException 
	 */
	public String generateToken(String userId) throws BusinessException;
}
