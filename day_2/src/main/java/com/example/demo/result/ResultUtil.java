package com.example.demo.result;

/**
 * FileName:ResultUtil
 * Author: kaishen
 * Date: 2020/11/2 13:25
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class ResultUtil {
    //传参的成功
    public static Result success(Integer code,String msg,Object object){
        Result result=new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(object);
        return result;

    }

    //不传参的成功
    public static Result success(){
        return success(200,"操作成功",null);
    }
    //传参的失败
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
