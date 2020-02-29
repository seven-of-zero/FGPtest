package com.soz.service.impl;

import com.soz.dao.ActivityDao;
import com.soz.pojo.ActPojo;
import com.soz.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public void add(String title, String content, Date date,String publisher) {
        activityDao.add(title,content,date,publisher);
    }

    @Override
    public void delete(Integer id) {
        activityDao.delete(id);
    }

    @Override
    public ActPojo show(Integer id) {
        ActPojo show = activityDao.show(id);
        return show;
    }

    @Override
    public List<ActPojo> showTitle() {
        List<ActPojo> actPojos = activityDao.showTitle();
        return actPojos;
    }
}
