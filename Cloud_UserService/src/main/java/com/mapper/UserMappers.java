package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMappers {
    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);
}
