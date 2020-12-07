package com.course.vo;

import com.course.model.ModuleBranch;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 获取所有的模块分支
 * @ClassName ModuleBranchVO
 * @Author: baobao
 * @Date: Created in 14:25 2020/11/19
 */
@Data
public class ModuleBranchVO {

    private Integer moduleId;

    private Integer planId;

    private String moduleName;

    private BigDecimal percentage;

    List<ModuleBranch> moduleBranches;
}
