package com.example.demo.until;

/**
 * FileName:MessageUtil
 * Author: kaishen
 * Date: 2020/11/3 10:50
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class MessageUtil {
    public static String getMessage(String template, String... keys) {
        int count = 0;
        for (String key : keys) {
            template = template.replace("{" + count++ + "}", key);
        }
        return template;
    }

    public static void main(String[] args) {
        String message = MessageUtil.getMessage("激活内容{0}", "http://127.0.0.1:8080/member/activeuserEmail?sid=854fa220c748aa7223781072517632d3&email=1050535036@qq.com");
        System.out.println(message);
    }
}
