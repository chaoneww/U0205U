package com.tibame.u0205u.service.impl;

import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;
import com.tibame.u0205u.repository.EmpRepository;
import com.tibame.u0205u.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired EmpRepository empRepository;

    public Integer addEmp(EmpVO empVO) {
        EmpVO emp = new EmpVO();
        emp = empRepository.save(empVO);
        return emp.getEmpno();
    }

    public void updateEmp(EmpVO updatedEmpVO) throws CheckRequestErrorException {
        EmpVO existingEmpVO =
                empRepository
                        .findById(updatedEmpVO.getEmpno())
                        .orElseThrow(() -> new CheckRequestErrorException("查無此員工資料"));

        existingEmpVO.setEname(updatedEmpVO.getEname());
        existingEmpVO.setDeptVO(updatedEmpVO.getDeptVO());
        existingEmpVO.setJob(updatedEmpVO.getJob());
        existingEmpVO.setHiredate(updatedEmpVO.getHiredate());
        existingEmpVO.setSal(updatedEmpVO.getSal());
        existingEmpVO.setComm(updatedEmpVO.getComm());
        existingEmpVO.setUpFiles(updatedEmpVO.getUpFiles());

        empRepository.save(existingEmpVO);
    }

    public void deleteEmp(Integer empno) throws CheckRequestErrorException {
        if (empRepository.existsById(empno)) {
            empRepository.deleteByEmpno(empno);
        } else {
            throw new CheckRequestErrorException("查無此員工資料");
        }

        //		    repository.deleteById(empno);
    }

    public EmpVO getOneEmp(Integer empno) {
        Optional<EmpVO> optional = empRepository.findById(empno);
        //		return optional.get();
        return optional.orElse(null); // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
    }

    public List<EmpVO> getAll() {
        return empRepository.findAll();
    }

    //    public List<EmpVO> getAll(Map<String, String[]> map) {
    //        return HibernateUtil_CompositeQuery_Emp3.getAllC(map,sessionFactory.openSession());
    //    }
}
