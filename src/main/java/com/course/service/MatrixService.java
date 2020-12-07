package com.course.service;

import com.course.form.ListMatrixForm;
import com.course.form.MatrixAttachedFrom;
import com.course.form.MatrixForm;
import com.course.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Description 课程矩阵的方法
 * @ClassName MatrixService
 * @Author: baobao
 * @Date: Created in 11:05 2020/11/28
 */
public interface MatrixService {

    /**
     * 通过文档上传导入课程内容
     * @param matrixForm
     * @return
     */
    ResultVO upload(MatrixForm matrixForm);

    /**
     * 展示所有的矩阵约束
     * @param listMatrixForm
     * @return
     */
    ResultVO list(ListMatrixForm listMatrixForm);

    /**
     * 获取所有一级二级指标点数量展示出来
     * @return
     */
    ResultVO getRequirementByMajor();



}
