package com.bwjk.sso.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwjk.common.exception.BusinessException;
import com.bwjk.sso.business.AuthBusiness;
import com.bwjk.sso.model.request.LoginRequestDTO;
import com.bwjk.sso.model.response.LoginResponseDTO;
import com.bwjk.sso.model.response.VerifyTokenResponseDTO;

@RestController()
@RequestMapping(path = "/auth")
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(AuthController.class);

	@Autowired
	private AuthBusiness authBusiness;

	@PostMapping(path = "/login")
	public LoginResponseDTO login(@Validated @RequestBody LoginRequestDTO loginRequestDTO,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws BusinessException {
		LOGGER.info("Enter in login controller ");
		LoginResponseDTO response = authBusiness.loginByAccNameAndPassword(loginRequestDTO);
		if (response != null) {
			Cookie cookie = new Cookie("bwjk_ssotoken", response.getToken());
			httpResponse.addCookie(cookie);
		}
		return response;
	}

	@GetMapping(path = "/verify/token/{token}")
	public VerifyTokenResponseDTO verify(@Validated @NotEmpty @PathVariable String token,
			HttpServletRequest httpRequest) throws BusinessException {
		LOGGER.info("Enter in login controller ");
		return authBusiness.verifyToken(token);
	}

}
