package com.logmaster.mapper.master;


import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

@Component
public interface UserMapper {

    /**
     * 查询用户列表.
     * @param page 页面
     * @return 用户列表
     */
    List<User> getUserList(@Param("page") Pagination page);

    /**
     * 获取用户条数.
     * @return 条数
     */
    Integer getUserNums();

    /**
     * 添加用户.
     *
     * @param user 用户信息
     * @return 主键ID
     */
    Integer addUser(@Param("user") User user);

    /**
     * 根据用户名获取用户信息.
     *
     * @param name 用户名
     * @return 用户信息
     */
    User getUserByName(@Param("name") String name);

    /**
     * 根据用户id获取用户信息.
     *
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 获取用户密码进行对比.
     * @return 用户信息
     */
    Integer getLoginId(@Param("mail") String mail, @Param("password") String password);

    /**
     * 根据角色获取用户列表.
     * @param role 角色
     * @return 超级管理员集合
     */
    List<String> getUserByRole(Integer role);

    /**
     * 用户信息自动补全.
     *
     * @param user 用户
     * @return 用户集合
     */
    List<User> userComplete(@Param("user") User user);

    /**
     * 根据任务类型获取审核人.
     * @param taskTypeId 任务类型id
     * @param subGroupId 二级分组id
     * @param role 角色
     * @return 审核人集合
     */
    List<String> getUserByTask(@Param("taskTypeId") Integer taskTypeId,
                               @Param("subGroupId") Integer subGroupId,
                               @Param("role") Integer role);

    /**
     * 根据用户角色.
     * @param id 用户id
     * @param role 用户角色
     */
    void updateUserRole(@Param("id") Integer id,@Param("role") Integer role);

}
