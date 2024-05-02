package com.tibame.u0205u.service;

import com.tibame.u0205u.entity.DeptVO;
import com.tibame.u0205u.entity.EmpVO;

import java.util.*;

public interface DeptService {

    void addDept(DeptVO deptVO);

    void updateDept(DeptVO deptVO);

    void deleteDept(Integer deptno);

    DeptVO getOneDept(Integer deptno);

    List<DeptVO> getAll();

    Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
