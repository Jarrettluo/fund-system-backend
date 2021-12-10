package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.Chinamutualfunddescription;
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
public class ChinaMutualFundDescriptionServiceImpl extends ServiceImpl<ChinamutualfunddescriptionMapper, Chinamutualfunddescription> implements ChinaMutualFundDescriptionService {

    @Autowired
    private ChinamutualfunddescriptionMapper chinamutualfunddescriptionMapper;

    @Override
    public ApiResult fundDetails(String windCode) {
        if(windCode==null || windCode.equals("")){
            return ApiResult.error(1201, "winCode参数不正确");
        }
        Chinamutualfunddescription chinaMutualFundDescription = chinamutualfunddescriptionMapper.selectOne(
                new QueryWrapper<Chinamutualfunddescription>().eq("wind_code", windCode)
        );
        if(chinaMutualFundDescription==null) {
            return ApiResult.error(1202, "查找失败");
        }

        return ApiResult.success(chinaMutualFundDescription);
    }

    @Override
    public ApiResult searchResult(String keyWord) {
        List<Chinamutualfunddescription> chinamutualfunddescriptionList = chinamutualfunddescriptionMapper.selectList(
                new QueryWrapper<Chinamutualfunddescription>().like("wind_code", keyWord)
        );
        if(chinamutualfunddescriptionList !=null || chinamutualfunddescriptionList.size()>0){
            return ApiResult.success(chinamutualfunddescriptionList);
        }else {
            List<Chinamutualfunddescription> chinamutualfunddescriptions = new ArrayList<>();
            return ApiResult.success(chinamutualfunddescriptions);
        }
    }
}
