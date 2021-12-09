package com.example.fundsystembackend.service;

import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fundsystembackend.utils.result.ApiResult;
import io.swagger.annotations.Api;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
public interface ChinaMutualFundDescriptionService extends IService<ChinaMutualFundDescription> {

    ApiResult fundDetails(String windCode);
    ApiResult searchResult(String keyWord);
}
