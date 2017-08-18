package com.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.permission.model.Privilege;

public interface PrivilegeMapper {
	
	
	@Delete({
		"delete from sys_privilege",
		"where id = #{id,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer id);
	
	
	@Insert({
        "insert into sys_privilege (id,pid,name,url,isEnable)",
        "values (#{id,jdbcType=INTEGER},#{pid,jdbcType=INTEGER},#{name,jdbcType=VARCHAR},#{url,jdbcType=VARCHAR},#{isEnable,jdbcType=TINYINT})"
    })
    int insert(Privilege sys_privilege);
    
    
     @Select({
        "select",
        "id,pid,name,url,isEnable",
        "from sys_privilege"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
    	,@Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER )
    	,@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="url", property="url", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="isEnable", property="isEnable", jdbcType=JdbcType.TINYINT )
    	
    })
    List<Privilege> selectAll();
    
    
     @Select({
        "select",
        "id,pid,name,url,isEnable",
        "from sys_privilege where id=#{id,jdbcType=INTEGER}"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
    	,@Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER )
    	,@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="url", property="url", jdbcType=JdbcType.VARCHAR )
    	,@Result(column="isEnable", property="isEnable", jdbcType=JdbcType.TINYINT )
    	
    })
    Privilege selectByPrimaryKey(Integer id);
    
     @Update({  
        "update sys_privilege" , 
        "set pid = #{pid,jdbcType=INTEGER},name = #{name,jdbcType=VARCHAR},url = #{url,jdbcType=VARCHAR},isEnable = #{isEnable,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}" 
    })
    int updateByPrimaryKey(Privilege sys_privilege);
    
     
    /**
     * 根据userid查询权限
     * */
     @Select({
         "SELECT p.id,p.pid,p.name,p.url,p.isEnable FROM sys_privilege p INNER JOIN sys_role_privilege rp ON p.id=rp.privilege_id INNER JOIN sys_role r ON rp.role_id=r.id INNER JOIN sys_user_roles ur ON r.id = ur.role_id INNER JOIN sys_user u ON ur.user_id=u.id AND u.id=#{id}"
     })
     @Results({
    	 @Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
     	,@Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER )
     	,@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR )
     	,@Result(column="url", property="url", jdbcType=JdbcType.VARCHAR )
     	,@Result(column="isEnable", property="isEnable", jdbcType=JdbcType.TINYINT )
     })
     List<Privilege> findPrivilegeByUserId(Integer id);
     /**
      * 根据userid查询权限
      * */
     @Select({"select id,pid,name,url,isEnable from sys_privilege p where p.url=#{url}"})
     @Results({
    	 @Result(column="id", property="id", jdbcType=JdbcType.INTEGER ,id=true)
     	,@Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER )
     	,@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR )
     	,@Result(column="url", property="url", jdbcType=JdbcType.VARCHAR )
     	,@Result(column="isEnable", property="isEnable", jdbcType=JdbcType.TINYINT )
      })
     List<Privilege> findPrivilegeByUrl(String url);
}