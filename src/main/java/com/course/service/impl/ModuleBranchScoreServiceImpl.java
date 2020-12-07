package com.course.service.impl;

import com.course.dao.ModuleBranchMapper;
import com.course.dao.ModuleBranchScoreMapper;
import com.course.dao.ModuleScoreMapper;
import com.course.dao.StudentMapper;
import com.course.form.*;
import com.course.model.ModuleBranchScore;
import com.course.model.ModuleScore;
import com.course.model.Student;
import com.course.service.ModuleBranchScoreService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.BranchScoreVO;
import com.course.vo.ResultVO;
import com.course.vo.StudentBranchScoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 模块小题的成绩操作
 * @ClassName ModuleBranchScoreServiceImpl
 * @Author: baobao
 * @Date: Created in 16:47 2020/11/25
 */
@Service
@Slf4j
public class ModuleBranchScoreServiceImpl implements ModuleBranchScoreService {

    @Autowired
    private ModuleBranchScoreMapper moduleBranchScoreMapper;

    @Autowired
    private ModuleScoreMapper moduleScoreMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ModuleBranchMapper moduleBranchMapper;


    /**
     * 这个初步想法，第一次进去的时候初始化，这个时候学生都没有输入，则是一个null的返回结果，可以通过这个来确定学生是否
     * 被输入成绩，然后有个mapper里面有个接口就是，如果如果存在就更新，不存在就更新
     * 前端可以判断是否为null，也可以上传和更新是分开的接口，而且
     * @param uploadScoreForms
     * @return
     */
    @Override
    public ResultVO uploadScore(List<UploadScoreForm> uploadScoreForms) {
        for(UploadScoreForm uploadScoreForm:uploadScoreForms){
            if(uploadScoreForm.getModuleScoreStatus() == 1){
                log.info("学生缺考！！！！");
                ModuleScore moduleScore = new ModuleScore();
                BeanUtils.copyProperties(uploadScoreForm,moduleScore);
                moduleScore.setPoint(new BigDecimal(0));
                moduleScoreMapper.insert(moduleScore);
            }else if(uploadScoreForm.getModuleScoreStatus() == 0 ){
                BigDecimal moduleScoreSum = new BigDecimal(0);
                BigDecimal moduleBranchScoreSum = moduleBranchMapper.getModuleBranchSum(uploadScoreForm.getModuleId());
                for(BranchScoreForm branchScoreForm:uploadScoreForm.getBranchScoreForms()){
                    ModuleBranchScore moduleBranchScore = new ModuleBranchScore();
                    moduleBranchScore.setStuNo(uploadScoreForm.getStuNo());
                    moduleBranchScore.setModuleBranchId(branchScoreForm.getModuleBranchId());
                    moduleBranchScore.setPoint(branchScoreForm.getPoint());
                    moduleScoreSum = moduleScoreSum.add(branchScoreForm.getPoint());
                    moduleBranchScoreMapper.insert(moduleBranchScore);
                }
                ModuleScore moduleScore = new ModuleScore();
                BeanUtils.copyProperties(uploadScoreForm,moduleScoreSum);
                moduleScore.setPoint(moduleScoreSum.divide(moduleBranchScoreSum,3).multiply(new BigDecimal(100)));
                moduleScoreMapper.insert(moduleScore);
            }
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO initialize(InitializeForm initializeForm) {
        List<Student> students = studentMapper.selectStudents(userService.getCurrentUser().getMajorId(),initializeForm.getGrade());
        List<StudentBranchScoreVO> studentBranchScoreVOS = new ArrayList<>();
        for(Student student:students){
            StudentBranchScoreVO studentBranchScoreVO = new StudentBranchScoreVO();
            studentBranchScoreVO.setStuNo(student.getStuNo());
            studentBranchScoreVO.setName(student.getName());
            List<BranchScoreVO> branchScoreVOS = new ArrayList<>();
            List<ModuleBranchScore> moduleBranchScores = moduleBranchScoreMapper.selectByModuleId(initializeForm.getModuleId(),student.getStuNo());
            for(ModuleBranchScore moduleBranchScore: moduleBranchScores){
                BranchScoreVO branchScoreVO = new BranchScoreVO();
                BeanUtils.copyProperties(moduleBranchScore,branchScoreVO);
                branchScoreVOS.add(branchScoreVO);
            }
            studentBranchScoreVO.setBranchScoreVOS(branchScoreVOS);
            studentBranchScoreVOS.add(studentBranchScoreVO);
        }
        return ResultVOUtil.success(studentBranchScoreVOS);
    }

    @Override
    public ResultVO updateScore(List<UpdateScoreForm> updateScoreForms){
     for(UpdateScoreForm updateScoreForm:updateScoreForms){
         if(updateScoreForm.getModuleScoreStatus() == 1){
             log.info("学生缺考！！！！");
             ModuleScore moduleScore = new ModuleScore();
             BeanUtils.copyProperties(updateScoreForm,moduleScore);
             moduleScore.setPoint(new BigDecimal(0));
             List<ModuleBranchScore> moduleBranchScores = moduleBranchScoreMapper.selectByModuleId(updateScoreForm.getModuleId(),updateScoreForm.getStuNo());
             if(moduleBranchScores != null){
                 for(ModuleBranchScore moduleBranchScore:moduleBranchScores){
                     moduleBranchScoreMapper.deleteByPrimaryKey(moduleBranchScore.getModuleBranchScoreId());
                 }
             }
             moduleScoreMapper.insert(moduleScore);
         }else if(updateScoreForm.getModuleScoreStatus() == 0){

             BigDecimal moduleScoreSum = moduleScoreMapper.selectByStudentAndModuleId(updateScoreForm.getStuNo(),updateScoreForm.getModuleId()).getPoint();
             BigDecimal moduleBranchScoreSum = moduleBranchMapper.getModuleBranchSum(updateScoreForm.getModuleId());
             for(UpdateBranchScoreForm updateBranchScoreForm:updateScoreForm.getUpdateBranchScoreForms()){
                 ModuleBranchScore moduleBranchScore = moduleBranchScoreMapper.selectByPrimaryKey(updateBranchScoreForm.getModuleBranchScoreId());
                 moduleScoreSum = moduleScoreSum.subtract(moduleBranchScore.getPoint()).add(updateBranchScoreForm.getPoint());
                 moduleBranchScore.setPoint(updateBranchScoreForm.getPoint());
                 moduleBranchScoreMapper.updateByPrimaryKey(moduleBranchScore);
             }
             ModuleScore moduleScore = new ModuleScore();
             BeanUtils.copyProperties(updateScoreForm,moduleScoreSum);
             moduleScore.setPoint(moduleScoreSum.divide(moduleBranchScoreSum,3).multiply(new BigDecimal(100)));
             moduleScoreMapper.insert(moduleScore);
         }
     }
      return ResultVOUtil.success();
    }

    @Override
    public ResultVO downloadTemplate(Integer moduleId) {
        return null;
    }

    @Override
    public ResultVO uploadScoreByExcel(UploadScoreByExcelForm uploadScoreByExcelForm) {
        return null;
    }


}
