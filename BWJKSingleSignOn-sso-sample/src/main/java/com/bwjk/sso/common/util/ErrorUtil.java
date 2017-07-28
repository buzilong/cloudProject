/**
 * 
 */
package com.bwjk.sso.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.ObjectError;

import com.bwjk.common.basedto.ErrorInfo;
import com.bwjk.common.basedto.ValidationError;
import com.bwjk.sso.common.enums.ErrorCodeEnum;

public class ErrorUtil {

	private ErrorUtil() {

	}
	
	/**
	 * Convert field validation errors to ErrorInfo which can be used for display.
	 * 
	 * @param errorList
	 * @return
	 */
	public static List<ErrorInfo> convertToErrorInfo(List<ObjectError> errorList) {
		ArrayList<ErrorInfo> errors = new ArrayList<>();
		for (ObjectError errorInfo : errorList) {
			String defaultMessage = ((MessageSourceResolvable) errorInfo.getArguments()[0]).getDefaultMessage();
			String fieldName;
			if (defaultMessage.lastIndexOf('.') != -1) {
				fieldName = defaultMessage.substring(defaultMessage.lastIndexOf('.') + 1);
			} else {
				fieldName = defaultMessage;
			}
			ValidationError errorInfoDto = new ValidationError();
			errorInfoDto.setCode(ErrorCodeEnum.ERR_PARAMETER_VALIDATE_FAILE.getCode());
			errorInfoDto.setMessage(errorInfo.getDefaultMessage());
			errorInfoDto.setType(ErrorCodeEnum.ERR_PARAMETER_VALIDATE_FAILE.getActionType());
			errorInfoDto.setFieldName(fieldName);
			errors.add(errorInfoDto);
		}
		return errors;
	}
	
	public static ErrorInfo buildError(ErrorCodeEnum errorCodeEnum){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCode(errorCodeEnum.getCode());
		errorInfo.setMessage(errorCodeEnum.getMessage());
		errorInfo.setType(errorCodeEnum.getActionType());
		return errorInfo;
		
	}
}
