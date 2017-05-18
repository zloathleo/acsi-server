package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Leo on 2017/5/16.
 */
@Mapper
public interface UserMapper {

    Integer getCount();

    UserEntity findUserById(Integer id);

    UserEntity findUserByUserName(String userName);

}
