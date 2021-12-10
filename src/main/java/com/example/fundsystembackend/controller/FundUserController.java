package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.entity.Funduser;
import com.example.fundsystembackend.service.FundUserService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@CrossOrigin
@RestController
@RequestMapping("/fundUser")
public class FundUserController {

    @Autowired
    private FundUserService fundUserService;

    @PostMapping("/login")
    public ApiResult loginUser(@RequestBody Funduser fundUser) {
        return fundUserService.loginUser(fundUser);
    }

    @PostMapping("/logout")
    public ApiResult logoutUser(@RequestBody Funduser fundUser) {
        return fundUserService.loginUser(fundUser);
    }

    @PostMapping("/register")
    public ApiResult regiter(@RequestBody Funduser fundUser) {
        return fundUserService.register(fundUser);
    }

}

