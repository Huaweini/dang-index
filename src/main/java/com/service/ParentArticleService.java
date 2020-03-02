package com.service;


import com.pojo.ParentArticle;

import java.util.List;

public interface ParentArticleService {
    List<ParentArticle> selectList();

    int insert(ParentArticle param);

    ParentArticle selectById(Long id);

    int del(Long id);

    int update(ParentArticle teacher);

    List<ParentArticle> searchParentArticle(String keyword);

    List<ParentArticle> myTeacher(Integer classNum);

    List<ParentArticle> myLeader(String unit);

}
