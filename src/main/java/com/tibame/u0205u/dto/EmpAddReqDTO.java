package com.tibame.u0205u.dto;

import com.tibame.u0205u.entity.DeptVO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Getter
@Setter
@ToString
public class EmpAddReqDTO {
    private Integer empno;

    private Integer deptno;

    @NotEmpty(message = "員工姓名: 請勿空白")
    @Pattern(
            regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$",
            message = "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間")
    private String ename;

    @NotEmpty(message = "員工職位: 請勿空白")
    @Size(min = 2, max = 10, message = "員工職位: 長度必需在{min}到{max}之間")
    private String job;

    private Date hiredate;

    @NotNull(message = "員工薪水: 請勿空白")
    @DecimalMin(value = "10000.00", message = "員工薪水: 不能小於{value}")
    @DecimalMax(value = "99999.99", message = "員工薪水: 不能超過{value}")
    private Double sal;

    @DecimalMin(value = "1.00", message = "員工獎金: 不能小於{value}")
    @DecimalMax(value = "99999.99", message = "員工獎金: 不能超過{value}")
    private Double comm;

    // @NotEmpty(message = "員工照片: 請上傳照片")
    private MultipartFile upFiles;
}
