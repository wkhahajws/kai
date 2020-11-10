package com.example.demo.result;

/**
 * FileName:ResponseData
 * Author: kaishen
 * Date: 2020/10/27 9:13
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class ResponseData extends Response{
    private Object data;

    public ResponseData(Object data) {
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }

    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }

    public ResponseData(String rspCode, String rspMsg) {
        super(rspCode,rspMsg);
    }

    public ResponseData(String rspCode, String rspMsg,Object data) {
        super(rspCode,rspMsg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                '}';
    }
}
