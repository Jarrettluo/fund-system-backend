package com.example.fundsystembackend.controller;


import com.example.fundsystembackend.entity.Myfund;
import com.example.fundsystembackend.service.MyFundService;
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
@RequestMapping("/myFund")
public class MyFundController {

    @Autowired
    private MyFundService myFundService;

    @PostMapping("/add")
    public ApiResult addFund(@RequestBody Myfund myfund) {
        return myFundService.addFund(myfund);
    }

    @PostMapping("/delete")
    public ApiResult deleteFund(@RequestBody Myfund myfund) {
        return myFundService.deleteFund(myfund);
    }

    @GetMapping("/list")
    public ApiResult fundList(@RequestParam("userId") String userId) {
        return myFundService.fundList(userId);
    }

}

