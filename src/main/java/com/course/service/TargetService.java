package com.course.service;

import com.course.form.TargetForm;
import com.course.form.TargetUpdateFrom;
import com.course.vo.ResultVO;
import io.swagger.models.auth.In;

/**
 * @Description 目标设计
 * @ClassName TargetService
 * @Author: baobao
 * @Date: Created in 16:07 2020/10/4
 */
public interface TargetService {

    /**
     * 添加毕业目标
     * @param targetForm
     * @return
     */
    ResultVO addTarget(TargetForm targetForm);

    /**
     * 修改毕业目标
     * @param updateFrom
     * @return
     */
    ResultVO editTarget(TargetUpdateFrom updateFrom);

    /**
     * 删除毕业目标
     * @param targetId
     * @return
     */
    ResultVO deleteTarget(Integer targetId);

    /**
     * 获取所有毕业目标
     * @param planId 教学计划ID
     * @return 返回
     */
    ResultVO findAll(Integer planId);


}
