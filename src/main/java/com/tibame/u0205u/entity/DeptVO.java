package com.tibame.u0205u.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEPT3")
public class DeptVO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer deptno;
    private String dname;
    private String loc;
    private Set<EmpVO> emps = new HashSet<EmpVO>();

    public DeptVO() {}

    @Id
    @Column(name = "DEPTNO")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY) // @GeneratedValue的generator屬性指定要用哪個generator
    // //【strategy的GenerationType,
    // 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public Integer getDeptno() {
        return this.deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Column(name = "DNAME")
    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Column(name = "LOC")
    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "deptVO")
    @OrderBy("empno asc")
    @JsonIgnore
    // 註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
    // 註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
    // 註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"
    // inverse="true"之意】
    // FetchType.EAGER : Defines that data must be eagerly fetched
    // FetchType.LAZY  : Defines that data can be lazily fetched
    public Set<EmpVO> getEmps() {
        return this.emps;
    }

    public void setEmps(Set<EmpVO> emps) {
        this.emps = emps;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        DeptVO deptVO = (DeptVO) o;
        return getDeptno() != null && Objects.equals(getDeptno(), deptVO.getDeptno());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
