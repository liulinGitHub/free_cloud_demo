package org.cloud.face.utils;

import lombok.Data;
import org.cloud.face.enums.ResponseCodeEnum;

import java.util.HashMap;

@Data
public class ResponseBo extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 警告
    private static final Integer WARN = 1;

    public ResponseBo() {
        put("code", ResponseCodeEnum.SUCCESS.getCode());
        put("message", ResponseCodeEnum.SUCCESS.getMessage());
        put("result", "");
    }

    public static ResponseBo newDataResponse(Object result){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", ResponseCodeEnum.SUCCESS.getCode());
        responseBo.put("message", "成功返回");
        responseBo.put("result",result);
        return responseBo;
    }

    public static ResponseBo ok(String message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", ResponseCodeEnum.SUCCESS.getCode());
        responseBo.put("message", message);
        responseBo.put("result","");
        return responseBo;
    }

    public static ResponseBo error(String message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", ResponseCodeEnum.ERROR.getCode());
        responseBo.put("message", message);
        return responseBo;
    }

    public static ResponseBo tokenError(String message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", ResponseCodeEnum.FORBIDDEN.getCode());
        responseBo.put("message", message);
        return responseBo;
    }

    public static ResponseBo warn(String message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", WARN);
        responseBo.put("message", message);
        return responseBo;
    }

    public static ResponseBo error(String message, Object result) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", ResponseCodeEnum.ERROR.getCode());
        responseBo.put("message", message);
        responseBo.put("result",result);
        return responseBo;
    }
    public static ResponseBo error(Integer code, String message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", code);
        responseBo.put("message", message);
        return responseBo;
    }

    public static ResponseBo warn(String message, Object result) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", WARN);
        responseBo.put("message", message);
        responseBo.put("result",result);
        return responseBo;
    }


    public static ResponseBo ok() {
        return new ResponseBo();
    }

    public static ResponseBo error() {
        return ResponseBo.error("");
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
