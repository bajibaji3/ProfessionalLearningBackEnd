package com.example.httpdemo.bean;

public class CommentDepend {
    private int owner;
    private int sub;
    //1表示对文章的评论，2表示对视频的评论
    private int type;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
