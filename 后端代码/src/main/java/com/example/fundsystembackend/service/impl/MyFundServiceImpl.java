package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.Chinamutualfunddescription;
import com.example.fundsystembackend.entity.Chinamutualfundnav;
import com.example.fundsystembackend.entity.Funduser;
import com.example.fundsystembackend.entity.Myfund;
import com.example.fundsystembackend.mapper.ChinamutualfunddescriptionMapper;
import com.example.fundsystembackend.mapper.ChinamutualfundnavMapper;
import com.example.fundsystembackend.mapper.FunduserMapper;
import com.example.fundsystembackend.mapper.MyfundMapper;
import com.example.fundsystembackend.service.MyFundService;
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
@Service
public class MyFundServiceImpl extends ServiceImpl<MyfundMapper, Myfund> implements MyFundService {

    @Autowired
    private MyfundMapper myfundMapper;

    @Autowired
    private FunduserMapper funduserMapper;

    @Autowired
    private ChinamutualfunddescriptionMapper chinamutualfunddescriptionMapper;

    @Autowired
    private ChinamutualfundnavMapper chinamutualfundnavMapper;

    @Override
    public ApiResult addFund(Myfund myfund) {
        if(myfund.getFundId() == null || myfund.getFundId().equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(myfund.getUserId() == null || myfund.getUserId().equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        Funduser fundUser = funduserMapper.selectOne(
                new QueryWrapper<Funduser>().eq("user_id", myfund.getUserId())
        );
        if(fundUser==null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        Chinamutualfunddescription chinaMutualFundDescription = chinamutualfunddescriptionMapper
                .selectOne(new QueryWrapper<Chinamutualfunddescription>().eq("object_id", myfund.getFundId()
                ));
        if(chinaMutualFundDescription == null){
            return ApiResult.error(1202, "该基金不存在");
        }
        String fundId = myfund.getFundId();
        String userId = myfund.getUserId();
        List<Myfund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<Myfund>().select("fund_id", fundId).eq("user_id", userId));
        if(mySelectedFundList != null && mySelectedFundList.size() > 0) {
            return ApiResult.error(1203, "重复选择");
        }
        Myfund myFund = new Myfund();
        myFund.setFundId(fundId);
        myFund.setUserId(userId);
        myfundMapper.insert(myFund);
        return ApiResult.success("success");
    }

    @Override
    public ApiResult deleteFund(Myfund myfund) {
        String fundId = myfund.getFundId();
        String userId = myfund.getUserId();
        if(fundId == null || fundId.equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(userId == null || userId.equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        Funduser fundUser = funduserMapper.selectOne(
                new QueryWrapper<Funduser>().eq("user_id", myfund.getUserId())
        );
        if(fundUser==null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        Chinamutualfunddescription chinaMutualFundDescription = chinamutualfunddescriptionMapper
                .selectOne(new QueryWrapper<Chinamutualfunddescription>().eq("object_id", myfund.getFundId()
                ));
        if(chinaMutualFundDescription == null){
            return ApiResult.error(1202, "该基金不存在");
        }
        List<Myfund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<Myfund>().eq("fund_id", fundId).eq("user_id", userId));
        System.out.println(mySelectedFundList);
        if(mySelectedFundList != null && mySelectedFundList.size() > 0) {
            for (Myfund myfund1 : mySelectedFundList) {
                myfundMapper.deleteById(myfund1.getId());
            }
            return ApiResult.success();
        }else {
            return ApiResult.error(1203, "删除自选失败");
        }

    }

    @Override
    public ApiResult fundList(String userId) {
        if (userId == null || userId.equals("")) {
            return ApiResult.error(1201, "userId不能为空");
        }
        Funduser fundUser = funduserMapper.selectOne(
                new QueryWrapper<Funduser>().eq("user_id", userId)
        );
        if (fundUser == null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        List<Myfund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<Myfund>().eq("user_id", userId));

        if (mySelectedFundList == null || mySelectedFundList.size() == 0) {
            return ApiResult.success(mySelectedFundList);
        }
        List<Chinamutualfunddescription> chinamutualfunddescriptions = new ArrayList<>();

        for (Myfund myFund : mySelectedFundList) {
            Chinamutualfunddescription myFundDesc = chinamutualfunddescriptionMapper.selectOne(
                    new QueryWrapper<Chinamutualfunddescription>().eq("object_id", myFund.getFundId()));
            System.out.println(myFundDesc.toString());
            chinamutualfunddescriptions.add(myFundDesc);
        }
        for (Chinamutualfunddescription chinaMutualFundDescription : chinamutualfunddescriptions) {
            String fInfoCode = chinaMutualFundDescription.getFInfoWindCode();

            List<Chinamutualfundnav> chinamutualfundnavList =
                    chinamutualfundnavMapper.selectList(
                            new QueryWrapper<Chinamutualfundnav>().eq("f_info_wind_code", fInfoCode)
                    );
            System.out.println(chinamutualfundnavList);
            if (chinamutualfundnavList != null && chinamutualfundnavList.size() > 0) {
                chinaMutualFundDescription.setNewNavUnit(chinamutualfundnavList.get(0).getFNavUnit());
            }
        }
        return ApiResult.success(chinamutualfunddescriptions);
    }
}
