package com.example.demo.Model.Entities;

public class Member {

    private int id;
    private String name;
    private String mail;
    private boolean newsletter;

    public Member(){

    }

    public Member(int id, String name, String mail, boolean newsletter) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.newsletter = newsletter;
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

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }
}
