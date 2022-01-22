package com.example.httpdemo.controller;

import com.example.httpdemo.bean.*;
import com.example.httpdemo.service.AddDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ServerController {
    @Autowired
    private AddDataService addDataService;

    /***
     *此处若用下面这种方法写，即直接输入HTML页面的名称来进入，会根据输入的HTML页面名称
     * 查找相应的HTML页面，比如http://localhost:8080/index，若此时输入http://localhost:8080/one.mp4
     * 请求相应视频，但是却会查找名称为one的页面，所以就会造成报错
     */
//    @RequestMapping("/{page}")
//    public String showPage(@PathVariable String page) {
//        return page;
//    }

    @RequestMapping("addData")
    public String addData() {
        return "addData.html";
    }

    @RequestMapping(value = "/insertDailyQuestions")
    public void insertDailyQuestions(Question question, HttpServletResponse response) {
        question.setAnswerType("1");
        switch (question.getType()) {
            case "0":
                question.setStart(String.valueOf(question.getTitle().indexOf("_")));
                break;
            default:
                question.setStart("0");
                break;
        }
        addDataService.insertQuestion(question);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addDailyQuestions.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertWeekQuestions")
    public void insertWeekQuestions(Question question, HttpServletResponse response) {
        question.setAnswerType("2");
        switch (question.getType()) {
            case "0":
                question.setStart(String.valueOf(question.getTitle().indexOf("_")));
                break;
            default:
                question.setStart("0");
                break;
        }
        addDataService.insertQuestion(question);
        if (addDataService.findWeekByWeek(question.getWeek()) == null) {
            addDataService.insertWeek(question.getWeek());
            List<String> phones = addDataService.findAllUserPhone();
            for (int i=0;i<phones.size();i++) {
                WeekList weekList = new WeekList();
                weekList.setWeek(question.getWeek());
                weekList.setUserId(phones.get(i));
                weekList.setIsAnswer("未答题");
                addDataService.insertWeekToUser(weekList);
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addWeekQuestions.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertSpecialQuestions")
    public void insertSpecialQuestions(Question question, HttpServletResponse response) {
        question.setAnswerType("3");
        switch (question.getType()) {
            case "0":
                question.setStart(String.valueOf(question.getTitle().indexOf("_")));
                break;
            default:
                question.setStart("0");
                break;
        }
        addDataService.insertQuestion(question);
        if (addDataService.findSpecialBySpecial(question.getSpecialTitle()) == null) {
            addDataService.insertSpecial(question.getSpecialTitle());
            List<String> phones = addDataService.findAllUserPhone();
            for (int i=0;i<phones.size();i++) {
                SpecialList specialList = new SpecialList();
                specialList.setSpecialTitle(question.getSpecialTitle());
                specialList.setIsAnswer("0");
                specialList.setIsOut("0");
                specialList.setUserId(phones.get(i));
                addDataService.insertSpecialToUser(specialList);
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addSpecialQuestions.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertChallengeQuestions")
    public void insertChallengeQuestions(Question question, HttpServletResponse response) {
        question.setAnswerType("4");
        question.setType("1");
        question.setStart("0");
        addDataService.insertQuestion(question);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addChallengeQuestions.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertArticle")
    public void insertArticle(Article article, HttpServletResponse response) {
        addDataService.insertArticle(article);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addArticle.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertVideo")
    public void insertVideo(VideoUri videoUri, HttpServletResponse response) {
        addDataService.insertVideo(videoUri);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功');window.location='addVideo.html';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


