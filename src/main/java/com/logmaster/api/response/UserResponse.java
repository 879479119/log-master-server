package com.logmaster.api.response;


import com.logmaster.application.constants.Constants;
import com.logmaster.domain.model.User;


/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/13.
 */


public class UserResponse {

    private Integer id;

    private String name;

    private Integer role;

    private String roleName;


    public UserResponse() {
    }

    /**
     * 构造方法.
     * @param user 用户
     */
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
        this.roleName = Constants.ROLE_MAP.get(user.getRole());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
