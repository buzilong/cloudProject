package com.bwjk.sso.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwjk.common.basedto.AuthInfo;
import com.bwjk.common.exception.BusinessException;
import com.bwjk.sso.common.enums.ErrorCodeEnum;
import com.bwjk.sso.db.entity.UserAuthEntity;
import com.bwjk.sso.db.mapper.UserAuthMapper;
import com.bwjk.sso.model.request.LoginRequestDTO;
import com.bwjk.sso.model.response.LoginResponseDTO;
import com.bwjk.sso.model.response.VerifyTokenResponseDTO;
import com.bwjk.sso.service.RedisClient;
import com.bwjk.sso.service.TokenService;

@Service
public class AuthBusiness {
	
	@Autowired
	private UserAuthMapper userAuthMapper;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private RedisClient redisClient;
	
	public LoginResponseDTO loginByAccNameAndPassword(LoginRequestDTO loginRequestDTO) throws BusinessException {

		LoginResponseDTO responseDTO = null;
		UserAuthEntity userAuth = userAuthMapper.getByAccNameAndPassword(loginRequestDTO.getUserName(),
				loginRequestDTO.getPassword());
		if (userAuth != null) {
			AuthInfo authInfo =generateAuthInfo(userAuth);
			//generate Auth info
			String token=tokenService.generateToken(String.valueOf(userAuth.getId()));
			//save to redis
			redisClient.set(token, authInfo);
			redisClient.refreshExpire(token, 600);
			//build response 
			responseDTO = new LoginResponseDTO();
			responseDTO.setToken(token);
			responseDTO.setUserId(userAuth.getUserId());
		}else{
			throw new BusinessException("用户名或密码错误", ErrorCodeEnum.ERR_USERNAME_PWD_ERROR.getCode(),ErrorCodeEnum.ERR_USERNAME_PWD_ERROR.getActionType());
		}
		return responseDTO;
	}
	
	public VerifyTokenResponseDTO verifyToken(String token) throws BusinessException {
		
		VerifyTokenResponseDTO responseDTO = null;
		
		AuthInfo authInfo = redisClient.get(token, AuthInfo.class);

		if (authInfo != null) {
			//刷新token过期时间
			redisClient.refreshExpire(token, 600);
			responseDTO = new VerifyTokenResponseDTO();
			responseDTO.setUserId(authInfo.getUserId());
			responseDTO.setValid(true);
		}else{
			throw new BusinessException("无效的token", ErrorCodeEnum.ERR_INVAILD_TOKEN.getCode(),ErrorCodeEnum.ERR_INVAILD_TOKEN.getActionType());
		}
		return responseDTO;

	}
	
	private AuthInfo generateAuthInfo(UserAuthEntity userAuth) throws BusinessException{
		AuthInfo authInfo= new AuthInfo();
		authInfo.setAccName(userAuth.getAccName());
		//authInfo.setLoginTime(new Date());
		authInfo.setUserId(userAuth.getUserId());
		authInfo.setRefreshTime(System.currentTimeMillis());
		return authInfo;
	}
}
