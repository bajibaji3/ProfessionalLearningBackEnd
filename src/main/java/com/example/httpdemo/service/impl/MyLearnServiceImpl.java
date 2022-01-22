package com.example.httpdemo.service.impl;

import com.example.httpdemo.bean.*;
import com.example.httpdemo.mapper.MyLearnMapper;
import com.example.httpdemo.service.MyLearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyLearnServiceImpl implements MyLearnService {
    @Autowired
    private MyLearnMapper myLearnMapper;

    @Override
    public List<SpecialList> findAllSpecialList(String userId) {
        return this.myLearnMapper.findAllSpecialList(userId);
    }

    @Override
    public List<SpecialTitleList> findAllSpecial() {
        return myLearnMapper.findAllSpecial();
    }

    @Override
    public void insertUserSpecial(SpecialList specialList) {
        myLearnMapper.insertUserSpecial(specialList);
    }

    @Override
    public List<WeekList> findAllWeekList(String userId) {
        return this.myLearnMapper.findAllWeekList(userId);
    }

    @Override
    public List<WeekTitle> findAllWeek() {
        return myLearnMapper.findAllWeek();
    }

    @Override
    public void insertUserWeek(WeekList weekList) {
        myLearnMapper.insertUserWeek(weekList);
    }

    @Override
    public void updateIsAnswerByWeek(WeekList weekList) {
        this.myLearnMapper.updateIsAnswerByWeek(weekList);
    }

    @Override
    public List<Question> findAllChallengeQuestion() {
        return myLearnMapper.findAllChallengeQuestion();
    }

    @Override
    public List<Question> findAllWeekQuestion() {
        return myLearnMapper.findAllWeekQuestion();
    }

    @Override
    public List<Question> findAllDailyQuestion() {
        return myLearnMapper.findAllDailyQuestion();
    }

    @Override
    public List<Question> findAllSpecialQuestion() {
        return myLearnMapper.findAllSpecialQuestion();
    }

    @Override
    public void insertHighScore(Challenge challenge) {
        this.myLearnMapper.insertHighScore(challenge);
    }

    @Override
    public void updateHighScore(Challenge challenge) {
        this.myLearnMapper.updateHighScore(challenge);
    }

    @Override
    public String findHighScore(String userId) {
        return myLearnMapper.findHighScore(userId);
    }

    @Override
    public String findIsAnswerByWeek(WeekList weekList) {
        return myLearnMapper.findIsAnswerByWeek(weekList);
    }


    @Override
    public void updateUserAnswer(UserAnswer userAnswer) {
        myLearnMapper.updateUserAnswer(userAnswer);
    }

    @Override
    public void updateUserAnswer5(UserAnswer userAnswer) {
        myLearnMapper.updateUserAnswer5(userAnswer);
    }

    @Override
    public UserAnswer findUserAnswer5(UserAnswer userAnswer) {
        return myLearnMapper.findUserAnswer5(userAnswer);
    }

    @Override
    public UserAnswer findUserAnswer(UserAnswer userAnswer) {
        return myLearnMapper.findUserAnswer(userAnswer);
    }

    @Override
    public void insertUserAnswer(UserAnswer userAnswer) {
        myLearnMapper.insertUserAnswer(userAnswer);
    }

    @Override
    public void insertUserAnswer5(UserAnswer userAnswer) {
        myLearnMapper.insertUserAnswer5(userAnswer);
    }

    @Override
    public void updateSpecialIsAnswer(SpecialList specialList) {
        myLearnMapper.updateSpecialIsAnswer(specialList);
    }

    @Override
    public void updateSpecialIsOut(SpecialList specialList) {
        myLearnMapper.updateSpecialIsOut(specialList);
    }

    @Override
    public EverydayPerformance findEverydayScore(EverydayPerformance everydayPerformance) {
        return myLearnMapper.findEverydayScore(everydayPerformance);
    }

    @Override
    public void insertDailyScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.insertDailyScore(everydayPerformance);
    }

    @Override
    public void updateDailyScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.updateDailyScore(everydayPerformance);
    }

    @Override
    public void updatePerformanceInDaily(Performance performance) {
        myLearnMapper.updatePerformanceInDaily(performance);
    }

    @Override
    public void updateAnswerNum(Performance performance) {
        myLearnMapper.updateAnswerNum(performance);
    }

    @Override
    public void insertWeekScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.insertWeekScore(everydayPerformance);
    }

    @Override
    public void updateWeekScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.updateWeekScore(everydayPerformance);
    }

    @Override
    public String findIsAnswerBySpecial(SpecialList specialList) {
        return myLearnMapper.findIsAnswerBySpecial(specialList);
    }

    @Override
    public void insertSpecialScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.insertSpecialScore(everydayPerformance);
    }

    @Override
    public void updateSpecialScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.updateSpecialScore(everydayPerformance);
    }

    @Override
    public void insertChallengeScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.insertChallengeScore(everydayPerformance);
    }

    @Override
    public void updateChallengeScore(EverydayPerformance everydayPerformance) {
        myLearnMapper.updateChallengeScore(everydayPerformance);
    }

    @Override
    public Performance findPerformance(String userId) {
        return myLearnMapper.findPerformance(userId);
    }

    @Override
    public List<Performance> findAllPerformance() {
        return myLearnMapper.findAllPerformance();
    }

    @Override
    public void insertPerformance(Performance performance) {
        myLearnMapper.insertPerformance(performance);
    }

    @Override
    public User findUser(String phone) {
        return myLearnMapper.findUser(phone);
    }

    @Override
    public void insertUser(User user) {
        myLearnMapper.insertUser(user);
    }

    @Override
    public List<Article> findArticle() {
        return myLearnMapper.findArticle();
    }

    @Override
    public Comment findCommentToArticle(int id) {
        return myLearnMapper.findCommentToArticle(id);
    }

    @Override
    public List<Integer> findCommentIdByArticle(CommentDepend commentDepend) {
        return myLearnMapper.findCommentIdByArticle(commentDepend);
    }

    @Override
    public Integer addCommentToArticle(Comment comment) {
        myLearnMapper.addCommentToArticle(comment);
        return comment.getId();
    }

    @Override
    public void insertCommentDep(CommentDepend commentDepend) {
        myLearnMapper.insertCommentDep(commentDepend);
    }

    @Override
    public UserArticle findUserArticle(UserArticle userArticle) {
        return myLearnMapper.findUserArticle(userArticle);
    }

    @Override
    public void deleteUserArticle(UserArticle userArticle) {
        myLearnMapper.deleteUserArticle(userArticle);
    }

    @Override
    public void insertUserArticle(UserArticle userArticle) {
        myLearnMapper.insertUserArticle(userArticle);
    }

    @Override
    public List<UserArticle> findUserCollect(String userId) {
        return myLearnMapper.findUserCollect(userId);
    }

    @Override
    public void deleteUserCollect(int id) {
        myLearnMapper.deleteUserCollect(id);
    }

    @Override
    public List<VideoUri> findVideo() {
        return myLearnMapper.findVideo();
    }

    @Override
    public Article findArticleById(int id) {
        return myLearnMapper.findArticleById(id);
    }

    @Override
    public VideoUri findVideoById(int id) {
        return myLearnMapper.findVideoById(id);
    }

    @Override
    public void updateUserName(User user) {
        myLearnMapper.updateUserName(user);
    }

    @Override
    public void updateUserPhone(UserPhone userPhone) {
        myLearnMapper.updateUserPhone(userPhone);
    }

    @Override
    public void updateUserPas(User user) {
        myLearnMapper.updateUserPas(user);
    }

}
