package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.Chinamutualfundnav;
import com.example.fundsystembackend.mapper.ChinamutualfundnavMapper;
import com.example.fundsystembackend.service.ChinaMutualFundNavService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer periodInt = Integer.parseInt(period);
        String sql = "limit " + periodInt * 10;
        // 限制取到特定数量的基金净值信息
        List<Chinamutualfundnav> chinamutualfundnavList = chinamutualfundnavMapper.selectList(
                new QueryWrapper<Chinamutualfundnav>()
                        .eq("f_info_wind_code",fInfoWindcode)
                        .last(sql)
        );
        if(chinamutualfundnavList!=null || chinamutualfundnavList.size()>0) {
            // 从这里计算每只基金的
            Integer navListSize = chinamutualfundnavList.size();
            Float rootPrice = chinamutualfundnavList.get(navListSize - 1).getFNavUnit();
            for(int i = navListSize - 2; i >= 0; i--) {
                Float detaPercent = (chinamutualfundnavList.get(i).getFNavUnit() - rootPrice)/rootPrice;
                chinamutualfundnavList.get(i).setPricePercent(detaPercent);
                rootPrice = chinamutualfundnavList.get(i).getFNavUnit();
            }
            return ApiResult.success(chinamutualfundnavList);
        }else {
            return ApiResult.error(1202, "查询失败");
        }
    }
}
