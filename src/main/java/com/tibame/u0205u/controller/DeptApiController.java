package com.tibame.u0205u.controller;

import com.tibame.u0205u.dto.ResDTO;
import com.tibame.u0205u.entity.DeptVO;
import com.tibame.u0205u.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DeptApiController {

    @Autowired private DeptService deptService;
//
//    @PostMapping
//    public ResDTO<Integer> addEmp(@RequestBody DeptVO empVO) {
//        ResDTO<Integer> res = new ResDTO<>();
//        res.setData(empService.addEmp(empVO));
//        return res;
//    }
//
//    @PutMapping("/{deptno}")
//    public ResDTO<?> updateEmp(@Valid @RequestBody DeptVO empVO) {
//        ResDTO<Integer> res = new ResDTO<>();
//        empService.updateEmp(empVO);
//        return res;
//    }
//
//    @DeleteMapping("/{deptno}")
//    public ResDTO<?> deleteEmp(@PathVariable Integer deptno) {
//        empService.deleteEmp(deptno);
//        return new ResDTO<>();
//    }
//
    @GetMapping("/{deptno}")
    public ResDTO<DeptVO> getOneEmp(@PathVariable Integer deptno) {
        ResDTO<DeptVO> res = new ResDTO<>();
        DeptVO empVO = deptService.getOneDept(deptno);
        res.setData(empVO);
        return res;
    }

    @GetMapping
    public ResDTO<List<DeptVO>> getAll() {
        ResDTO<List<DeptVO>> res = new ResDTO<>();
        List<DeptVO> list = deptService.getAll();
        res.setData(list);
        return res;
    }
}
