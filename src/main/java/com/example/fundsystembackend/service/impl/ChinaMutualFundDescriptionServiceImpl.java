package com.example.fundsystembackend.service.impl;

import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.example.fundsystembackend.mapper.ChinamutualfunddescriptionMapper;
import com.example.fundsystembackend.service.ChinaMutualFundDescriptionService;
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
public class ChinaMutualFundDescriptionServiceImpl extends ServiceImpl<ChinamutualfunddescriptionMapper, ChinaMutualFundDescription> implements ChinaMutualFundDescriptionService {

    @Override
    public ApiResult fundDetails(String windCode) {
        return null;
    }

    @Override
    public ApiResult searchResult(String keyWord) {
        return null;
    }
}
