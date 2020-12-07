package com.course.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Description 教学目标
 * @ClassName TargetVO
 * @Author: baobao
 * @Date: Created in 21:29 2020/10/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetVO implements Serializable {

    private static final long serialVersionUID = -4375912150481053856L;

    private Integer targetId;

    private Integer order;

    private String description;

    private String targetName;

    private String secondRequirementSequence;
}
