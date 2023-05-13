package com.xiao.raining.vo.user;

import java.io.Serializable;

/**
 * 用户
 * Author: xiaojl
 * Date:2023-04-08 23:17
 */
public class UserVO implements Serializable {
    private static final long serialVersionUID = 5352530239373700521L;
    
    private String vcode;
    private String vname;
    private String vpassword;
    private String pk_user;

    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVpassword() {
        return vpassword;
    }

    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }
}
