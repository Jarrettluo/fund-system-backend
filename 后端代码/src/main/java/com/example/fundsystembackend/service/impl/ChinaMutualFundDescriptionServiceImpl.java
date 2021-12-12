package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.Chinamutualfunddescription;
import com.example.fundsystembackend.entity.Chinamutualfundmanager;
import com.example.fundsystembackend.entity.Chinamutualfundnav;
import com.example.fundsystembackend.entity.Myfund;
import com.example.fundsystembackend.mapper.ChinamutualfunddescriptionMapper;
import com.example.fundsystembackend.mapper.ChinamutualfundmanagerMapper;
import com.example.fundsystembackend.mapper.ChinamutualfundnavMapper;
import com.example.fundsystembackend.mapper.MyfundMapper;
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

    @Autowired
    private ChinamutualfundmanagerMapper chinamutualfundmanagerMapper;

    @Autowired
    private ChinamutualfundnavMapper chinamutualfundnavMapper;

    @Autowired
    private MyfundMapper myfundMapper;

    @Override
    public ApiResult fundDetails(String windCode) {
        if(windCode==null || windCode.equals("")){
            return ApiResult.error(1201, "winCode参数不正确");
        }
        Chinamutualfunddescription chinaMutualFundDescription = chinamutualfunddescriptionMapper.selectOne(
                new QueryWrapper<Chinamutualfunddescription>().eq("f_info_wind_code", windCode)
        );
        if(chinaMutualFundDescription==null) {
            return ApiResult.error(1202, "查找失败");
        }

        // 查找该基金的经理人
        List<Chinamutualfundmanager> chinamutualfundmanagerList = chinamutualfundmanagerMapper.selectList(
                new QueryWrapper<Chinamutualfundmanager>().eq("f_info_windcode", windCode)
        );
        chinaMutualFundDescription.setChinamutualfundmanagers(chinamutualfundmanagerList);

        // 查找该基金最近两天的情况
        List<Chinamutualfundnav> chinamutualfundnavList = chinamutualfundnavMapper.selectList(
                new QueryWrapper<Chinamutualfundnav>()
                        .eq("f_info_wind_code",windCode)
                        .last("limit 2")
        );
        Float lastPrice = chinamutualfundnavList.get(0).getFNavUnit();
        if(chinamutualfundnavList.size() == 2){
            Float endPrice = chinamutualfundnavList.get(1).getFNavUnit();
            Float percent = (lastPrice - endPrice)/endPrice;
            chinaMutualFundDescription.setNewPercent(percent);
        }
        chinaMutualFundDescription.setNewNavUnit(lastPrice);
        return ApiResult.success(chinaMutualFundDescription);
    }

    @Override
    public ApiResult searchResult(String keyWord) {
        List<Chinamutualfunddescription> chinamutualfunddescriptionList = chinamutualfunddescriptionMapper.selectList(
                new QueryWrapper<Chinamutualfunddescription>().like("f_info_wind_code", keyWord)
        );
        if(chinamutualfunddescriptionList !=null || chinamutualfunddescriptionList.size()>0){
            for(Chinamutualfunddescription chinamutualfunddescription : chinamutualfunddescriptionList) {
                String windCode = chinamutualfunddescription.getFInfoWindCode();
                List<Chinamutualfundmanager> chinamutualfundmanagerList = chinamutualfundmanagerMapper.selectList(
                        new QueryWrapper<Chinamutualfundmanager>().eq("f_info_windcode", windCode)
                );
                chinamutualfunddescription.setChinamutualfundmanagers(chinamutualfundmanagerList);

                List<Myfund> myfunds = myfundMapper.selectList(
                        new QueryWrapper<Myfund>().eq("fund_id", chinamutualfunddescription.getObjectId()));
                if(myfunds != null && myfunds.size() > 0) {
                    chinamutualfunddescription.setSelected(true);
                }else {
                    chinamutualfunddescription.setSelected(false);
                }
            }
            return ApiResult.success(chinamutualfunddescriptionList);
        }else {
            List<Chinamutualfunddescription> chinamutualfunddescriptions = new ArrayList<>();
            return ApiResult.success(chinamutualfunddescriptions);
        }
    }
}
