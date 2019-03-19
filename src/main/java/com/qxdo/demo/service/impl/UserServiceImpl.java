package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.User;
import com.qxdo.demo.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增user
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        return userDao.save(user) == 1;
    }

    /**
     * 更新user
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        return userDao.update(user) ==1;
    }




    /**
     * 使用username查询user
     * @param username
     * @return
     */
    @Override
    public User selectbyusername(String username) {
        return userDao.selectbyusername(username);
    }


    /**
     * 多条件查询
     * @param username 用户名
     * @param operator1 or 或 and
     * @param sex 性别
     * @param operator2 or 或 and
     *                  from,to 均为日期，形如:2018-11-11-11:11:11 为 2018年11月11日11时11分11秒
     *                  从from 到 to时间段内
     * @param from 限定日期搜索
     * @param to
     * @return
     */

    @Override
    public List<User> selectbymuticondication(String username, String operator1, Integer sex, String operator2, LocalDateTime from, LocalDateTime to) {
        logger.info("in service....");
        return userDao.selectbymuticondication(username,operator1,sex,operator2,from,to);

    }

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }
}
