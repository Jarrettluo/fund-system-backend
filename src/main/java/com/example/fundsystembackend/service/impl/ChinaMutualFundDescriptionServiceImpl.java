package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.example.fundsystembackend.mapper.ChinamutualfunddescriptionMapper;
import com.example.fundsystembackend.service.ChinaMutualFundDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@Service("chinaMutualFundDescriptionService")
public class ChinaMutualFundDescriptionServiceImpl extends ServiceImpl<ChinamutualfunddescriptionMapper, ChinaMutualFundDescription> implements ChinaMutualFundDescriptionService {

    @Autowired
    private ChinamutualfunddescriptionMapper chinamutualfunddescriptionMapper;

    @Override
    public ApiResult fundDetails(String windCode) {
        if(windCode==null || windCode.equals("")){
            return ApiResult.error(1201, "winCode参数不正确");
        }
        ChinaMutualFundDescription chinaMutualFundDescription = chinamutualfunddescriptionMapper.selectOne(
                new QueryWrapper<ChinaMutualFundDescription>()
        );

        return null;
    }

    @Override
    public ApiResult searchResult(String keyWord) {
        List<ChinaMutualFundDescription> chinaMutualFundDescriptionList = chinamutualfunddescriptionMapper.selectList(
                new QueryWrapper<ChinaMutualFundDescription>().eq("dsf", keyWord)
        );
        if(chinaMutualFundDescriptionList!=null || chinaMutualFundDescriptionList.size()>0){
            return ApiResult.success(chinaMutualFundDescriptionList);
        }else {
            List<ChinaMutualFundDescription> chinaMutualFundDescriptions = new ArrayList<>();
            return ApiResult.success(chinaMutualFundDescriptions);
        }
    }
}
