package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.service.MyFundService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/myFund")
public class MyFundController {

    @Autowired
    private MyFundService myFundService;

    @PostMapping("/add")
    public ApiResult addFund(@RequestBody String fundId,
                             @RequestBody String userId) {
        return myFundService.addFund(fundId, userId);
    }

    @PostMapping("/delete")
    public ApiResult deleteFund(@RequestBody String fundId,
                             @RequestBody String userId) {
        return myFundService.deleteFund(fundId, userId);
    }

}

