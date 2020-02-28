package com.soz.service;

import com.soz.pojo.ActPojo;

import java.util.List;

public interface ActivityService {

    void add(String title,String content,String publisher);

    void delete(Integer id);

    List<ActPojo> show(Integer id);

    List<String> showTitle();

}
