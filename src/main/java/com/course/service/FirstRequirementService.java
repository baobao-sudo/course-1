package com.course.service;

import com.course.form.FirstRequirementForm;
import com.course.form.FirstRequirementUpdateForm;
import com.course.vo.ResultVO;

/**
 * @Description 一级指标点的操作
 * @ClassName FirstRequirementService
 * @Author: baobao
 * @Date: Created in 16:17 2020/10/9
 */
public interface FirstRequirementService {

    /**
     * 插入一级指标点
     * @param firstRequirementForm
     * @return
     */
    ResultVO insertFirstRequirement(FirstRequirementForm firstRequirementForm);

    /**
     * 更新一级指标点
     * @param firstRequirementUpdateForm
     * @return
     */
    ResultVO updateFirstRequirement(FirstRequirementUpdateForm firstRequirementUpdateForm);

    /**
     * 获取所有的一级指标点
     * @return
     */
    ResultVO findAllFirstRequirement();


    /**
     * 删除一级指标点
     * @param firstRequirementId
     * @return
     */
    ResultVO deleteFirstRequirement(Integer firstRequirementId);


}
