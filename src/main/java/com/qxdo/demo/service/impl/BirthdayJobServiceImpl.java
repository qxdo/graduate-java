package com.qxdo.demo.service.impl;
import com.qxdo.demo.dao.MessageDao;
import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.Message;
import com.qxdo.demo.entity.User;
import com.qxdo.demo.service.service.BirthdayJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BirthdayJobServiceImpl implements BirthdayJobService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MessageDao messageDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //0 5 0 ? * * 每天凌晨0:5分触发
    @Scheduled(cron ="0 5 0 ? * *")
    public void cronBirthdayMessage(){
        logger.debug("cronBirthday is starting...");


        List<User> users =  userDao.listAll();
        for(User user: users){
            LocalDate now = LocalDate.now();
            LocalDate date = user.getBirthday();
            if((date.getMonth().getValue() - now.getMonth().getValue() == 0) && (date.getDayOfMonth() - now.getDayOfMonth() == 0) ){

                logger.debug("the user named :"+user.getUsername() +" birthday...");
                Message message = new Message();

                message.setMessage("你好 " +  user.getUsername() +"，生日快乐");
                message.setUser(user);
                message.setModifiedtime(LocalDateTime.now());
                if(messageDao.save(message) == 1 ){
                    logger.debug("cron run ok...."+user.getUsername());

                }
            }
        }


    }
}
