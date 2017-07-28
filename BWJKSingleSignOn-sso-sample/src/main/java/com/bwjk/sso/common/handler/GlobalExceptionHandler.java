package com.bwjk.sso.common.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjk.common.basedto.BaseReponseDTO;
import com.bwjk.common.basedto.ErrorInfo;
import com.bwjk.common.exception.BusinessException;
import com.bwjk.sso.common.enums.ErrorCodeEnum;
import com.bwjk.sso.common.util.ErrorUtil;

/**
 * Created by zxl on 2017/7/12.
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
	public BaseReponseDTO testException(HttpServletRequest request, Exception ex) {
		BaseReponseDTO responseDTO = new BaseReponseDTO();
		if (ex instanceof MethodArgumentNotValidException) {
			LOGGER.warn("参数校验错误。");
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
			responseDTO.addAllErrors(ErrorUtil.convertToErrorInfo(exception.getBindingResult().getAllErrors()));

		} else if (ex instanceof BusinessException) {
			LOGGER.error("业务 异常.", ex);
			BusinessException exception = (BusinessException) ex;
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setMessage(exception.getBusinessMessage());
			errorInfo.setCode(exception.getCode());
			errorInfo.setType(exception.getType());
			responseDTO.addError(errorInfo);
		}else if(ex instanceof HttpMessageNotReadableException){
			responseDTO.addError(ErrorUtil.buildError(ErrorCodeEnum.ERR_INVAILD_REQUEST_BODY));
		}else{
			LOGGER.error("未知 异常.", ex);
			responseDTO.addError(ErrorUtil.buildError(ErrorCodeEnum.ERR_SYSTEM));
		}

		return responseDTO;
	}
    
    @ModelAttribute
    public void newUser() {
        //System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
       // System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }
}
