package com.example.fundsystembackend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(FundUser fundUser) {
        String token = JWT.create().withAudience(fundUser.getUserId())
                .sign(Algorithm.HMAC256(fundUser.getUserPassword()));
        return token;
    }
}