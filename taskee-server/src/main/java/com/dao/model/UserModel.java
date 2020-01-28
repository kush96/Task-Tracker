package com.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    private Integer userId;
    private String userName;
    private String password;
    private Integer enterpriseId;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name="user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "id_enterprise")
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}