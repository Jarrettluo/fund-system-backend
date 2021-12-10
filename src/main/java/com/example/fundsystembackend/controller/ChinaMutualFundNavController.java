package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.service.ChinaMutualFundNavService;
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
@RequestMapping("/chinaMutualFundNav")
public class ChinaMutualFundNavController {

    @Autowired
    private ChinaMutualFundNavService chinaMutualFundNavService;

    @GetMapping("/trend")
    public ApiResult fundTrend(@RequestParam(value = "fInfoWindcode") String fInfoWindcode,
                               @RequestParam(value = "period") String period) {
        return chinaMutualFundNavService.fundTrend(fInfoWindcode, period);
    }
}

