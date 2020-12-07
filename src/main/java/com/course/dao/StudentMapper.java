package com.course.dao;

import com.course.dto.StudentDTO;
import com.course.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    Student selectByPrimaryKey(Integer stuId);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    /**
     * 获取本专业学生的最大年级返回出来
     * @param majorId
     * @return
     */
    int selectMaxGrade(Integer majorId);


    /**
     * 获取本专业年级的所有学生
     * @param majorId
     * @param grade
     * @return
     */
    List<Student> selectStudents(@Param("majorId") Integer majorId,@Param("grade") Integer grade);

    /**
     * 通过学号删除
     * @param stuNo 学号
     * @return
     */
    int deleteByStudentNo(String stuNo);

    /**
     * 根据学号更新学生
     * @param student 学生实体类
     * @return 返回更新的条数
     */
    int updateByStudentNo(Student student);

    /**
     * 通过学号获取学生
     * @param stuNo
     * @param majorId
     * @param grade
     * @return
     */
    Student selectByStudentNo(@Param("stuNo") String stuNo, @Param("majorId") Integer majorId, @Param("grade") Integer grade);

    /**
     * 通过学生名字获取学生
     * @param name
     * @param majorId
     * @param grade
     * @return
     */
    List<Student> selectByStudentName(@Param("name") String name,@Param("majorId") Integer majorId, @Param("grade") Integer grade);

    /**
     * 导入excel中数据
     * @param record
     * @return
     */
    int upload(StudentDTO record);


}