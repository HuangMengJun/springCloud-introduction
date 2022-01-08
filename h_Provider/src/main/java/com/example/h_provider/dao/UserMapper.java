package com.example.h_provider.dao;


import com.example.h_pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

//    @Select(" select * from `user` where name = #{name}")
    User findByName(@Param("name") String name);

    List<User> findByUser();
}
