package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.ChinaMutualFundDescription;
import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.entity.MyFund;
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
public class MyFundServiceImpl extends ServiceImpl<MyfundMapper, MyFund> implements MyFundService {

    @Autowired
    private MyfundMapper myfundMapper;

    @Autowired
    private FunduserMapper funduserMapper;

    @Autowired
    private ChinamutualfunddescriptionMapper chinamutualfunddescriptionMapper;

    @Autowired
    private ChinamutualfundnavMapper chinamutualfundnavMapper;

    @Override
    public ApiResult addFund(String fundId, String userId) {
        if(fundId == null || fundId.equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(userId == null || userId.equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        FundUser fundUser = funduserMapper.selectById(userId);
        if(fundUser==null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        ChinaMutualFundDescription chinaMutualFundDescription = chinamutualfunddescriptionMapper.selectById(fundId);
        if(chinaMutualFundDescription == null){
            return ApiResult.error(1202, "该基金不存在");
        }
        List<MyFund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<MyFund>().select("fund_id", fundId).eq("user_id", userId));
        if(mySelectedFundList != null && mySelectedFundList.size() > 0) {
            return ApiResult.error(1203, "重复选择");
        }
        MyFund myFund = new MyFund();
        myFund.setFundId(fundId);
        myFund.setUserId(userId);
        myfundMapper.insert(myFund);
        return ApiResult.success("success");
    }

    @Override
    public ApiResult deleteFund(String fundId, String userId) {
        if(fundId == null || fundId.equals("")) {
            return ApiResult.error(1201, "fundId不能为空");
        }
        if(userId == null || userId.equals("")){
            return ApiResult.error(1201, "userId不能为空");
        }
        FundUser fundUser = funduserMapper.selectById(userId);
        if(fundUser==null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        ChinaMutualFundDescription chinaMutualFundDescription = chinamutualfunddescriptionMapper.selectById(fundId);
        if(chinaMutualFundDescription == null){
            return ApiResult.error(1202, "该基金不存在");
        }
        List<MyFund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<MyFund>().select("fund_id", fundId).eq("user_id", userId));
        if(mySelectedFundList != null && mySelectedFundList.size() == 0) {
            myfundMapper.delete(new QueryWrapper<MyFund>().eq("", ""));
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
        FundUser fundUser = funduserMapper.selectById(userId);
        if (fundUser == null) {
            return ApiResult.error(1202, "该用户不存在");
        }
        List<MyFund> mySelectedFundList = myfundMapper.selectList(
                new QueryWrapper<MyFund>().eq("user_id", userId));
        if (mySelectedFundList == null || mySelectedFundList.size() == 0) {
            return ApiResult.success(mySelectedFundList);
        }
        List<ChinaMutualFundDescription> chinaMutualFundDescriptions = new ArrayList<>();
        for (MyFund myFund : mySelectedFundList) {
            ChinaMutualFundDescription myFundDesc = chinamutualfunddescriptionMapper.selectById(
                    myFund.getId()
            );
            chinaMutualFundDescriptions.add(myFundDesc);
        }
        for (ChinaMutualFundDescription chinaMutualFundDescription : chinaMutualFundDescriptions) {
            String fInfoCode = chinaMutualFundDescription.getFInfoWindCode();

            // List<> chinamutualfundnavList =
            //         chinamutualfundnavMapper.selectList(
            //                 new QueryWrapper<Chinamutualfundnav>().eq("f_info_windcode", fInfoCode)
            //         );
            // System.out.println(chinamutualfundnavList);
            // if (chinamutualfundnavList != null && chinamutualfundnavList.size() > 0) {
            //     chinaMutualFundDescription.setNewNavUnit() = chinamutualfundnavList.get(0).getFNavUnit();
            // }
        }
        return ApiResult.success(chinaMutualFundDescriptions);
    }
}
