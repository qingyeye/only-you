package com.only.you.response;

/**
 * Created by geely
 */
public enum ResponseCode {

    SUCCESS(200,"查询成功"),
    //用了
    DATA_NULL_SUCCESS(201,"暂无数据"),
    DATA_FAILED_SUCCESS(202,"查询失败"),
    ACCOUNT_SUCCESS(300,"登陆成功"),
    ACCOUNT_ERROR(301,"用户不存在"),
    ACCOUNT_PHONENUMBER(302,"手机号已绑定"),
    NOT_AUTHORIZE(303,"未授权,请重新授权"),
    ERROR(400,"ERROR"),
    PARAMS_ERROR(401,"参数为空"),
    PARAMS_NOT_COMPLETE(402,"参数不全"),
    GOODS_LOSE(601,"商品失效"),
    ORDER_VIOLATION_NULL(701,"订单不存在"),
    ORDER_VIOLATION_REPEAT(702,"订单已设置违规"),
    //用了
	SERVER_ERROR(500,"服务器错误");
	//999用于判断是否是最新版本app

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }


}
