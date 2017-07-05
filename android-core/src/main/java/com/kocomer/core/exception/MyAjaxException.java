package com.kocomer.core.exception;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * 服务器端异步请求错误
 *
 * @author kocomer
 */
public class MyAjaxException extends Exception {
    private static final long serialVersionUID = 1L;
    private int exceptionType = 1;

    public int getExceptionType() {
        return exceptionType;
    }

    public MyAjaxException() {
        super("服务器忙");
    }

    public MyAjaxException(String errorInfo) {
        super(errorInfo);
    }


    public MyAjaxException(int exceptionType, String errorInfo) {
        super(errorInfo);
        this.exceptionType = exceptionType;
    }

    public MyAjaxException(int exceptionType) {
        super("服务器忙");
        this.exceptionType = exceptionType;
    }

    @Override
    public String toString() {

        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("result", exceptionType);
            jsonObj.put("msg", this.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jsonObj.toString();
    }

}
