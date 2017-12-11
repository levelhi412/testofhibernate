package com.levelhi;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Arrays;

/**
 * @Author:jiexuan
 * @Description:
 * @Date: Created in 9:54 2017/12/11
 * @Modified By:
 */
@Entity
public class Goods {
    private int sid;
    private String name;
    private Double price;
    private Date time;
    private Blob picture;
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name="postcode", column=@Column(name="postcade")),
            @AttributeOverride(name="phone", column=@Column(name="phone", length=20)),
            @AttributeOverride(name="address", column=@Column(name="address", length=20))
    })
    private Address address;

    public Goods() {
    }

    public Goods(int sid, String name, Double price, Date time, Blob picture) {
        this.sid = sid;
        this.name = name;
        this.price = price;
        this.time = time;
        this.picture = picture;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "picture")
    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (sid != goods.sid) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (price != null ? !price.equals(goods.price) : goods.price != null) return false;
        if (time != null ? !time.equals(goods.time) : goods.time != null) return false;
        return picture != null ? picture.equals(goods.picture) : goods.picture == null;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", picture=" + picture +
                ", address=" + address +
                '}';
    }
}
