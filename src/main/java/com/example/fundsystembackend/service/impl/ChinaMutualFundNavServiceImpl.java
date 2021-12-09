package com.example.fundsystembackend.service.impl;

import com.example.fundsystembackend.entity.Chinamutualfundnav;
import com.example.fundsystembackend.mapper.ChinamutualfundnavMapper;
import com.example.fundsystembackend.service.ChinaMutualFundNavService;
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
public class ChinaMutualFundNavServiceImpl extends ServiceImpl<ChinamutualfundnavMapper, Chinamutualfundnav> implements ChinaMutualFundNavService {
    @Override
    public ApiResult fundTrend(String fInfoWindcode, String period) {
        return null;
    }
}
