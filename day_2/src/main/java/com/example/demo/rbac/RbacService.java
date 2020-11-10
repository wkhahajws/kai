package com.example.demo.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * FileName:RbacService
 * Author: kaishen
 * Date: 2020/10/22 16:06
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
