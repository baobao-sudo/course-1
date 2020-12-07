package com.course.listenter;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.course.dao.StudentMapper;
import com.course.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 监听读取
 * @ClassName StudentListener
 * @Author: baobao
 * @Date: Created in 20:42 2020/10/23
 */
public class StudentListener extends AnalysisEventListener<StudentDTO> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentListener.class);

    private static final int BATCH_COUNT = 5;
    List<StudentDTO> list = new ArrayList<>();

    private StudentMapper studentMapper;


    public StudentListener(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public void invoke(StudentDTO data, AnalysisContext context) {

        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        Iterator<StudentDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            studentMapper.upload(iterator.next());
        }
        LOGGER.info("存储数据库成功！");
    }
}
