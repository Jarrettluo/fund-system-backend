package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.example.fundsystembackend.service.ChinaMutualFundDescriptionService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/chinaMutualFundDescription")
public class ChinaMutualFundDescriptionController {

    @Autowired
    ChinaMutualFundDescriptionService chinaMutualFundDescriptionService;

    @GetMapping("/details")
    public ApiResult fundDetails(@RequestParam("windCode") String windCode) {
        return chinaMutualFundDescriptionService.fundDetails(windCode);
    }

    @GetMapping("/search")
    public ApiResult searchResult(@RequestParam("keyWord") String keyWord) {
        return chinaMutualFundDescriptionService.searchResult(keyWord);
    }
}

