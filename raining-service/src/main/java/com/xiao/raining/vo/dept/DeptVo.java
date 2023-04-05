package com.xiao.raining.vo.dept;

import java.io.Serializable;

/**
 * 部门档案
 * Author: xiaojl
 * Date:2023-04-05 11:07
 */
public class DeptVo implements Serializable {
    
    private static final long serialVersionUID = 5231841155883593184L;
    
    private Integer id;
    private String vcode;
    private String vname;
    private String vlocation;

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

    public String getVlocation() {
        return vlocation;
    }

    public void setVlocation(String vlocation) {
        this.vlocation = vlocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
