package com.example.demo.result;

/**
 * FileName:ExceptionMsg
 * Author: kaishen
 * Date: 2020/10/27 9:02
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public enum ExceptionMsg {
    SUCCESS("200","操作成功"),
    FAILED("999999","操作失败"),
    LoginNameOrPassWordError("000100", "用户名或者密码错误！"),
    ParamError("000001","参数错误"),
    FileEmpty("000400","上传文件为空"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'")
    ;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}


