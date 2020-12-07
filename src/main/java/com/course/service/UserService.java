package com.course.service;

import com.course.form.LoginForm;
import com.course.form.UserRegisterForm;
import com.course.form.UserUpdatePwForm;
import com.course.model.User;
import com.course.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zty200329
 * @date 2020/7/15 10:51
 */
@Service
public interface UserService {

    /**
     * 通过账号获取用户
     *
     * @param cardId
     * @return
     */
    User getUserByUsername(String cardId);

    /**
     * 获取当前用户
     *
     * @return
     */
    User getCurrentUser();

    /**
     * 用户注册
     * @param userRegisterForm
     * @return
     */
    ResultVO userRegister(UserRegisterForm userRegisterForm);

    /**
     * 登录
     * @param loginForm
     * @param response
     * @return
     */
    ResultVO login(LoginForm loginForm, HttpServletResponse response);

    /**
     * 生成验证码图片
     * @param request
     * @param response
     * @return
     */
    ResultVO captcha(HttpServletRequest request,HttpServletResponse response);

    /**
     * 修改密码
     * @param userUpdatePwForm 更新表单
     * @return 无返回值
     */
    ResultVO updateUserPw(UserUpdatePwForm userUpdatePwForm);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 上传头像
     * @param file
     * @return
     */
     ResultVO uploadPhoto(MultipartFile file);

    /**
     * 返回所有教师
     * @return
     */
    ResultVO allTeacher();



}
