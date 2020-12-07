package com.course.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 二级指标点更新
 * @ClassName FirstRequirementUpdateForm
 * @Author: baobao
 * @Date: Created in 17:04 2020/10/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstRequirementUpdateForm {

    private Integer firstRequirementId;

    private String detail;

    private String description;
}
