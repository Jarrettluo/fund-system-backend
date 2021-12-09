package com.example.fundsystembackend.service.impl;

import com.example.fundsystembackend.entity.FundUser;
import com.example.fundsystembackend.mapper.FunduserMapper;
import com.example.fundsystembackend.service.FundUserService;
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
public class FundUserServiceImpl extends ServiceImpl<FunduserMapper, FundUser> implements FundUserService {
    @Override
    public ApiResult loginUser(FundUser fundUser) {
        return null;
    }

    @Override
    public ApiResult logoutUser(FundUser fundUser) {
        return null;
    }
}
