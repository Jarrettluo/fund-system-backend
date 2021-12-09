package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.MyFund;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fundsystembackend.utils.result.ApiResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
public interface MyFundService extends IService<MyFund> {

    ApiResult addFund(String fundId, String userId);
    ApiResult deleteFund(String fundId, String userId);

}
