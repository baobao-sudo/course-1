package com.course.service.impl;

import com.course.dao.MajorGradeMapper;
import com.course.enums.ResultEnum;
import com.course.form.MajorGradeForm;
import com.course.model.MajorGrade;
import com.course.service.MajorGradeService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 年级的新建
 * @ClassName MajorGradeServiceImpl
 * @Author: baobao
 * @Date: Created in 17:12 2020/10/29
 */
@Service
public class MajorGradeServiceImpl implements MajorGradeService {

    @Autowired
    private MajorGradeMapper majorGradeMapper;

    @Autowired
    private UserService userService;

    @Override
    public ResultVO addGrade(MajorGradeForm majorGradeForm) {
        MajorGrade majorGrade = new MajorGrade();
        majorGrade.setGrade(majorGradeForm.getGrade());
        majorGrade.setMajorId(userService.getCurrentUser().getMajorId());
        int res = majorGradeMapper.insert(majorGrade);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteGrade(Integer grade) {
        int res = majorGradeMapper.deleteGrade(grade,userService.getCurrentUser().getMajorId());
        if(res == -1){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }
}
