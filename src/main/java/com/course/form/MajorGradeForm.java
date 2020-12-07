package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName MajorGradeForm
 * @Author: baobao
 * @Date: Created in 17:10 2020/10/29
 */
@Data
public class MajorGradeForm {

    @ApiModelProperty("年级")
    private Integer grade;
}
