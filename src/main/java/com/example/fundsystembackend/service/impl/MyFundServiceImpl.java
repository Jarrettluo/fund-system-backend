package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.entity.MyFund;
import com.example.fundsystembackend.mapper.MyfundMapper;
import com.example.fundsystembackend.service.MyFundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@Service
public class MyFundServiceImpl extends ServiceImpl<MyfundMapper, MyFund> implements MyFundService {

    @Autowired
    private MyfundMapper myfundMapper;

    @Override
    public ApiResult addFund(String fundId, String userId) {
        if(fundId == null || fundId.equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(userId == null || userId.equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        MyFund myFund = new MyFund();
        myFund.setFundId(fundId);
        myFund.setUserId(userId);
        myfundMapper.insert(myFund);
        return ApiResult.success("success");
    }

    @Override
    public ApiResult deleteFund(String fundId, String userId) {
        if(fundId == null || fundId.equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(userId == null || userId.equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        myfundMapper.delete(new QueryWrapper<MyFund>().eq("", ""));
        return ApiResult.success();
    }

}
