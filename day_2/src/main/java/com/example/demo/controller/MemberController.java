package com.example.demo.controller;

import com.example.demo.entity.member.M_User;
import com.example.demo.entity.member.M_UserRole;
import com.example.demo.repository.member.M_UserRepository;
import com.example.demo.repository.member.M_UserRoleRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.until.AsyncSendEmailService;
import com.example.demo.until.DateUtils;
import com.example.demo.until.MD5Util;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName:MemberController
 * Author: kaishen
 * Date: 2020/11/2 13:33
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
@RequestMapping("member")
public class MemberController extends BaseController {

    @Autowired
    private M_UserRepository m_userRepository;
    @Autowired
    private M_UserRoleRepository m_userRoleRepository;
    @Autowired
    private AsyncSendEmailService asyncSendEmailService;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //电话注册
    @RequestMapping(value = "/regist/mobile",method = RequestMethod.POST)
    public Response regist(M_User m_user){
        M_User mUser = m_userRepository.findByMobile(m_user.getMobile());
        if(null != mUser){
            return result(ExceptionMsg.FAILED);
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        m_user.setName(m_user.getMobile());
        m_user.setEmail(m_user.getMobile());
        m_user.setPassword(bCryptPasswordEncoder.encode(m_user.getPassword()));
        m_user.setCreateTime(DateUtils.getCurrentTime());
        m_user.setLastModifyTime(DateUtils.getCurrentTime());
        List<M_UserRole> roles = new ArrayList<>();
        M_UserRole m_userRole = m_userRoleRepository.findByRolename("ROLE_USER");
        m_user.setCnname(m_userRole.getCnname());
        roles.add(m_userRole);
        m_user.setRoles(roles);
        m_userRepository.save(m_user);
        return result();
    }

    //邮件注册
    @RequestMapping(value = "regist/email",method = RequestMethod.POST)
    public Response registByEmail(M_User m_user){
        M_User mUser = m_userRepository.findByEmail(m_user.getEmail());
        if(null != mUser){
//            return result(ExceptionMsg.FAILED);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        m_user.setName(m_user.getEmail());
        m_user.setMobile(m_user.getEmail());
        m_user.setPassword(bCryptPasswordEncoder.encode(m_user.getPassword()));
        m_user.setCreateTime(DateUtils.getCurrentTime());
        m_user.setLastModifyTime(DateUtils.getCurrentTime());
        List<M_UserRole> roles = new ArrayList<>();
        M_UserRole m_userRole = m_userRoleRepository.findByRolename("ROLE_USER");
        m_user.setCnname(m_userRole.getCnname());
        roles.add(m_userRole);
        m_user.setRoles(roles);
//        m_userRepository.save(m_user);

        rabbitTemplate.convertAndSend("reg_email",m_user.getEmail());
//        asyncSendEmailService.sendVerifyemail(m_user.getEmail());
        return result();
    }

    //邮件验证
    @RequestMapping(value = "/activeuserEmail", method = RequestMethod.GET)
    public String activeuserEmail( String email, String sid) {
        try {
            M_User m_user = m_userRepository.findByEmail(email);
            Timestamp outDate = Timestamp.valueOf(m_user.getOutDate());
            if (outDate.getTime() <= System.currentTimeMillis()) { //表示已经过期

                return "激活失败";
//                System.out.print("过期");
            }
            String key = m_user.getEmail() + "$" + outDate.getTime() / 1000 * 1000 + "$" + m_user.getValidataCode();//数字签名
            String digitalSignature = MD5Util.encode(key);
            if (digitalSignature.equals(sid)) {
                //return result(ExceptionMsg.LinkOutdated);
                m_userRepository.setActive("1", m_user.getEmail());
                return "激活成功";
            }
            if (!digitalSignature.equals(sid)) {
                return "激活失败";
            }

//            userRepository.
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("failed, ", e);
//            return result(ExceptionMsg.FAILED);
        }
        return "激活失败";

    }
}
