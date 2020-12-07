package com.course.service;

import com.alibaba.excel.EasyExcel;
import com.course.listenter.MatrixListener;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * @Description 测试是怎么读取的
 * @ClassName MatrixServiceTest
 * @Author: baobao
 * @Date: Created in 11:11 2020/11/28
 */
@SpringBootTest
class MatrixServiceTest {

    /**
     * 不创建对象的读
     */
    @Test
    public void noModelRead() {
        String fileName = "D:\\文档\\课程设计\\01专业毕业要求支撑矩阵.xls";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new MatrixListener()).sheet().doRead();
    }

}