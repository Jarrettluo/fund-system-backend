package com.example.fundsystembackend.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FundUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 加密后的用户密码
     */
    private String userPassword;

    /**
     * 用户手机号码
     */
    private String userTelephone;

    /**
     * 用户注册时间
     */
    private LocalDateTime userRegisterTime;

    /**
     * 用户状态0正常 1冻结
     */
    private String userState;


}
