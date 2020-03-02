package com.service;

import com.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {

    int insert(Article param);


    int update(Article param);

    Article selectById(Long id);

    int del (Article param);

    List<Article> selectByParentId(@Param("id") Integer id);


    List<Article>  searchArticle(String keyword);

    Article checkLogin(String loginName,String password);
}
