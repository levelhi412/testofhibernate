package com.levelhi;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:jiexuan
 * @Description:
 * @Date: Created in 15:38 2017/12/11
 * @Modified By:
 */
@Entity
public class Grade {
    private int gid;
    private String gname;
    private String gdesc;
    //在一方定义一个多方的集合
    /*@OneToMany                                          //指定一对多关系
    @Cascade(value={CascadeType.MERGE})         //设定级联关系
    @JoinColumn(name="gid")                       //指定与本类主键所对应的外表的外键*/
    private Set<Student> students = new HashSet<Student>();


    @Id
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "gname")
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "gdesc")
    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (gid != grade.gid) return false;
        if (gname != null ? !gname.equals(grade.gname) : grade.gname != null) return false;
        if (gdesc != null ? !gdesc.equals(grade.gdesc) : grade.gdesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + (gdesc != null ? gdesc.hashCode() : 0);
        return result;
    }
}
