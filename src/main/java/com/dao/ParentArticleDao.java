package com.dao;

import com.pojo.ParentArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParentArticleDao extends BaseDataDao<ParentArticle> {
    ParentArticle selectById(Long id);

    int del(Long id);

    List<ParentArticle> searchParentArticle(@Param("keyword")String keyword);

    List<ParentArticle> myTeacher(@Param("classNum")Integer classNum);

    List<ParentArticle> myLeader(String unit);
}
