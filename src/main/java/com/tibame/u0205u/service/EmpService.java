package com.tibame.u0205u.service;

import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;

import java.util.*;

public interface EmpService {

    Integer addEmp(EmpVO empVO);

    void updateEmp(EmpVO empVO) throws CheckRequestErrorException;

    void deleteEmp(Integer empno) throws CheckRequestErrorException;

    EmpVO getOneEmp(Integer empno);

    List<EmpVO> getAll();

    //    public List<EmpVO> getAll(Map<String, String[]> map);
}
