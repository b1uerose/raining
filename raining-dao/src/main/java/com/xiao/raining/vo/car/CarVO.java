package com.xiao.raining.vo.car;

import java.io.Serializable;

/**
 * Author: xiaojl
 * Date:2023-05-14 14:48
 */
public class CarVO implements Serializable {

    private static final long serialVersionUID = -1900031595059763273L;
    
    private Long id;
    private String vcardno;
    private String vbrand;
    private Double nguideprice;
    private String dproducedate;
    private String vcartype;

    public String getVcardno() {
        return vcardno;
    }

    public void setVcardno(String vcardno) {
        this.vcardno = vcardno;
    }

    public String getVbrand() {
        return vbrand;
    }

    public void setVbrand(String vbrand) {
        this.vbrand = vbrand;
    }

    public Double getNguideprice() {
        return nguideprice;
    }

    public void setNguideprice(Double nguideprice) {
        this.nguideprice = nguideprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDproducedate() {
        return dproducedate;
    }

    public void setDproducedate(String dproducedate) {
        this.dproducedate = dproducedate;
    }

    public String getVcartype() {
        return vcartype;
    }

    public void setVcartype(String vcartype) {
        this.vcartype = vcartype;
    }

    @Override
    public String toString() {
        return "CarVO{" +
                "id=" + id +
                ", vcardno='" + vcardno + '\'' +
                ", vbrand='" + vbrand + '\'' +
                ", nguideprice=" + nguideprice +
                ", dproducedate='" + dproducedate + '\'' +
                ", vcartype='" + vcartype + '\'' +
                '}';
    }
}
