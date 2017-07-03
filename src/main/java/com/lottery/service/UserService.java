package com.lottery.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.db.dao.LoginLogEntityMapper;
import com.lottery.db.dao.UserEntityMapper;
import com.lottery.db.entity.LoginLogEntity;
import com.lottery.db.entity.UserEntity;
import com.lottery.db.entity.UserEntityExample;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserEntityMapper userEntityMapper;
    @Resource
    private LoginLogEntityMapper loginLogEntityMapper;

    /**
     * 根据username查询用户
     *
     * @param username 用户名
     * @return 返回对象
     */
    public UserEntity getUserByUsername(String username) {
        UserEntityExample example = new UserEntityExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<UserEntity> userList = userEntityMapper.selectByExample(example);
        UserEntity user = null;
        if (CollectionUtils.isNotEmpty(userList)) {
            user = userList.get(0);
        }
        return user;
    }

    /**
     * 用户注册
     *
     * @param user 请求用户对象
     * @return 返回注册结果
     */
    public boolean register(UserEntity user) {
        try {
            userEntityMapper.insertSelective(user);
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            return false;
        }
        return true;
    }

    /**
     * 登录成功后的处理,更新登录时间和登录ip,记录登录日志
     *
     * @param user 登录用户对象
     */
    @Transactional
    public void loginSuccess(UserEntity user) {
        // 修改用户登录信息
        userEntityMapper.updateByPrimaryKeySelective(user);
        // 记录登录日志
        LoginLogEntity record = new LoginLogEntity();
        record.setIp(user.getLastip());
        record.setLoginTime(user.getLastvisit());
        record.setUserId(user.getUserId());
        loginLogEntityMapper.insertSelective(record);
    }

}
