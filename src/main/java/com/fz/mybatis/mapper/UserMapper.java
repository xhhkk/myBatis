package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.UserDo;

import java.util.List;

/**
 * Created by Created by Administrator on 2017/4/12.
 */
public interface UserMapper {

    public UserDo queryById(UserDo userDo);

    public UserDo findById(Integer userId);

    public List<UserDo> queryByList(UserDo userDo);

    public Integer addUser(UserDo userDo);

    public Integer modifyUser(UserDo userDo);

    public Integer delUser(UserDo userDo);
}