package com.tibame.u0205u.controller;

import com.tibame.u0205u.dto.ResDTO;
import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;
import com.tibame.u0205u.service.EmpService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmpApiController {

    @Autowired private EmpService empService;

    @PostMapping
    public ResDTO<Integer> addEmp(@Valid @RequestBody EmpVO empVO) {
        ResDTO<Integer> res = new ResDTO<>();
        res.setData(empService.addEmp(empVO));
        return res;
    }

    @PutMapping()
    public ResDTO<?> updateEmp(@Valid @RequestBody EmpVO empVO) throws CheckRequestErrorException {
        ResDTO<Integer> res = new ResDTO<>();
        empService.updateEmp(empVO);
        return res;
    }

    @DeleteMapping("/{empno}")
    public ResDTO<?> deleteEmp(@PathVariable Integer empno) throws CheckRequestErrorException {
        empService.deleteEmp(empno);
        return new ResDTO<>();
    }

    @GetMapping("/{empno}")
    public ResDTO<EmpVO> getOneEmp(@PathVariable Integer empno) {
        ResDTO<EmpVO> res = new ResDTO<>();
        EmpVO empVO = empService.getOneEmp(empno);
        res.setData(empVO);
        return res;
    }

    @GetMapping
    public ResDTO<List<EmpVO>> getAll() {
        ResDTO<List<EmpVO>> res = new ResDTO<>();
        List<EmpVO> empVOList = empService.getAll();
        res.setData(empVOList);
        return res;
    }
}
