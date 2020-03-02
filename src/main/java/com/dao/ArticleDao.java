package com.dao;

import com.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArticleDao extends BaseDataDao<Article> {
    Article selectById(Long id);

    int del(Article param);

    List<Article> selectByParentId(@Param("id") Integer id);

    List<Article> searchArticle(@Param("keyword") String keyword);

    Article findByLoginNameAndPassword(@Param("loginName") String loginName,@Param("password") String password);
}
