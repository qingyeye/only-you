package com.only.you.response;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by geely
 */
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

	private static final long serialVersionUID = -392932172522246436L;

	private int status;
    private String msg;
    private Object extData ;
    private T data;


    public ServerResponse(){}

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Object getExtData() {
        return this.extData;
    }

    public void setExtData(Object obj) {
         this.extData = obj;
    }




    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

	public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createBySuccessCodeMessage(int successCode, String msg) {
        return new ServerResponse<T>(successCode, msg);
    }

    public static <T> ServerResponse<T> createBySuccess(int successCode, String msg, T data) {
        return new ServerResponse<T>(successCode, msg, data);
    }

	/**
	 * public static <T> ServerResponse<T> createBySuccessDataNull() { return new
	 * ServerResponse<T>(ResponseCode.DATA_NULL_SUCCESS.getCode(),
	 * ResponseCode.DATA_NULL_SUCCESS.getDesc()); }
	 *
	 * public static <T> ServerResponse<T> createBySuccessData_Failed() { return new
	 * ServerResponse<T>(ResponseCode.DATA_FAILED_SUCCESS.getCode(),
	 * ResponseCode.DATA_FAILED_SUCCESS.getDesc()); }
	 *
	 * public static <T> ServerResponse<T> createBySuccessAccountSucc() { return new
	 * ServerResponse<T>(ResponseCode.ACCOUNT_SUCCESS.getCode(),
	 * ResponseCode.ACCOUNT_SUCCESS.getDesc()); }
	 *
	 * public static <T> ServerResponse<T> createBySuccessAccountNot() { return new
	 * ServerResponse<T>(ResponseCode.ACCOUNT_ERROR.getCode(),
	 * ResponseCode.ACCOUNT_ERROR.getDesc()); }
	 *
	 * public static <T> ServerResponse<T> createByErrorParamsNull() { return new
	 * ServerResponse<T>(ResponseCode.PARAMS_ERROR.getCode(),
	 * ResponseCode.PARAMS_ERROR.getDesc()); }
	 *
	 * public static <T> ServerResponse<T> createByErrorServer() { return new
	 * ServerResponse<T>(ResponseCode.SERVER_ERROR.getCode(),
	 * ResponseCode.SERVER_ERROR.getDesc()); }
	 */

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorParamsNull() { return new
             ServerResponse<T>(ResponseCode.PARAMS_ERROR.getCode(),
	  ResponseCode.PARAMS_ERROR.getDesc()); }

    public static <T> ServerResponse<T> createByErrorParamsNotComplete() { return new
            ServerResponse<T>(ResponseCode.PARAMS_NOT_COMPLETE.getCode(),
            ResponseCode.PARAMS_NOT_COMPLETE.getDesc()); }

    public static <T> ServerResponse<T> createByError(String errorMessage, T data) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage, data);
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorEmpower(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.NOT_AUTHORIZE.getCode(), errorMessage);
    }

}
