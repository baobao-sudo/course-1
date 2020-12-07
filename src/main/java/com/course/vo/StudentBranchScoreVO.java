package com.course.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 初始化输入成绩界面的
 * @ClassName StudentBranchScoreVO
 * @Author: baobao
 * @Date: Created in 15:01 2020/11/26
 */
@Data
public class StudentBranchScoreVO {

    private String stuNo;

    private String name;

    List<BranchScoreVO> branchScoreVOS;

}
