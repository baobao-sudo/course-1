package com.course.service.impl;

import com.alibaba.excel.EasyExcel;
import com.course.dao.StudentMapper;
import com.course.dto.StudentDTO;
import com.course.enums.ResultEnum;
import com.course.form.StudentForm;
import com.course.form.StudentPageForm;
import com.course.form.StudentUpdateForm;
import com.course.listenter.StudentListener;
import com.course.model.Student;
import com.course.service.StudentService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import com.course.vo.StudentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 学生的实现
 * @ClassName StudentServiceImpl
 * @Author: baobao
 * @Date: Created in 21:08 2020/10/14
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
  private StudentMapper studentMapper;

    @Autowired
    private UserService userService;



    @Override
    public ResultVO findStudentByPage(StudentPageForm pageForm) {
        int majorId = userService.getCurrentUser().getMajorId();
        PageHelper.startPage(pageForm.getPageNum(),pageForm.getPageSize());
        List<Student> students = studentMapper.selectStudents(majorId,pageForm.getGrade());
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        log.info(students.toString());
        if(students == null){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }

        return ResultVOUtil.success(pageInfo);
    }

    @Override
    public ResultVO insertStudent(StudentForm studentForm) {
        Student student = new Student();
        BeanUtils.copyProperties(studentForm,student);
        student.setMajorId(userService.getCurrentUser().getMajorId());
        int res = studentMapper.insert(student);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteStudent(String studentNo) {
        int res = studentMapper.deleteByStudentNo(studentNo);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO updateStudent(StudentUpdateForm updateForm) {
        Student student = new Student();
        BeanUtils.copyProperties(updateForm,student);
        int res = (int) studentMapper.updateByStudentNo(student);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO getStudentByStudentNo(String studentNo, Integer grade) {
        Student student = studentMapper.selectByStudentNo(studentNo,userService.getCurrentUser().getMajorId(),grade);
        if(student == null){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return ResultVOUtil.success(studentVO);
    }

    @Override
    public ResultVO<List<StudentVO>> getStudentByName(String name,Integer grade) {
        List<Student> students = studentMapper.selectByStudentName(name,userService.getCurrentUser().getMajorId(),grade);
        List<StudentVO> studentVOS = new ArrayList<>();
        for(Student student:students){
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            studentVOS.add(studentVO);
        }
        return ResultVOUtil.success(studentVOS);
    }

    @Override
    public ResultVO<List<StudentVO>> getStudents(Integer grade) {
        List<Student> students = studentMapper.selectStudents(userService.getCurrentUser().getMajorId(),grade);
        List<StudentVO> studentVOS = new ArrayList<>();
        for(Student student:students){
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            studentVOS.add(studentVO);
        }
        return ResultVOUtil.success(studentVOS);
    }

    @Override
    public ResultVO uploadStudent(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(),StudentDTO.class, new StudentListener(studentMapper)).sheet().doRead();
        return ResultVOUtil.success();
    }
}
