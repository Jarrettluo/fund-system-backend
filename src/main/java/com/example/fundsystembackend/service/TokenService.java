package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.Funduser;

/**
 * @Author Jarrett Luo
 * @Date 2021/12/10 17:13
 * @Version 1.0
 */
public interface TokenService {
    String getToken(Funduser fundUser);
}
