package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.Myfund;
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
public interface MyFundService extends IService<Myfund> {

    ApiResult addFund(Myfund myfund);
    ApiResult deleteFund(Myfund myfund);
    ApiResult fundList(String userId);

}
