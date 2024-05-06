package com.tibame.u0205u.controller;

import com.tibame.u0205u.dto.ResDTO;
import com.tibame.u0205u.entity.DeptVO;
import com.tibame.u0205u.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DeptApiController {

    @Autowired private DeptService deptService;

    @GetMapping("dept/{deptno}")
    public ResDTO<DeptVO> getOneDept(@PathVariable Integer deptno) {
        ResDTO<DeptVO> res = new ResDTO<>();
        DeptVO empVO = deptService.getOneDept(deptno);
        res.setData(empVO);
        return res;
    }

    @GetMapping("dept")
    public ResDTO<List<DeptVO>> getAll() {
        ResDTO<List<DeptVO>> res = new ResDTO<>();
        List<DeptVO> list = deptService.getAll();
        res.setData(list);
        return res;
    }
}
