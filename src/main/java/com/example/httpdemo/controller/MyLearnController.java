package com.example.httpdemo.controller;

import com.example.httpdemo.bean.*;
import com.example.httpdemo.service.MyLearnService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/learn")
public class MyLearnController {
    @Autowired
    private MyLearnService myLearnService;

    @GetMapping("/getSpecialList")
    public String getSpecialList(String userId) {
        List<SpecialList> list = this.myLearnService.findAllSpecialList(userId);
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("/initUserSpecial")
    public void initUserSpecial(String userId) {
        List<SpecialTitleList> list = myLearnService.findAllSpecial();
        for (int i = 0;i < list.size();i++) {
            SpecialList specialList = new SpecialList();
            specialList.setIsAnswer("0");
            specialList.setSpecialTitle(list.get(i).getSpecialTitle());
            specialList.setUserId(userId);
            specialList.setIsOut("0");
            myLearnService.insertUserSpecial(specialList);
        }
    }

    @GetMapping("/getWeekList")
    public String getWeekList(String userId) {
        List<WeekList> list = this.myLearnService.findAllWeekList(userId);
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("/initUserWeek")
    public void initUserWeek(String userId) {
        List<WeekTitle> list = myLearnService.findAllWeek();
        for (int i = 0;i < list.size();i++) {
            WeekList weekList = new WeekList();
            weekList.setIsAnswer("未答题");
            weekList.setWeek(list.get(i).getWeek());
            weekList.setUserId(userId);
            myLearnService.insertUserWeek(weekList);
        }
    }

    @GetMapping("/findIsAnswerByWeek")
    public String findIsAnswerByWeek(String week,String userId) {
        WeekList weekList = new WeekList();
        weekList.setUserId(userId);
        weekList.setWeek(week);
        return myLearnService.findIsAnswerByWeek(weekList);
    }

    @PostMapping("/updateIsAnswerByWeek")
    public void updateIsAnswerByWeek(String week,String userId) {
        WeekList weekList = new WeekList();
        weekList.setUserId(userId);
        weekList.setWeek(week);
        myLearnService.updateIsAnswerByWeek(weekList);
    }

    @GetMapping("/findAllChallengeQuestion")
    public String findAllChallengeQuestion() {
        List<Question> list = this.myLearnService.findAllChallengeQuestion();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @GetMapping("/findAllWeekQuestion")
    public String findAllWeekQuestion() {
        List<Question> list = this.myLearnService.findAllWeekQuestion();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("/insertHighScore")
    public void insertHighScore(String highScore,String userId) {
        Challenge challenge = new Challenge();
        challenge.setHighScore(highScore);
        challenge.setUserId(userId);
        myLearnService.insertHighScore(challenge);
    }

    @PostMapping("/updateHighScore")
    public void updateHighScore(String highScore,String userId) {
        Challenge challenge = new Challenge();
        challenge.setHighScore(highScore);
        challenge.setUserId(userId);
        myLearnService.updateHighScore(challenge);
    }

    @GetMapping("/findHighScore")
    public String findHighScore(String userId) {
        return myLearnService.findHighScore(userId);
    }

    @GetMapping("/findAllDailyQuestion")
    public String findAllDailyQuestion() {
        List<Question> list = this.myLearnService.findAllDailyQuestion();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("/updateUserAnswer")
    public void updateUserAnswer(String userAnswer1,String userAnswer2,String userAnswer3,String userAnswer4,String userAnswer5,String pageNum,String specialTitle,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserAnswer1(userAnswer1);
        userAnswer.setUserAnswer2(userAnswer2);
        userAnswer.setUserAnswer3(userAnswer3);
        userAnswer.setUserAnswer4(userAnswer4);
        userAnswer.setUserAnswer5(userAnswer5);
        userAnswer.setPageNum(pageNum);
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setUserId(userId);
        myLearnService.updateUserAnswer(userAnswer);
    }

    @PostMapping("/updateSpecialIsOut")
    public void updateSpecialIsOut(String isOut,String specialTitle,String userId) {
        SpecialList specialList = new SpecialList();
        specialList.setIsOut(isOut);
        specialList.setSpecialTitle(specialTitle);
        specialList.setUserId(userId);
        myLearnService.updateSpecialIsOut(specialList);
    }

    @PostMapping("/updateUserAnswer5")
    public void updateUserAnswer5(String userAnswer1,String userAnswer2,String userAnswer3,String userAnswer4,String userAnswer5,String specialTitle,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserAnswer1(userAnswer1);
        userAnswer.setUserAnswer2(userAnswer2);
        userAnswer.setUserAnswer3(userAnswer3);
        userAnswer.setUserAnswer4(userAnswer4);
        userAnswer.setUserAnswer5(userAnswer5);
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setUserId(userId);
        myLearnService.updateUserAnswer5(userAnswer);
    }

    @GetMapping("/findAllSpecialQuestion")
    public String findAllSpecialQuestion() {
        List<Question> list = this.myLearnService.findAllSpecialQuestion();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @GetMapping("/findUserAnswer")
    public UserAnswer findUserAnswer(String specialTitle,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setUserId(userId);
        return this.myLearnService.findUserAnswer(userAnswer);
    }

    @PostMapping("/insertUserAnswer")
    public void insertUserAnswer(String userAnswer1,String userAnswer2,String userAnswer3,String userAnswer4,String userAnswer5,String specialTitle,String pageNum,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserAnswer1(userAnswer1);
        userAnswer.setUserAnswer2(userAnswer2);
        userAnswer.setUserAnswer3(userAnswer3);
        userAnswer.setUserAnswer4(userAnswer4);
        userAnswer.setUserAnswer5(userAnswer5);
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setPageNum(pageNum);
        userAnswer.setUserId(userId);
        myLearnService.insertUserAnswer(userAnswer);
    }

    @PostMapping("/insertUserAnswer5")
    public void insertUserAnswer5(String question1,String question2,String question3,String question4,String question5,String userAnswer1,String userAnswer2,String userAnswer3,String userAnswer4,String userAnswer5,String specialTitle,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setQuestion1(question1);
        userAnswer.setQuestion2(question2);
        userAnswer.setQuestion3(question3);
        userAnswer.setQuestion4(question4);
        userAnswer.setQuestion5(question5);
        userAnswer.setUserAnswer1(userAnswer1);
        userAnswer.setUserAnswer2(userAnswer2);
        userAnswer.setUserAnswer3(userAnswer3);
        userAnswer.setUserAnswer4(userAnswer4);
        userAnswer.setUserAnswer5(userAnswer5);
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setUserId(userId);
        myLearnService.insertUserAnswer5(userAnswer);
    }

    @GetMapping("/findUserAnswer5")
    public UserAnswer findUserAnswer5(String specialTitle,String userId) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setSpecialTitle(specialTitle);
        userAnswer.setUserId(userId);
        return this.myLearnService.findUserAnswer5(userAnswer);
    }

    @PostMapping("/updateSpecialIsAnswer")
    public void updateSpecialIsAnswer(String isAnswer,String isOut,String specialTitle,String userId) {
        SpecialList specialList = new SpecialList();
        specialList.setSpecialTitle(specialTitle);
        specialList.setIsAnswer(isAnswer);
        specialList.setIsOut(isOut);
        specialList.setUserId(userId);
        myLearnService.updateSpecialIsAnswer(specialList);
    }

    @GetMapping("/findEverydayScore")
    public EverydayPerformance findEverydayScore(String date,String userId) {
        //改动了！！！！！
        EverydayPerformance performance = new EverydayPerformance();
        performance.setUserId(userId);
        performance.setDate(date);
        return myLearnService.findEverydayScore(performance);
    }

    @PostMapping("/insertDailyScore")
    public void insertDailyScore(String date,String userId,String dailyScore) {
        EverydayPerformance performance = new EverydayPerformance();
        performance.setDailyScore(dailyScore);
        performance.setDate(date);
        performance.setUserId(userId);
        myLearnService.insertDailyScore(performance);
    }

    @PostMapping("/updateDailyScore")
    public void updateDailyScore(String date,String userId,String dailyScore) {
        //改动了！！！！！！
        EverydayPerformance performance = new EverydayPerformance();
        performance.setUserId(userId);
        performance.setDate(date);
        int oldScore;
        if (myLearnService.findEverydayScore(performance).getDailyScore() == null) {
            oldScore = 0;
        } else {
            oldScore = Integer.valueOf(myLearnService.findEverydayScore(performance).getDailyScore());
        }
        int score = oldScore + Integer.valueOf(dailyScore);
        performance.setDailyScore(String.valueOf(score));
        myLearnService.updateDailyScore(performance);
    }

    @PostMapping("/updatePerformanceInDaily")
    public void updatePerformanceInDaily(String score,String userId) {
        //改动了！！！！
        Performance performance1 = myLearnService.findPerformance(userId);
        int total,answer,num;
        if (performance1 == null) {
            total = 0;
            answer = 0;
            num = 0;
        } else {
            total = Integer.valueOf(score) + Integer.valueOf(performance1.getTotalScore());
            answer = Integer.valueOf(score) + Integer.valueOf(performance1.getAnswerScore());
            num = Integer.valueOf(performance1.getAnswerNum()) + 1;
        }
        Performance performance = new Performance();
        performance.setAnswerScore(String.valueOf(answer));
        performance.setTotalScore(String.valueOf(total));
        performance.setAnswerNum(String.valueOf(num));
        performance.setUserId(userId);
        myLearnService.updatePerformanceInDaily(performance);
    }

    @PostMapping("/updateAnswerNum")
    public void updateAnswerNum(String userId) {
        //改动了！！！！
        Performance performance1 = myLearnService.findPerformance(userId);
        int num;
        if (performance1 == null) {
            num = 0;
        } else {
            num = Integer.valueOf(performance1.getAnswerNum()) + 1;
        }
        Performance performance = new Performance();
        performance.setAnswerNum(String.valueOf(num));
        performance.setUserId(userId);
        myLearnService.updateAnswerNum(performance);
    }

    @PostMapping("/insertWeekScore")
    public void insertWeekScore(String date,String userId,String weekScore) {
        EverydayPerformance performance = new EverydayPerformance();
        performance.setWeekScore(weekScore);
        performance.setDate(date);
        performance.setUserId(userId);
        myLearnService.insertWeekScore(performance);
    }

    @PostMapping("/updateWeekScore")
    public void updateWeekScore(String date,String userId,String weekScore) {
        //改动了！！！！！
        EverydayPerformance performance = new EverydayPerformance();
        performance.setUserId(userId);
        performance.setDate(date);
        int oldScore;
        if (myLearnService.findEverydayScore(performance).getWeekScore() == null) {
            oldScore = 0;
        } else {
            oldScore = Integer.valueOf(myLearnService.findEverydayScore(performance).getWeekScore());
        }
        int score = oldScore + Integer.valueOf(weekScore);
        performance.setWeekScore(String.valueOf(score));
        myLearnService.updateWeekScore(performance);
    }

    @GetMapping("/findIsAnswerBySpecial")
    public String findIsAnswerBySpecial(String specialTitle,String userId) {
        SpecialList specialList = new SpecialList();
        specialList.setUserId(userId);
        specialList.setSpecialTitle(specialTitle);
        return myLearnService.findIsAnswerBySpecial(specialList);
    }

    @PostMapping("/insertSpecialScore")
    public void insertSpecialScore(String date,String userId,String specialScore) {
        EverydayPerformance performance = new EverydayPerformance();
        performance.setSpecialScore(specialScore);
        performance.setDate(date);
        performance.setUserId(userId);
        myLearnService.insertSpecialScore(performance);
    }

    @PostMapping("/updateSpecialScore")
    public void updateSpecialScore(String date,String userId,String specialScore) {
        //改动了！！！！！
        EverydayPerformance performance = new EverydayPerformance();
        performance.setUserId(userId);
        performance.setDate(date);
        int oldScore;
        if (myLearnService.findEverydayScore(performance).getSpecialScore() == null) {
            oldScore = 0;
        } else {
            oldScore = Integer.valueOf(myLearnService.findEverydayScore(performance).getSpecialScore());
        }
        int score = oldScore + Integer.valueOf(specialScore);
        performance.setSpecialScore(String.valueOf(score));
        myLearnService.updateSpecialScore(performance);
    }

    @PostMapping("/insertChallengeScore")
    public void insertChallengeScore(String date,String userId,String challengeScore) {
        EverydayPerformance performance = new EverydayPerformance();
        performance.setChallengeScore(challengeScore);
        performance.setDate(date);
        performance.setUserId(userId);
        myLearnService.insertChallengeScore(performance);
    }

    @PostMapping("/updateChallengeScore")
    public void updateChallengeScore(String date,String userId,String challengeScore) {
        //改动了！！！！！！
        EverydayPerformance performance = new EverydayPerformance();
        performance.setUserId(userId);
        performance.setDate(date);
        int oldScore;
        if (myLearnService.findEverydayScore(performance).getChallengeScore() == null) {
            oldScore = 0;
        } else {
            oldScore = Integer.valueOf(myLearnService.findEverydayScore(performance).getChallengeScore());
        }
        int score = oldScore + Integer.valueOf(challengeScore);
        performance.setChallengeScore(String.valueOf(score));
        myLearnService.updateChallengeScore(performance);
    }

    @GetMapping("/findPerformance")
    public Performance getPerformance(String userId) {
        return myLearnService.findPerformance(userId);
    }

    @PostMapping("/insertPerformance")
    public void insertPerformance(String totalScore,String answerNum,String answerScore,String userId) {
        Performance performance = new Performance();
        performance.setUserId(userId);
        performance.setAnswerNum(answerNum);
        performance.setAnswerScore(answerScore);
        performance.setTotalScore(totalScore);
        myLearnService.insertPerformance(performance);
    }

    @GetMapping("/findAllPerformance")
    public List<Performance> getAllPerformance() {
        return myLearnService.findAllPerformance();
    }

    @GetMapping("/findUser")
    public User findUser(String phone) {
        return myLearnService.findUser(phone);
    }

    @PostMapping("/insertUser")
    public void insertUser(String phone,String name,String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        myLearnService.insertUser(user);
    }

    @GetMapping("/findArticle")
    public String findArticle() {
        List<Article> list = myLearnService.findArticle();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @GetMapping("/findCommentToArticle")
    public String findCommentToArticle(int owner,int type) {
        CommentDepend commentDepend = new CommentDepend();
        commentDepend.setOwner(owner);
        commentDepend.setType(type);
        List<Integer> owners  = myLearnService.findCommentIdByArticle(commentDepend);
        List<Comment> comments = new ArrayList<>();
        for (int i=0;i<owners.size();i++) {
            comments.add(myLearnService.findCommentToArticle(owners.get(i)));
        }
        Gson gson = new Gson();
        return gson.toJson(comments);
    }

    @PostMapping("/addCommentToArticle")
    public void addCommentToArticle(String reviewer,String review,String date,int articleId,int type) {
        Comment comment = new Comment();
        comment.setReviewer(reviewer);
        comment.setComment(review);
        comment.setDate(date);
        int commentId = myLearnService.addCommentToArticle(comment);
        CommentDepend commentDepend = new CommentDepend();
        commentDepend.setOwner(articleId);
        commentDepend.setSub(commentId);
        commentDepend.setType(type);
        myLearnService.insertCommentDep(commentDepend);
    }

    @GetMapping("/findUserArticle")
    public UserArticle findUserArticle(int articleId,String userId,int articleType) {
        UserArticle userArticle = new UserArticle();
        userArticle.setArticleId(articleId);
        userArticle.setUserId(userId);
        userArticle.setArticleType(articleType);
        return myLearnService.findUserArticle(userArticle);
    }

    @PostMapping("/deleteUserArticle")
    public void deleteUserArticle(int articleId,String userId,int articleType) {
        UserArticle userArticle = new UserArticle();
        userArticle.setUserId(userId);
        userArticle.setArticleId(articleId);
        userArticle.setArticleType(articleType);
        myLearnService.deleteUserArticle(userArticle);
    }

    @PostMapping("/insertUserArticle")
    public void insertUserArticle(int articleId,String userId,int articleType,String articleTitle,String date) {
        UserArticle userArticle = new UserArticle();
        userArticle.setUserId(userId);
        userArticle.setArticleId(articleId);
        userArticle.setArticleType(articleType);
        userArticle.setArticleTitle(articleTitle);
        userArticle.setDate(date);
        myLearnService.insertUserArticle(userArticle);
    }

    @GetMapping("/findUserCollect")
    public String findUserCollect(String userId) {
        Gson gson = new Gson();
        return gson.toJson(myLearnService.findUserCollect(userId));
    }

    @PostMapping("/deleteUserCollect")
    public void deleteUserCollect(int id) {
        myLearnService.deleteUserCollect(id);
    }

    @GetMapping("/getVideoUri")
    public String getVideoUri() {
        Gson gson = new Gson();
        return gson.toJson(myLearnService.findVideo());
    }

    @GetMapping("/findArticleById")
    public Article findArticleById(int id) {
        return myLearnService.findArticleById(id);
    }

    @GetMapping("/findVideoById")
    public VideoUri findVideoById(int id) {
        return myLearnService.findVideoById(id);
    }

    @PostMapping("/updateUserName")
    public void updateUserName(String phone,String name) {
        User user = new User();
        user.setPhone(phone);
        user.setName(name);
        myLearnService.updateUserName(user);
    }

    @PostMapping("/updateUserPhone")
    public void updateUserPhone(String newPhone,String oldPhone) {
        UserPhone userPhone = new UserPhone();
        userPhone.setNewPhone(newPhone);
        userPhone.setOldPhone(oldPhone);
        myLearnService.updateUserPhone(userPhone);
    }

    @PostMapping("/updateUserPas")
    public void updateUserPas(String phone,String pas) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(pas);
        myLearnService.updateUserPas(user);
    }
    
}
