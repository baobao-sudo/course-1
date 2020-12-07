package com.course.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 展示一直标点返回的值
 * @ClassName FirstRequirementVO
 * @Author: baobao
 * @Date: Created in 19:50 2020/10/10
 */
@Data
@NoArgsConstructor
public class FirstRequirementVO implements Serializable {

    private static final long serialVersionUID = -2860790165829213434L;
    private Integer firstRequirementId;

    private Integer firstRequirementNo;

    private String detail;

    private String description;
}
