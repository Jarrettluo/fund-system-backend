package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.FundUser;
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
public interface FundUserService extends IService<FundUser> {

    ApiResult loginUser(FundUser fundUser);
    ApiResult logoutUser(FundUser fundUser);
    ApiResult register(FundUser fundUser);

}
