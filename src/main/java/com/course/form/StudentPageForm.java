package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 分页获取学生的表单
 * @ClassName StudentPageForm
 * @Author: baobao
 * @Date: Created in 16:21 2020/10/17
 */
@Data
public class StudentPageForm {

    @ApiModelProperty("页数")
    private Integer pageNum;

    @ApiModelProperty("每页数量")
    private Integer pageSize;

    @ApiModelProperty("年级")
    private Integer grade;
}
