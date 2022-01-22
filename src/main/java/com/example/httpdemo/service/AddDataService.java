package com.example.httpdemo.service;

import com.example.httpdemo.bean.*;

import java.util.List;

public interface AddDataService {
    //用于服务端数据操作
    void insertQuestion(Question question);
    String findWeekByWeek(String week);
    void insertWeek(String week);
    List<String> findAllUserPhone();
    void insertWeekToUser(WeekList weekList);
    String findSpecialBySpecial(String specialTitle);
    void insertSpecial(String specialTitle);
    void insertSpecialToUser(SpecialList specialList);
    void insertArticle(Article article);
    void insertVideo(VideoUri videoUri);
}
