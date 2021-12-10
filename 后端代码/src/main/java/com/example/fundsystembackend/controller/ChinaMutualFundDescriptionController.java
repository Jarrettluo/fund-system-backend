package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.service.ChinaMutualFundDescriptionService;
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
@RequestMapping("/chinaMutualFundDescription")
public class ChinaMutualFundDescriptionController {

    @Autowired
    private ChinaMutualFundDescriptionService chinaMutualFundDescriptionService;

    @GetMapping("/details")
    public ApiResult fundDetails(@RequestParam("windCode") String windCode) {
        return chinaMutualFundDescriptionService.fundDetails(windCode);
    }

    @GetMapping("/search")
    public ApiResult searchResult(@RequestParam("keyWord") String keyWord) {
        return chinaMutualFundDescriptionService.searchResult(keyWord);
    }
}

