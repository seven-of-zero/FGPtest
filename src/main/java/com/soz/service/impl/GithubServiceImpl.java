package com.soz.service.impl;

import com.soz.dao.GithubDao;
import com.soz.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubServiceImpl implements GithubService {

    @Autowired
    GithubDao githubDao;

    @Override
    public void add(String name,String picture) {
        githubDao.add(name,picture);
    }

    @Override
    public int chechExsist(String name) {
        int exsist = githubDao.checkExsist(name);
        return exsist;
    }
}
