package com.soz.service.impl;

import com.soz.dao.ActivityDao;
import com.soz.pojo.ActPojo;
import com.soz.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public void add(String title, String content, String publisher) {
        activityDao.add(title,content,publisher);
    }

    @Override
    public void delete(Integer id) {
        activityDao.delete(id);
    }

    @Override
    public List<ActPojo> show(Integer id) {
        List<ActPojo> show = activityDao.show(id);
        return show;
    }

    @Override
    public List<String> showTitle() {
        List<String> title = activityDao.showTitle();
        return title;
    }
}
