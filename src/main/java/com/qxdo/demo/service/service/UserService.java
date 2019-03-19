package com.qxdo.demo.service.service;

import com.qxdo.demo.entity.User;


import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    /**
     * 增加user
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 更新user信息
     * @param user
     * @return
     */

    boolean update(User user);



    /**
     * 按名称检索
     * @param username
     * @return
     */

    User selectbyusername(String username);

    /**
     * 多条件搜索，若某字段为null则不加此条件,operator1和operator2 可为or 或 and
     * @param username 用户名
     * @param operator1 or 或 and
     * @param sex 性别
     * @param operator2 or 或 and
     *                  from,to 均为日期，形如:2018-11-11-11:11:11 为 2018年11月11日11时11分11秒
     *                  从from 到 to时间段内
     * @param from 限定日期搜索
     * @param to
     * @return 查询到的用户列表
     */
    List<User> selectbymuticondication(String username, String operator1, Integer sex, String operator2, LocalDateTime from, LocalDateTime to);


    List<User> listAll();
}
