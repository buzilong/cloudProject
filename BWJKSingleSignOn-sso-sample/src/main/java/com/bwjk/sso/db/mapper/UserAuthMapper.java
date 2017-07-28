package com.bwjk.sso.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.bwjk.sso.db.entity.UserAuthEntity;

public interface UserAuthMapper {
	
	public UserAuthEntity  getByAccNameAndPassword(@Param("accName") String accName, @Param("password") String password);
	
	}
