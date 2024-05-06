package com.tibame.u0205u.service;

import com.tibame.u0205u.dto.EmpAddReqDTO;
import com.tibame.u0205u.dto.EmpUpdateReqDTO;
import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;

import java.io.IOException;
import java.util.*;

public interface EmpService {

    Integer addEmp(EmpAddReqDTO req) throws IOException;

    Integer updateEmp(EmpUpdateReqDTO req) throws CheckRequestErrorException, IOException;

    void deleteEmp(Integer empno) throws CheckRequestErrorException;

    EmpVO getOneEmp(Integer empno);

    List<EmpVO> getAll();

    //    public List<EmpVO> getAll(Map<String, String[]> map);
}
