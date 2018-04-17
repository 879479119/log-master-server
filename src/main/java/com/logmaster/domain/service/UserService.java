package com.logmaster.domain.service;


import com.logmaster.domain.enums.UserFavouriteEnum;
import com.logmaster.domain.enums.UserRoleEnum;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface UserService {


    /**
     * 获取用户列表.
     *
     * @param page 分页实体
     * @param user 用户名
     * @return List
     */
    List<User> getUserList(Pagination page, User user);

    /**
     * 获取用户总数.
     * @param user 用户名
     * @return Integer
     */
    Integer getUserNums(User user);

    /**
     * 获取用户信息.
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(Integer id);

    Integer getLoginId(String mail, String password);

//    String getUserPassword(String mail);


    /**
     * 用户信息补全.
     * @param user 用户
     * @return 用户信息
     */
    List<User> userComplete(User user);

}
