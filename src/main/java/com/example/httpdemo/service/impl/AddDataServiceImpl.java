package com.example.httpdemo.service.impl;

import com.example.httpdemo.bean.*;
import com.example.httpdemo.mapper.MyLearnMapper;
import com.example.httpdemo.service.AddDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddDataServiceImpl implements AddDataService {
    @Autowired
    private MyLearnMapper myLearnMapper;

    @Override
    public void insertQuestion(Question question) {
        myLearnMapper.insertQuestion(question);
    }

    @Override
    public String findWeekByWeek(String week) {
        return myLearnMapper.findWeekByWeek(week);
    }

    @Override
    public void insertWeek(String week) {
        myLearnMapper.insertWeek(week);
    }

    @Override
    public List<String> findAllUserPhone() {
        return myLearnMapper.findAllUserPhone();
    }

    @Override
    public void insertWeekToUser(WeekList weekList) {
        myLearnMapper.insertWeekToUser(weekList);
    }

    @Override
    public String findSpecialBySpecial(String specialTitle) {
        return myLearnMapper.findSpecialBySpecial(specialTitle);
    }

    @Override
    public void insertSpecial(String specialTitle) {
        myLearnMapper.insertSpecial(specialTitle);
    }

    @Override
    public void insertSpecialToUser(SpecialList specialList) {
        myLearnMapper.insertSpecialToUser(specialList);
    }

    @Override
    public void insertArticle(Article article) {
        myLearnMapper.insertArticle(article);
    }

    @Override
    public void insertVideo(VideoUri videoUri) {
        myLearnMapper.insertVideo(videoUri);
    }
}
