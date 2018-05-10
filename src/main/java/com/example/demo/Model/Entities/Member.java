package com.example.demo.Model.Entities;

public class Member {

    private int id;
    private String name;
    private String mail;
    private boolean newsLetter;

    public Member(){

    }

    public Member(int id, String name, String mail, boolean newsLetter) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.newsLetter = newsLetter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }
}
