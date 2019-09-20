package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Provider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 使用Mybatis注解版
 */
//@Repository
//@Mapper //这是指定操作数据的mapper
public interface ProviderMapper {

    //${}哪边都能使用，只是存在sql注入风险，相当于直接拼接字符串，不对参数做任何处理。
    //#{}会进行预编译，对参数进行处理，防止注入
    @Select("select * from provider where pid=#{pid}")
    Provider getProviderByPid(Integer pid);

    // useGeneratedKeys是否自增主键, keyProperty指定实体中哪个属性封装主键,返回自增长主键值
    @Options(useGeneratedKeys = true,keyProperty = "pid")
    @Insert("insert into provider(providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider wher pid=#{pid}")
    int deleteProvider(Provider provider);

    @Update("update provider set providerName=#{providerName} where pid = #{pid}")
    int updateProvider(Provider provider);
}
