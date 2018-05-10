package com.example.demo.Model.Entities;

public class Employee {

    private int id;
    private String name;
    private String status;
    private String phone;

    public Employee(){

    }

    public Employee(int id, String name, String status, String phone) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.phone = phone;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
