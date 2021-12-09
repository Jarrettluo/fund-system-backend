package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.service.ChinaMutualFundNavService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/chinaMutualFundNav")
public class ChinaMutualFundNavController {

    @Resource
    ChinaMutualFundNavService chinaMutualFundNavService;

    @GetMapping("/trend")
    public ApiResult fundTrend(@RequestParam(value = "fInfoWindcode") String fInfoWindcode,
                               @RequestParam(value = "period") String period) {
        return chinaMutualFundNavService.fundTrend(fInfoWindcode, period);
    }
}

