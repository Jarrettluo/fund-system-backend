package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.service.FundUserService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/fundUser")
public class FundUserController {

    @Autowired
    FundUserService fundUserService;

    @PostMapping("/login")
    public ApiResult loginUser(@RequestBody FundUser fundUser) {
        return fundUserService.loginUser(fundUser);
    }

    @PostMapping("/logout")
    public ApiResult logoutUser(@RequestBody FundUser fundUser) {
        return fundUserService.loginUser(fundUser);
    }


}

