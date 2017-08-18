package com.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.permission.model.SysUser;

public interface SysUserMapper {
	@Delete({
		"delete from sys_user",
		"where id = #{id,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer id);
	
	
	@Insert({
        "insert into sys_user (id,username,password)",
        "values (#{id,jdbcType=INTEGER},#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR})"
    })
    int insert(SysUser sys_user);
    
    
     @Select({
        "select",
        "id,username,password",
        "from sys_user"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
    	,@Result(column="username", property="username", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="password", property="password", jdbcType=JdbcType.VARCHAR )
    	
    })
    List<SysUser> selectAll();
    
    
     @Select({
        "select",
        "id,username,password",
        "from sys_user where id=#{id,jdbcType=INTEGER}"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
    	,@Result(column="username", property="username", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="password", property="password", jdbcType=JdbcType.VARCHAR )
    	
    })
    SysUser selectByPrimaryKey(Integer id);
    
     @Update({  
        "update sys_user" , 
        "set username = #{username,jdbcType=VARCHAR},password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}" 
    })
    int updateByPrimaryKey(SysUser sys_user);
   
     @Select({
         "select",
         "id,username,password",
         "from sys_user where username=#{username,jdbcType=VARCHAR}"
     })
     @Results({
     	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
     	,@Result(column="username", property="username", jdbcType=JdbcType.VARCHAR )
     	,@Result(column="password", property="password", jdbcType=JdbcType.VARCHAR )
     	
     })
     SysUser findByUserName(String username);
}