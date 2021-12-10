package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.Chinamutualfunddescription;
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
public interface ChinaMutualFundDescriptionService extends IService<Chinamutualfunddescription> {

    ApiResult fundDetails(String windCode);
    ApiResult searchResult(String keyWord);
}
