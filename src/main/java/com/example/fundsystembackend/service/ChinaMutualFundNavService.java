package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.Chinamutualfundnav;
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
public interface ChinaMutualFundNavService extends IService<Chinamutualfundnav> {

    ApiResult fundTrend(String fInfoWindcode, String period);

}
