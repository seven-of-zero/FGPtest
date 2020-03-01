package com.soz.service;

import com.soz.pojo.ActPojo;

import java.util.Date;
import java.util.List;

public interface ActivityService {

    void add(String title, String content, Date date,String publisher);

    void delete(Integer id);

    ActPojo show(Integer id);

    List<ActPojo> showTitle();

    List<ActPojo> showDelete(String name);

}
