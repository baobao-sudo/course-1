package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 上传课程矩阵的时候用到
 * @ClassName MatrixForm
 * @Author: baobao
 * @Date: Created in 21:04 2020/12/2
 */
@Data
public class MatrixForm {

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("课程指标excel")
    private MultipartFile multipartFile;
}
