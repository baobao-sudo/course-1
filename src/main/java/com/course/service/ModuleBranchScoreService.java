package com.course.service;

import com.course.form.InitializeForm;
import com.course.form.UpdateScoreForm;
import com.course.form.UploadScoreByExcelForm;
import com.course.form.UploadScoreForm;
import com.course.vo.ResultVO;

import java.util.List;

/**
 * @Description 小题成绩接口
 * @ClassName ModuleBranchScoreService
 * @Author: baobao
 * @Date: Created in 16:00 2020/11/19
 */
public interface ModuleBranchScoreService {

    /**
     * 上传成绩
     * @param uploadScoreForms
     * @return
     */
    ResultVO uploadScore(List<UploadScoreForm> uploadScoreForms);


    /**
     * 初始化输入进入成绩界面
     * @param initializeForm
     * @return
     */
    ResultVO initialize(InitializeForm initializeForm);

    /**
     * 更新成绩
     * @param updateScoreForms
     * @return
     */
    ResultVO updateScore(List<UpdateScoreForm> updateScoreForms);


    /**
     * 下载模板，这个是要生成一个动态的excel的
     * @param moduleId
     * @return
     */
    ResultVO downloadTemplate(Integer moduleId);

    /**
     * 通过模板上传成绩
     * @param uploadScoreByExcelForm
     * @return
     */
    ResultVO uploadScoreByExcel(UploadScoreByExcelForm uploadScoreByExcelForm);


}
