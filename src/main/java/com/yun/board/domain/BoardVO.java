package com.yun.board.domain;

import java.sql.Timestamp;

public class BoardVO {
    private int bno;
    private String title;
    private String content;
    private Timestamp regDate;
    private int viewCnt;
    private UserVO userVO;
    
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public UserVO getUserVO() {
        return userVO;
    }
    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
    public int getViewCnt() {
        return viewCnt;
    }
    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
    public Timestamp getRegDate() {
        return regDate;
    }
    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }
    @Override
    public String toString() {
        return "BoardVO [bno=" + bno + ", title=" + title + ", content="
                + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt
                + ", userVO=" + userVO + "]";
    }
    
}


//create table board(
//        bno int primary key NOT NULL,
//           title varchar(100) NOT NULL,
//           content varchar(200) NOT NULL,
//           regDate timestamp NOT NULL default now(),
//           uno int NOT NULL,
//           viewCnt int default 0 NOT NULL,
//           foreign key (uno) references user(uno)
//       );