package com.nan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nan.domain.User;
import com.nan.domain.UserCustom;
import com.nan.pojo.QueryVo;

import java.util.List;

public interface UserMapper  extends BaseMapper<User> {

    public User findUerByID(int id);


    public List<UserCustom> findUserList(QueryVo queryVo);

    public int findUserListCount(QueryVo queryVo);

    public List<UserCustom> getUserListWhere (QueryVo queryVo);

    public List<User> getAllUser();


}
