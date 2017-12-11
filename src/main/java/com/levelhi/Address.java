package com.levelhi;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Author:jiexuan
 * @Description:
 * @Date: Created in 10:57 2017/12/11
 * @Modified By:
 */

@Embeddable
//地址类
public class Address implements Serializable{

    private String postcode;    //邮编
    private String phone;   //电话
    private String address; //地址

    public Address() {
    }

    public Address(String postcode, String phone, String address) {
        this.postcode = postcode;
        this.phone = phone;
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
