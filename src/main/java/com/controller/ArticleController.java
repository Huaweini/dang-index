package com.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pojo.Article;
import com.pojo.ParentArticle;
import com.service.ParentArticleService;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ParentArticleService parentArticleService;


    @RequestMapping("/page")
    public String list(Model model, Page<Article> page, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String keyword) {
        //在查询之前需要调用，传入页码，以及每页的大小
        PageHelper.startPage(page.getPageNum(), pageSize);
        List<Article> list = articleService.searchArticle(keyword);
        //查询出来的数据，和连续显示的页数
        PageInfo res = new PageInfo(list, 5);
        model.addAttribute("page",res);
        model.addAttribute("keyword",keyword);
        return "user_list";
    }

    @RequestMapping("/index")
    public String index(Model model, String keyword) {
        //在查询之前需要调用，传入页码，以及每页的大小
        List<ParentArticle> list = parentArticleService.searchParentArticle(keyword);
        model.addAttribute("list",list);
        model.addAttribute("keyword",keyword);
        return "index";
    }

    @RequestMapping("/dangDaiHuiYiXinXi")
    public String dangDaiHuiYiXinXi(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "dangDaiHuiYiXinXi";
    }

    @RequestMapping("/dangJianLeiBie")
    public String dangJianLeiBie(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "dangJianLeiBie";
    }


    @RequestMapping("/dangJianYaoWen")
    public String dangJianYaoWen(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "dangJianYaoWen";
    }


    @RequestMapping("/dangShiRenWu")
    public String dangShiRenWu(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "dangShiRenWu";
    }


    @RequestMapping("/dangShiRiJi")
    public String dangShiRiJi(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);return "dangShiRiJi";
    }


    @RequestMapping("/fanFuShiJian")
    public String fanFuShiJian(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "fanFuShiJian";
    }


    @RequestMapping("/liLunJieDu")
    public String liLunJieDu(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "liLunJieDu";
    }


    @RequestMapping("/qinYuanHuoDongXinXi")
    public String qinYuanHuoDongXinXi(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "qinYuanHuoDongXinXi";
    }


    @RequestMapping("/qinYuanZuZhiXinXi")
    public String qinYuanZuZhiXinXi(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "qinYuanZuZhiXinXi";
    }


    @RequestMapping("/xueXiWenXuan")
    public String xueXiWenXuan(Model model,Integer id){
        List<ParentArticle> list = parentArticleService.searchParentArticle(null);
        List<Article> article = articleService.selectByParentId(id);
        model.addAttribute("article", article);
        model.addAttribute("list",list);
        return "xueXiWenXuan";
    }


}
