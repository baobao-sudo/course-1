package com.course.service.impl;

import com.course.dao.CourseMapper;
import com.course.dao.MajorCourseMapper;
import com.course.dao.MatrixMapper;
import com.course.dto.MajorCourseDTO;
import com.course.enums.ResultEnum;
import com.course.form.MatrixAttachedFrom;
import com.course.model.Course;
import com.course.model.MajorCourse;
import com.course.model.Matrix;
import com.course.model.User;
import com.course.service.MajorCourseService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName MajorCourseServiceImpl
 * @Author: baobao
 * @Date: Created in 21:48 2020/10/9
 */
@Service
@Slf4j
public class MajorCourseServiceImpl implements MajorCourseService {

    @Autowired
    private MajorCourseMapper majorCourseMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MatrixMapper matrixMapper;

    @Override
    public ResultVO findAllMajorCourse(Integer grade) {
        User user = userService.getCurrentUser();
        List<MajorCourseDTO> majorCourseDTOS = majorCourseMapper.selectMajorCourse(user.getMajorId(),grade);
        if(majorCourseDTOS == null){
            return ResultVOUtil.error(ResultEnum.NO_RESULTS_WERE_QUERIED);
        }
        return ResultVOUtil.success(majorCourseDTOS);
    }

    @Override
    public void saveData(MatrixAttachedFrom matrixAttachedFrom, List<Map<Integer, String>> list) {
        log.info("{}条数据，开始存储数据库！", list.size());
        Map<Integer,String> map = list.get(0);
        list.remove(0);
        int majorCourseId = 0;
        for(Map<Integer,String> courseMap:list){
            if(courseMap.get(5).equals("指标点权值和") || courseMap.get(5).equals("支撑课程门数")){
                continue;
            }
            String courseName = courseMap.get(3);
            //如果中间出错怎么办，事务是怎么搞
            if(courseMapper.selectByName(courseName) != null){
                Course course = courseMapper.selectByName(courseName);
                Integer typeId = Integer.valueOf(courseMap.get(0));
                MajorCourse majorCourse = new MajorCourse();
                majorCourse.setCourseId(course.getCourseId());
                majorCourse.setMajorId(matrixAttachedFrom.getMajorId());
                majorCourse.setGrade(matrixAttachedFrom.getGrade());
                majorCourse.setTypeId(typeId);
                majorCourseMapper.insert(majorCourse);
                majorCourseId = majorCourse.getMajorCourseId();
            }

            int count = Integer.parseInt(courseMap.get(5));

            courseMap.keySet().removeIf(key -> (key <= 5));

            for (Integer key : courseMap.keySet()) {
                if(courseMap.get(key) == null || courseMap.get(key).length() == 0 || Double.parseDouble(courseMap.get(key)) >= 1) {
                    continue;
                }
                double weight = Double.parseDouble(courseMap.get(key));
                String indexPoint = map.get(key);
                int firstRequirementNo = Integer.parseInt(indexPoint.substring(0,indexPoint.indexOf(".")));
                int secondRequirementNo = Integer.parseInt(indexPoint.substring(indexPoint.indexOf(".")+1));
                Matrix matrix = new Matrix();
                matrix.setMajorCourseId(majorCourseId);
                matrix.setCount(count);
                matrix.setFirstRequirementNo(firstRequirementNo);
                matrix.setSecondRequirementNo(secondRequirementNo);
                matrix.setWeight(weight);
                matrixMapper.insert(matrix);
            }
        }
        log.info("存储数据库成功！");
    }
}
