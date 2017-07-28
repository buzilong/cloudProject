package com.bwjk.sso.common.util;

import com.alibaba.fastjson.JSONObject;
import com.bwjk.sso.model.request.LoginRequestDTO;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

/**
 * Created by zxl on 2017/7/13.
 */
public class DataTypeConverter {

    public static String encodeInfo(LoginRequestDTO loginRequest) {
        String token = null;
        String subject = generalSubject(loginRequest);
        try {
            token = DatatypeConverter.printBase64Binary(subject.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return  reverseString(token);
    }

    public static LoginRequestDTO decodeInfo(String str) {
        String encodeStr = reverseString(str);
        byte[] decode = DatatypeConverter.parseBase64Binary(encodeStr);
        LoginRequestDTO loginResponse = JSONObject.parseObject(new String(decode), LoginRequestDTO.class);
        return loginResponse;
    }

    private static String reverseString (String str){
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.reverse().toString();
    }

    /**
     * 生成subject信息
     * @param loginRequest
     * @return
     */
    private static String generalSubject(LoginRequestDTO loginRequest){
        JSONObject jo = new JSONObject();
        jo.put("userName", loginRequest.getUserName());
        return jo.toJSONString();
    }
}
