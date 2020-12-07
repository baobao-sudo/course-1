package com.course.controller;

import com.course.accessctro.RoleContro;
import com.course.enums.ResultEnum;
import com.course.enums.RoleEnum;
import com.course.form.StudentForm;
import com.course.form.StudentPageForm;
import com.course.form.StudentUpdateForm;
import com.course.service.StudentService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import com.course.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Description 学生管理
 * @ClassName StudentController
 * @Author: baobao
 * @Date: Created in 15:33 2020/10/29
 */
@RestController
@CrossOrigin
@RequestMapping("/api/student")
@Api(tags = "学生管理")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("分页获取学生")
    @PostMapping("/page")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO findStudentByPage(@Valid StudentPageForm pageForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return studentService.findStudentByPage(pageForm);
    }

    @ApiOperation("插入学生")
    @PostMapping("/add")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO insertStudent(@Valid StudentForm studentForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return studentService.insertStudent(studentForm);
    }

    @ApiOperation("删除学生")
    @GetMapping("/delete")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO deleteStudent(String studentNo){
        return studentService.deleteStudent(studentNo);
    }

    @ApiOperation("更新学生")
    @PostMapping("/update")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO updateStudent(@Valid StudentUpdateForm updateForm,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return studentService.updateStudent(updateForm);
    }

    @ApiOperation("通过学号获取学生")
    @GetMapping("/queryByNo")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO<StudentVO> getStudentByStudentNo(String studentNo, Integer grade){
        return studentService.getStudentByStudentNo(studentNo,grade);
    }

    @ApiOperation("通过学生姓名查询")
    @GetMapping("/queryByName")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO<List<StudentVO>> getStudentByName(String name, Integer grade){
        return studentService.getStudentByName(name,grade);
    }

    @ApiOperation("获取当前专业所有学生")
    @GetMapping("/list")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO<List<StudentVO>> getStudents(Integer grade){
        return studentService.getStudents(grade);
    }

    @ApiOperation("文件上传录入学生")
    @PostMapping("/upload")
    @RoleContro(role = RoleEnum.ADMIN)
    ResultVO uploadStudent(MultipartFile file) throws IOException{
        return studentService.uploadStudent(file);
    }
}
