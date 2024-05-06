package com.tibame.u0205u.controller;

import com.tibame.u0205u.dto.EmpAddReqDTO;
import com.tibame.u0205u.dto.EmpUpdateReqDTO;
import com.tibame.u0205u.dto.ResDTO;
import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.exception.CheckRequestErrorException;
import com.tibame.u0205u.service.EmpService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api") // localhost:8081/api/emp
public class EmpApiController {

    @Autowired private EmpService empService;

    @PostMapping("/emp")
    public ResDTO<Integer> addEmp(@Valid EmpAddReqDTO req)
            throws IOException, CheckRequestErrorException {
        // ResDTO<Integer> res = new ResDTO<>();
        if (req.getUpFiles().isEmpty()) {
            throw new CheckRequestErrorException("員工照片: 請上傳照片");
        }
        Integer res = empService.addEmp(req);
        return new ResDTO<>(res);
    }

    @PutMapping("/emp")
    public ResDTO<Integer> updateEmp(@Valid EmpUpdateReqDTO req)
            throws CheckRequestErrorException, IOException {
        Integer res = empService.updateEmp(req);
        return new ResDTO<>(res);
    }

    @DeleteMapping("/emp/{empno}")
    public ResDTO<?> deleteEmp(@PathVariable Integer empno) throws CheckRequestErrorException {
        empService.deleteEmp(empno);
        return new ResDTO<>();
    }
    @GetMapping("/emp/{empno}")
    public ResDTO<EmpVO> getOneEmp(@PathVariable Integer empno) {
        ResDTO<EmpVO> res = new ResDTO<>();
        EmpVO empVO = empService.getOneEmp(empno);
        res.setData(empVO);
        return res;
    }

    @GetMapping("/emp") // GET localhost:8081/api/emp
    public ResDTO<List<EmpVO>> getAll() {
        ResDTO<List<EmpVO>> res = new ResDTO<>();
        List<EmpVO> empVOList = empService.getAll();
        res.setData(empVOList);
        return res;
    }
}
