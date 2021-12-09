package com.example.fundsystembackend.service.impl;

import com.example.fundsystembackend.entity.MyFund;
import com.example.fundsystembackend.mapper.MyfundMapper;
import com.example.fundsystembackend.service.MyFundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.utils.result.ApiResult;
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

    @Override
    public ApiResult addFund(String fundId, String userId) {

        return null;
    }

    @Override
    public ApiResult deleteFund(String fundId, String userId) {
        return null;
    }

}
