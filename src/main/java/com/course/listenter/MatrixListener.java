package com.course.listenter;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.course.dao.CourseMapper;
import com.course.dao.MajorCourseMapper;
import com.course.dao.MatrixMapper;
import com.course.form.MatrixAttachedFrom;
import com.course.model.Course;
import com.course.model.MajorCourse;
import com.course.model.Matrix;
import com.course.service.MajorCourseService;
import com.course.service.MatrixService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName MatrixListener
 * @Author: baobao
 * @Date: Created in 11:01 2020/11/28
 */
@NoArgsConstructor
public class MatrixListener extends AnalysisEventListener<Map<Integer, String>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 300;

    List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();

    private MajorCourseService majorCourseService;

    private MatrixAttachedFrom matrixAttachedFrom;

    public MatrixListener(MajorCourseService majorCourseService, MatrixAttachedFrom matrixAttachedFrom) {
        this.majorCourseService = majorCourseService;
        this.matrixAttachedFrom = matrixAttachedFrom;
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            majorCourseService.saveData(matrixAttachedFrom,list);
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        majorCourseService.saveData(matrixAttachedFrom,list);
        LOGGER.info("所有数据解析完成！");
    }


}

