package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.example.fundsystembackend.entity.Chinamutualfundnav;
import com.example.fundsystembackend.mapper.ChinamutualfunddescriptionMapper;
import com.example.fundsystembackend.mapper.ChinamutualfundnavMapper;
import com.example.fundsystembackend.service.ChinaMutualFundNavService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@Service("chinaMutualFundNavService")
public class ChinaMutualFundNavServiceImpl extends ServiceImpl<ChinamutualfundnavMapper, Chinamutualfundnav> implements ChinaMutualFundNavService {

    @Autowired
    private ChinamutualfundnavMapper chinamutualfundnavMapper;

    @Override
    public ApiResult fundTrend(String fInfoWindcode, String period) {
        if(fInfoWindcode == null || fInfoWindcode.equals("")){
            return ApiResult.error(1201, "fInfoWind参数错误");
        }
        if(period == null || period.equals("")){
            return ApiResult.error(1201, "period参数错误");
        }

        List<Chinamutualfundnav> chinamutualfundnavList = chinamutualfundnavMapper.selectList(
                new QueryWrapper<Chinamutualfundnav>().eq("d",23)
        );
        if(chinamutualfundnavList!=null || chinamutualfundnavList.size()>0) {
            return ApiResult.success(chinamutualfundnavList);
        }else {
            return ApiResult.error(1202, "查询失败");
        }
    }
}
