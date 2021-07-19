package com.yun.board.domain;

public class UserVO {
    int uno;
    String id;
    String pw;
    String name;
    
    public int getUno() {
        return uno;
    }
    public void setUno(int uno) {
        this.uno = uno;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "UserVO [uno=" + uno + ", id=" + id + ", pw=" + pw + ", name="
                + name + "]";
    }
    
}
