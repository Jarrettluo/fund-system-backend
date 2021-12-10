package com.example.fundsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.mapper.FunduserMapper;
import com.example.fundsystembackend.service.FundUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fundsystembackend.service.TokenService;
import com.example.fundsystembackend.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FundUserServiceImpl extends ServiceImpl<FunduserMapper, FundUser> implements FundUserService {

    @Autowired
    private FunduserMapper funduserMapper;

    @Autowired
    TokenService tokenService;

    @Override
    public ApiResult loginUser(FundUser fundUser) {
        if(fundUser.getUserName() == null || fundUser.getUserPassword() == null) {
            return ApiResult.error(1201, "参数不足");
        }
        FundUser dbFundUser = funduserMapper.selectOne(new QueryWrapper<FundUser>()
                .eq("user_name", fundUser.getUserName()));
        if(dbFundUser == null) {
            return ApiResult.error(1201,"登录失败,用户不存在");
        }
        if(!dbFundUser.getUserPassword().equals(fundUser.getUserPassword())) {
            return ApiResult.error(1202, "登录失败,密码错误");
        }

        String token = tokenService.getToken(fundUser);
        return ApiResult.success(token);


    }

    @Override
    public ApiResult logoutUser(FundUser fundUser) {
        return null;
    }

    @Override
    public ApiResult register(FundUser fundUser) {
        if(fundUser.getUserId() == null || fundUser.getUserId().equals("")) {
            return ApiResult.error(1201, "userId不能为空");
        }
        if(fundUser.getUserName() == null || fundUser.getUserName().equals("")){
            return ApiResult.error(1201, "uername不能为空");
        }
        if(fundUser.getUserPassword() == null || fundUser.getUserPassword().equals("")) {
            return ApiResult.error(1201, "passWord不能为空");
        }
        if(fundUser.getUserTelephone() == null || fundUser.getUserTelephone().equals("")) {
            return ApiResult.error(1201, "telephone不能为空");
        }
        funduserMapper.insert(fundUser);
        return ApiResult.success("success");
    }
}
