package com.course.service;

import com.course.form.StudentForm;
import com.course.form.StudentPageForm;
import com.course.form.StudentUpdateForm;
import com.course.vo.ResultVO;
import com.course.vo.StudentVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @ClassName StudentService
 * @Author: baobao
 * @Date: Created in 21:00 2020/10/14
 */
public interface StudentService {

    /**
     * 分页查询获取
     * @param pageForm 分页表单
     * @return 返回学生
     */
    ResultVO findStudentByPage(StudentPageForm pageForm);

    /**
     * 增加学生
     * @param studentForm
     * @return
     */
    ResultVO insertStudent(StudentForm studentForm);

    /**
     * 删除学生通过学号
     * @param studentNo
     * @return
     */
    ResultVO deleteStudent(String studentNo);

    /**
     * 更新学生
     * @param updateForm
     * @return
     */
    ResultVO updateStudent(StudentUpdateForm updateForm);

    /**
     * 通过学号获取学生
     * @param studentNo
     * @param grade
     * @return
     */
    ResultVO<StudentVO> getStudentByStudentNo(String studentNo, Integer grade);

    /**
     *  通过名字查询学生
     * @param name
     * @param grade
     * @return
     */
    ResultVO<List<StudentVO>> getStudentByName(String name,Integer grade);

    /**
     * 获取所有当前年级专业的学生
     * @param grade
     * @return
     */
    ResultVO<List<StudentVO>> getStudents(Integer grade);

    /**
     * 批量上传学生
     * @param file
     * @return
     * @throws IOException
     */
    ResultVO uploadStudent(MultipartFile file) throws IOException;

//    /**
//     *
//     * @param filename
//     * @return
//     */
//    ResultVO downloadTemplate(String filename);
}
