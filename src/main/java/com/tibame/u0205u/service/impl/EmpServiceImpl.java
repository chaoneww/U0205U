package com.tibame.u0205u.service.impl;

import com.tibame.u0205u.dto.EmpAddReqDTO;
import com.tibame.u0205u.dto.EmpUpdateReqDTO;
import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;
import com.tibame.u0205u.repository.EmpRepository;
import com.tibame.u0205u.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired EmpRepository empRepository;

    @Override
    public Integer addEmp(EmpAddReqDTO empReq) throws IOException {
        EmpVO empVO = new EmpVO();

        empVO.setEname(empReq.getEname());
        empVO.setDeptno(empReq.getDeptno());
        empVO.setJob(empReq.getJob());
        empVO.setHiredate(empReq.getHiredate());
        empVO.setSal(empReq.getSal());
        empVO.setComm(empReq.getComm());
        empVO.setUpFiles(empReq.getUpFiles().getBytes());

        empVO = empRepository.save(empVO);

        return empVO.getEmpno();
    }

    @Override
    public Integer updateEmp(EmpUpdateReqDTO updatedEmpVO)
            throws CheckRequestErrorException, IOException {
        EmpVO existingEmpVO =
                empRepository
                        .findById(updatedEmpVO.getEmpno())
                        .orElseThrow(() -> new CheckRequestErrorException("查無此員工資料"));

        existingEmpVO.setEname(updatedEmpVO.getEname());
        existingEmpVO.setDeptno(updatedEmpVO.getDeptno());
        existingEmpVO.setJob(updatedEmpVO.getJob());
        existingEmpVO.setHiredate(updatedEmpVO.getHiredate());
        existingEmpVO.setSal(updatedEmpVO.getSal());
        existingEmpVO.setComm(updatedEmpVO.getComm());
        existingEmpVO.setUpFiles(updatedEmpVO.getUpFiles().getBytes());

        empRepository.save(existingEmpVO);
        return existingEmpVO.getEmpno();
    }

    @Override
    public void deleteEmp(Integer empno) throws CheckRequestErrorException {
        if (empRepository.existsById(empno)) {
            empRepository.deleteByEmpno(empno);
        } else {
            throw new CheckRequestErrorException("查無此員工資料");
        }

        //	repository.deleteById(empno);
    }

    @Override
    public EmpVO getOneEmp(Integer empno) {
        Optional<EmpVO> optional = empRepository.findById(empno);
        // return optional.get();
        // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
        return optional.orElse(null);
    }

    @Override
    public List<EmpVO> getAll() {
        //        return empRepository.findAll();
        List<EmpVO> result = empRepository.findAll();
        return result;
    }

    // public List<EmpVO> getAll(Map<String, String[]> map) {
    //     return HibernateUtil_CompositeQuery_Emp3.getAllC(map,sessionFactory.openSession());
    // }
}
