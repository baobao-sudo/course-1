package com.course.dto;

import lombok.Data;

/**
 *@ClassName PhotoUploadDTO
 *@Description TODO
 *@Author Lenovo
 *@Date 2020/6/11
 *@Version 1.0
**/

@Data
public class PhotoUploadDTO {
    /**
     * 文件原始名
     */
    private String fileName;
    /**
     * 后缀 类似.ppt
     */
    private String suffix;
    /**
     * 新名称 以19700101开始的毫秒
     */
    private String newFileName;

    private String photoUrl;
}
